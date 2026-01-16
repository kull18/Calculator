package com.kull18.calculator.domain.usecase

import com.kull18.calculator.data.repository.CalculatorRepository
import javax.inject.Inject

class ProcessNumberInputUseCase @Inject constructor(
    private val repository: CalculatorRepository
) {
    operator fun invoke(
        displayValue: String,
        shouldResetDisplay: Boolean,
        number: String
    ): Pair<String, Boolean> {
        val formattedValue = repository.formatDisplayValue(displayValue, shouldResetDisplay)
        val newDisplayValue = if (formattedValue.isEmpty()) {
            number
        } else {
            repository.appendDigit(formattedValue, number)
        }
        return Pair(newDisplayValue, false)
    }
}
