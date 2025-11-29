package com.example.tipcalculator.data.repository

import com.example.tipcalculator.data.models.Tip

interface TipCalculatorRepository {
    fun calculateTip(
        tip: Tip,
        billAmount: Double
    ): Double
}