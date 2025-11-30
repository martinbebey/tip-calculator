package com.example.tipcalculator.ui.home

import com.example.tipcalculator.data.repository.TipCalculatorRepositoryImpl
import org.junit.Assert.*

import org.junit.After
import org.junit.Before

class HomeViewModelTest {

    private lateinit var homeViewModel: HomeViewModel
    private lateinit var repositoryImpl: TipCalculatorRepositoryImpl

    /**
     * Executed before each test to initialize any common test resources.
     */
    @Before
    fun setUp() {
        homeViewModel = HomeViewModel(repositoryImpl)
    }

    /**
     * Executed each test to clean up resources, reset state or release any initialized resource during before.
     */
    @After
    fun tearDown() {
    }
}