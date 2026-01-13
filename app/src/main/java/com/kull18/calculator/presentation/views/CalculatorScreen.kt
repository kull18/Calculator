package com.kull18.calculator.presentation.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kull18.calculator.presentation.components.molecules.HeadCalculator
import com.kull18.calculator.presentation.components.organisms.AppTopBar
import com.kull18.calculator.presentation.components.organisms.CalculatorKeyboard


@Composable
fun CalculatorScaffold(
    appTopBar: @Composable (() -> Unit)? = null,
    content: @Composable (PaddingValues) -> Unit
) {
    Scaffold(
        topBar = { appTopBar?.invoke() }
    ) { padding ->

        Box(
            modifier = Modifier.fillMaxSize()
                .padding(padding)
                .background(MaterialTheme.colorScheme.onPrimary),
            contentAlignment = Alignment.Center
        ) {
            content(padding)
        }
    }
}

@Composable
fun MainCalculatorScreen() {
    CalculatorScaffold(
        appTopBar = { AppTopBar() }
    ) {
        CalculatorKeyboard()
    }
}



@Composable
@Preview(showBackground = true)
fun MainCalculator() {
    MainCalculatorScreen()
}

