package com.kull18.calculator.domain.usecase

import com.kull18.calculator.data.repository.CalculatorRepository
import javax.inject.Inject

class CalculateResultUseCase @Inject constructor(
    private val repository: CalculatorRepository
) {
    operator fun invoke(
        displayValue: String,
        firstOperand: Int,
        operator: String
    ): String {
        val second = repository.parseNumber(displayValue) ?: return displayValue

        val result = when (operator) {
            "+" -> repository.add(firstOperand, second)
            "-" -> repository.subtract(firstOperand, second)
            "×" -> repository.multiply(firstOperand, second)
            "÷" -> {
                val divisionResult = repository.divide(firstOperand, second)
                if (divisionResult == null) {
                    return "Error"
                }
                divisionResult
            }
            else -> return displayValue
        }

        return result.toString()
    }
}