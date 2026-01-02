package com.example.tipcalculator.ui.home

import androidx.compose.ui.test.junit4.createComposeRule
import com.example.tipcalculator.data.repository.TipCalculatorRepository
import com.example.tipcalculator.data.repository.TipCalculatorRepositoryImpl
import com.example.tipcalculator.ui.theme.TipCalculatorTheme
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule

class HomeScreenKtTest{

    private lateinit var repository:TipCalculatorRepository
    private lateinit var homeViewModel: HomeViewModel

    @get:Rule
    val composeTestRule = createComposeRule()

    @Before
    fun setup(){
        repository = TipCalculatorRepositoryImpl()
        homeViewModel = HomeViewModel(repository)
        composeTestRule.setContent {
            TipCalculatorTheme {
                HomeScreen(homeViewModel = homeViewModel)
            }
        }
    }
}