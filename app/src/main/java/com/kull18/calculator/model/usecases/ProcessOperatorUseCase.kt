package com.kull18.calculator.domain.usecase

import com.kull18.calculator.data.repository.CalculatorRepository
import javax.inject.Inject

class ProcessOperatorUseCase @Inject constructor(
    private val repository: CalculatorRepository,
    private val calculateResultUseCase: CalculateResultUseCase
) {
    data class OperatorResult(
        val displayValue: String,
        val firstOperand: Int?,
        val currentOperator: String?,
        val shouldResetDisplay: Boolean
    )

    operator fun invoke(
        displayValue: String,
        firstOperand: Int?,
        currentOperator: String?,
        shouldResetDisplay: Boolean,
        operator: String
    ): OperatorResult {
        // Si ya hay una operación pendiente, calcular primero
        val currentDisplay = if (
            firstOperand != null &&
            currentOperator != null &&
            !shouldResetDisplay
        ) {
            calculateResultUseCase(displayValue, firstOperand, currentOperator)
        } else {
            displayValue
        }

        val newFirstOperand = repository.parseNumber(currentDisplay)

        return OperatorResult(
            displayValue = currentDisplay,
            firstOperand = newFirstOperand,
            currentOperator = operator,
            shouldResetDisplay = true
        )
    }
}