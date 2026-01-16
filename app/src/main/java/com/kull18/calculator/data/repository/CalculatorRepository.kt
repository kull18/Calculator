package com.kull18.calculator.data.repository

import javax.inject.Inject

class CalculatorRepository @Inject constructor() {
    private var _displayValue: String = "0"

    private var _firstOperand: Int? = null
    private var _currentOperator: String? = null

    private var _shouldResetDisplay: Boolean = false

    // Operaciones matemáticas
    fun add(a: Int, b: Int): Int = a + b

    fun subtract(a: Int, b: Int): Int = a - b

    fun multiply(a: Int, b: Int): Int = a * b

    fun divide(a: Int, b: Int): Int? {
        return if (b == 0) null else a / b
    }

    // Operaciones de validación
    fun isValidNumber(value: String): Boolean {
        return value.toIntOrNull() != null
    }

    fun parseNumber(value: String): Int? {
        return value.toIntOrNull()
    }

    // Operaciones de formato
    fun formatDisplayValue(value: String, shouldReset: Boolean): String {
        return if (shouldReset || value == "0") "" else value
    }

    fun appendDigit(currentValue: String, digit: String): String {
        return currentValue + digit
    }

    fun removeLastDigit(value: String): String {
        return if (value.length > 1) {
            value.dropLast(1)
        } else {
            "0"
        }
    }

    fun clearAll() {
        _displayValue = "0"
        _firstOperand = null
        _currentOperator = null
        _shouldResetDisplay = false
    }
}