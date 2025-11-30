package com.example.tipcalculator.ui.home

import com.example.tipcalculator.data.repository.TipCalculatorRepositoryImpl
import org.junit.Assert.*
import com.google.common.truth.Truth.assertThat

import org.junit.After
import org.junit.Before
import org.junit.Test
import kotlin.math.exp

class HomeViewModelTest {

    private lateinit var homeViewModel: HomeViewModel
    private lateinit var repositoryImpl: TipCalculatorRepositoryImpl

    /**
     * Executed before each test to initialize any common test resources.
     */
    @Before
    fun setUp() {
        repositoryImpl = TipCalculatorRepositoryImpl()
        homeViewModel = HomeViewModel(repositoryImpl)
    }

    @Test
    fun `Initial state should be empty`(){
        // Given
        val initialTipState = homeViewModel.homeState.tipAmount
        val expected = 0.0

        // Then
        assertThat(initialTipState).isEqualTo(expected)
    }

    @Test
    fun `getTip should getTip and update the state correctly`(){
        // Given
        val percent = 10f
        val billAmount = 200.0

        // When
        homeViewModel.getTipAmount(percent, billAmount)
        val actualState = homeViewModel.homeState.tipAmount
        val expectedTipStateAmount = 20

        // Then
        assertThat(actualState).isEqualTo(expectedTipStateAmount)
    }

    /**
     * Executed each test to clean up resources, reset state or release any initialized resource during before.
     */
    @After
    fun tearDown() {
    }
}