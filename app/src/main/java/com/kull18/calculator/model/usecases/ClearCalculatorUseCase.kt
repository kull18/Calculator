package com.kull18.calculator.domain.usecase

import com.kull18.calculator.data.repository.CalculatorRepository
import javax.inject.Inject

class ClearCalculatorUseCase @Inject constructor(
    private val repository: CalculatorRepository
) {
    operator fun invoke() {
        repository.clearAll()
    }
}