package com.example.tipcalculator.data.repository

import com.example.tipcalculator.data.models.Tip
import com.example.tipcalculator.data.repository.TipCalculatorRepository
import kotlin.math.round

class TipCalculatorRepositoryImpl: TipCalculatorRepository {
    override fun calculateTip(
        tip: Tip,
        billAmount: Double
    ): Double {
        return (billAmount * (tip.percent / 100))
    }
}