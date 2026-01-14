package com.kull18.calculator.presentation.components.molecules

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.kull18.calculator.presentation.components.atoms.OperatorButton

@Composable
fun OperatorPanel(
    onOperatorClick: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxHeight(),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        OperatorButton(
            text = "÷",
            onClick = { onOperatorClick("÷") },
            modifier = Modifier.weight(1f)
        )
        OperatorButton(
            text = "×",
            onClick = { onOperatorClick("×") },
            modifier = Modifier.weight(1f)
        )
        OperatorButton(
            text = "-",
            onClick = { onOperatorClick("-") },
            modifier = Modifier.weight(1f)
        )
        OperatorButton(
            text = "+",
            onClick = { onOperatorClick("+") },
            modifier = Modifier.weight(1f)
        )
        OperatorButton(
            text = "=",
            onClick = { onOperatorClick("=") },
            modifier = Modifier.weight(1f),
            isEquals = true
        )
    }
}