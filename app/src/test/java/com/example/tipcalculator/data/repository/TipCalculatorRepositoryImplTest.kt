package com.example.tipcalculator.data.repository

import com.example.tipcalculator.data.models.Tip
import com.google.common.truth.Truth.assertThat
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
}