package com.example.tipcalculator.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.traceEventStart
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tipcalculator.ui.theme.TipCalculatorTheme
import com.example.tipcalculator.utils.TestTags

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    homeViewModel: HomeViewModel
) {
    val homeState = homeViewModel.homeState
    val (billAmount, setBillAmount) = rememberSaveable { mutableStateOf("") }
    val (tipPercent, setTipPercent) = rememberSaveable { mutableStateOf("") }
    HomeScreen(
        modifier = modifier.testTag(TestTags.homeScreen),
        homeState = homeState,
        onGetTipClick = {
            homeViewModel.getTipAmount(
                billAmount = billAmount.toDouble(),
                percent = tipPercent.toFloat()
            )
        },
        onResetClick = {
            setBillAmount("")
            setTipPercent("")
            homeViewModel.reset()
        },
        billAmount = billAmount,
        tipPercent = tipPercent,
        setBillAmount = setBillAmount,
        setTipPercent = setTipPercent
    )
}

@Composable
private fun HomeScreen(
    modifier: Modifier,
    homeState: HomeState,
    billAmount: String,
    tipPercent: String,
    setBillAmount: (String) -> Unit,
    setTipPercent: (String) -> Unit,
    onGetTipClick: () -> Unit,
    onResetClick: () -> Unit
) {
    Column(modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        OutlinedTextField(
            value = billAmount,
            onValueChange = setBillAmount,
            label = { Text(text = "Bill") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            ),
            modifier = Modifier.testTag(TestTags.billInputText)
        )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = tipPercent,
            onValueChange = setTipPercent,
            label = { Text(text = "Tip percent") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            ),
            modifier = Modifier.testTag(TestTags.tipInputText)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Row {
            Button(
                onClick = onGetTipClick,
                modifier = Modifier.testTag(TestTags.getTipButton)
            ) {
                Text(text = "Get Tip")
            }
            Spacer(modifier = Modifier.width(16.dp))
            Button(
                onClick = onResetClick,
                modifier = Modifier.testTag(TestTags.resetButton)
            ) {
                Text(text = "Clear")
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Tip amount ${homeState.tipAmount}",
            modifier = Modifier.testTag(TestTags.tipText)
        )
    }
}

@Preview
@Composable
private fun HomeScreenPrev() {
    TipCalculatorTheme {
        HomeScreen(
            modifier = Modifier,
            homeState = HomeState(),
            billAmount = "",
            tipPercent = "",
            setBillAmount = {},
            setTipPercent = {},
            onGetTipClick = {},
            onResetClick = {}
        )
    }
}