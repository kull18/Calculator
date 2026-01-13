package com.kull18.calculator.presentation.components.molecules

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.kull18.calculator.presentation.components.atoms.ButtonCalculator

@Composable
fun NumberPad(
    onNumberClick: (String) -> Unit = {},
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Row(
            modifier = Modifier.weight(1f),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            ButtonCalculator(
                text = "7",
                onClick = { onNumberClick("7") },
                modifier = Modifier.weight(1f)
            )
            ButtonCalculator(
                text = "8",
                onClick = { onNumberClick("8") },
                modifier = Modifier.weight(1f)
            )
            ButtonCalculator(
                text = "9",
                onClick = { onNumberClick("9") },
                modifier = Modifier.weight(1f)
            )
        }

        Row(
            modifier = Modifier.weight(1f),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            ButtonCalculator(
                text = "4",
                onClick = { onNumberClick("4") },
                modifier = Modifier.weight(1f)
            )
            ButtonCalculator(
                text = "5",
                onClick = { onNumberClick("5") },
                modifier = Modifier.weight(1f)
            )
            ButtonCalculator(
                text = "6",
                onClick = { onNumberClick("6") },
                modifier = Modifier.weight(1f)
            )
        }

        Row(
            modifier = Modifier.weight(1f),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            ButtonCalculator(
                text = "1",
                onClick = { onNumberClick("1") },
                modifier = Modifier.weight(1f)
            )
            ButtonCalculator(
                text = "2",
                onClick = { onNumberClick("2") },
                modifier = Modifier.weight(1f)
            )
            ButtonCalculator(
                text = "3",
                onClick = { onNumberClick("3") },
                modifier = Modifier.weight(1f)
            )
        }

        Row(
            modifier = Modifier.weight(1f),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            ButtonCalculator(
                text = "0",
                onClick = { onNumberClick("0") },
                modifier = Modifier.weight(2f) // Ocupa doble espacio
            )
            ButtonCalculator(
                text = ".",
                onClick = { onNumberClick(".") },
                modifier = Modifier.weight(1f)
            )
        }
    }
}