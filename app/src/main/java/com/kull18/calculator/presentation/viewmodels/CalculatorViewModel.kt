package com.kull18.calculator.presentation.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.kull18.calculator.domain.usecase.*
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CalculatorViewModel @Inject constructor(
    private val processNumberInputUseCase: ProcessNumberInputUseCase,
    private val processOperatorUseCase: ProcessOperatorUseCase,
    private val calculateResultUseCase: CalculateResultUseCase,
    private val clearCalculatorUseCase: ClearCalculatorUseCase,
    private val deleteLastDigitUseCase: DeleteLastDigitUseCase
) : ViewModel() {

    var displayValue by mutableStateOf("0")
        private set

    private var firstOperand: Int? = null
    private var currentOperator: String? = null
    private var shouldResetDisplay = false

    fun onNumberClick(number: String) {
        val (newDisplayValue, newShouldReset) = processNumberInputUseCase(
            displayValue = displayValue,
            shouldResetDisplay = shouldResetDisplay,
            number = number
        )

        displayValue = newDisplayValue
        shouldResetDisplay = newShouldReset
    }

    fun onOperatorClick(operator: String) {
        when (operator) {
            "=" -> {
                if (firstOperand != null && currentOperator != null) {
                    val result = calculateResultUseCase(
                        displayValue = displayValue,
                        firstOperand = firstOperand!!,
                        operator = currentOperator!!
                    )

                    displayValue = result
                    firstOperand = null
                    currentOperator = null
                    shouldResetDisplay = true
                }
            }
            "C" -> {
                clearCalculatorUseCase()

                displayValue = "0"
                firstOperand = null
                currentOperator = null
                shouldResetDisplay = false
            }
            "⌫" -> {
                val newDisplayValue = deleteLastDigitUseCase(displayValue)
                displayValue = newDisplayValue
            }
            "+", "-", "×", "÷" -> {
                val result = processOperatorUseCase(
                    displayValue = displayValue,
                    firstOperand = firstOperand,
                    currentOperator = currentOperator,
                    shouldResetDisplay = shouldResetDisplay,
                    operator = operator
                )

                displayValue = result.displayValue
                firstOperand = result.firstOperand
                currentOperator = result.currentOperator
                shouldResetDisplay = result.shouldResetDisplay
            }
        }
    }
}