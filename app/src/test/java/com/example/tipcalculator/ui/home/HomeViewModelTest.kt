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

    /**
     * Executed each test to clean up resources, reset state or release any initialized resource during before.
     */
    @After
    fun tearDown() {
    }
}