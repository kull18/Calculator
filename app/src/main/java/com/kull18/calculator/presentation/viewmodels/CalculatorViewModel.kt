package com.kull18.calculator.presentation.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class CalculatorViewModel : ViewModel() {
    var displayValue by mutableStateOf("0")
        private set

    private var firstOperand: Int? = null
    private var currentOperator: String? = null
    private var shouldResetDisplay = false

    fun onNumberClick(number: String) {
        if (shouldResetDisplay || displayValue == "0") {
            displayValue = number
            shouldResetDisplay = false
        } else {
            displayValue += number
        }
    }

    fun onOperatorClick(operator: String) {
        when (operator) {
            "=" -> calculateResult()
            "C" -> clear()
            "⌫" -> deleteLast()
            "+", "-", "×", "÷" -> setOperator(operator)
        }
    }

    private fun setOperator(operator: String) {
        if (firstOperand != null && currentOperator != null && !shouldResetDisplay) {
            calculateResult()
        }

        firstOperand = displayValue.toIntOrNull()
        currentOperator = operator
        shouldResetDisplay = true
    }

    private fun calculateResult() {
        val first = firstOperand ?: return
        val second = displayValue.toIntOrNull() ?: return
        val operator = currentOperator ?: return

        val result = when (operator) {
            "+" -> first + second
            "-" -> first - second
            "×" -> first * second
            "÷" -> {
                if (second == 0) {
                    displayValue = "Error"
                    clear()
                    return
                }
                first / second
            }
            else -> return
        }

        displayValue = result.toString()
        firstOperand = null
        currentOperator = null
        shouldResetDisplay = true
    }

    private fun clear() {
        displayValue = "0"
        firstOperand = null
        currentOperator = null
        shouldResetDisplay = false
    }

    private fun deleteLast() {
        if (displayValue.length > 1) {
            displayValue = displayValue.dropLast(1)
        } else {
            displayValue = "0"
        }
    }
}