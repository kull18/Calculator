package com.kull18.calculator.presentation.components.organisms

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.kull18.calculator.presentation.components.molecules.HeadCalculator
import com.kull18.calculator.presentation.components.molecules.NumberPad
import com.kull18.calculator.presentation.components.molecules.OperatorPanel
import com.kull18.calculator.presentation.viewmodels.CalculatorViewModel

@Composable
fun CalculatorKeyboard(
    viewModel: CalculatorViewModel = viewModel()
) {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.background)
    ) {
        HeadCalculator(displayValue = viewModel.displayValue)

        Spacer(modifier = Modifier.height(16.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(450.dp)
                .background(MaterialTheme.colorScheme.surfaceContainer)
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                NumberPad(
                    onNumberClick = viewModel::onNumberClick,
                    modifier = Modifier.weight(3f)
                )

                Spacer(modifier = Modifier.padding(8.dp))

                OperatorPanel(
                    onOperatorClick = viewModel::onOperatorClick,
                    modifier = Modifier.weight(1f)
                )
            }
        }
    }
}