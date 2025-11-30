package com.example.tipcalculator.data.repository

import com.example.tipcalculator.data.models.Tip
import com.example.tipcalculator.data.repository.TipCalculatorRepository
import kotlin.math.round

class TipCalculatorRepositoryImpl: TipCalculatorRepository {
    override fun calculateTip(
        tip: Tip,
        billAmount: Double
    ): Double {
        if(tip.percent < 0) throw IllegalArgumentException("Tip percent cannot be negative")
        else if(tip.percent > 100) throw IllegalArgumentException("Tip percent cannot be greater than 100%")
        else if(billAmount < 0) throw IllegalArgumentException("Bill amount cannot be negative")
        return round((billAmount * (tip.percent / 100)))
    }
}