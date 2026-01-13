package com.kull18.calculator.presentation.components.organisms

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.kull18.calculator.presentation.components.molecules.HeadCalculator
import com.kull18.calculator.presentation.components.molecules.NumberPad

@Composable
fun CalculatorKeyboard() {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .height(600.dp)
            .background(MaterialTheme.colorScheme.background)
    ) {
        HeadCalculator()
        Box(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth()
                .height(300.dp)
                .background(MaterialTheme.colorScheme.surfaceContainer)
        ) {
            NumberPad()
        }
    }
}