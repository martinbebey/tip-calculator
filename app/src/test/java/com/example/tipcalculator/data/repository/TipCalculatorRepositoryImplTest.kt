package com.example.tipcalculator.data.repository

import com.example.tipcalculator.data.models.Tip
import com.google.common.truth.Truth.assertThat
import com.google.common.truth.Truth.assertWithMessage
import org.junit.Assert.assertEquals
import org.junit.Test

class TipCalculatorRepositoryImplTest{

    @Test
    fun `calculateTip calculate the tip correctly`(){
        // Given
        val percent = 15f
        val billAmount = 100.0
        val tip = Tip(0, percent)

        // When
        val calculatedTip = TipCalculatorRepositoryImpl().calculateTip(tip, billAmount)

        // Then
        assertThat(calculatedTip).isEqualTo(15.0)
    }

    @Test
    fun `check 0 percent tip is calculated correctly`(){
        // Given
        val percent = 0f
        val billAmount = 100.0
        val tip = Tip(0, percent)

        // When
        val calculatedTip = TipCalculatorRepositoryImpl().calculateTip(tip, billAmount)

        // Then
        assertThat(calculatedTip).isEqualTo(0.0)
    }

    @Test
    fun `check 100 percent tip is calculated correctly`(){
        // Given
        val percent = 100f
        val billAmount = 100.0
        val tip = Tip(0, percent)

        // When
        val calculatedTip = TipCalculatorRepositoryImpl().calculateTip(tip, billAmount)

        // Then
        assertWithMessage("bill amount = $billAmount, tip% = $percent, calculated tip = $calculatedTip").that(calculatedTip).isEqualTo(100.0)
    }
}