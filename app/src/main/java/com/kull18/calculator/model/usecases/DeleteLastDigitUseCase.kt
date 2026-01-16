package com.kull18.calculator.domain.usecase

import com.kull18.calculator.data.repository.CalculatorRepository
import javax.inject.Inject

class DeleteLastDigitUseCase @Inject constructor(
    private val repository: CalculatorRepository
) {
    operator fun invoke(displayValue: String): String {
        return repository.removeLastDigit(displayValue)
    }
}