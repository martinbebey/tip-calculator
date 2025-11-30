package com.example.tipcalculator.ui.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.tipcalculator.data.models.Tip
import com.example.tipcalculator.data.repository.TipCalculatorRepository
import java.util.Date
import java.util.UUID

class HomeViewModel(
    private val repository: TipCalculatorRepository
) : ViewModel() {
    var homeState by mutableStateOf(HomeState())
        private set

    fun getTipAmount(percent: Float, billAmount: Double) {
        val tip = Tip(id = Date().time, percent = percent)
        homeState = homeState.copy(
            tipAmount = repository.calculateTip(tip, billAmount),
            error = if(percent < 0) "ERROR" else null
        )
    }

    fun reset() {
        homeState = HomeState()
    }


}

data class HomeState(
    val tipAmount: Double = 0.0,
    val error: String? = null
)

@Suppress("UNCHECKED_CAST")
class HomeViewModelFactory(private val repository: TipCalculatorRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return HomeViewModel(repository = repository) as T
    }
}