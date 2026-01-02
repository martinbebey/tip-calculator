package com.example.tipcalculator.ui.home

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onRoot
import androidx.compose.ui.test.printToLog
import com.example.tipcalculator.data.repository.TipCalculatorRepository
import com.example.tipcalculator.data.repository.TipCalculatorRepositoryImpl
import com.example.tipcalculator.ui.theme.TipCalculatorTheme
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class HomeScreenKtTest{

    private lateinit var repository:TipCalculatorRepository
    private lateinit var homeViewModel: HomeViewModel

    @get:Rule // Applies before and after every test
    val composeTestRule = createComposeRule()

    @Before // Runs before each test
    fun setup(){
        repository = TipCalculatorRepositoryImpl()
        homeViewModel = HomeViewModel(repository)
        composeTestRule.setContent {
            TipCalculatorTheme {
                HomeScreen(homeViewModel = homeViewModel)
            }
        }
    }



    @Test
    fun app_launches(){
        composeTestRule.onRoot().printToLog(tag = "homescreen")
    }
}