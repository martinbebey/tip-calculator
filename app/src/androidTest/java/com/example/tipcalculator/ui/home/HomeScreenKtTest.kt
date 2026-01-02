package com.example.tipcalculator.ui.home

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsNotDisplayed
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onRoot
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.compose.ui.test.printToLog
import com.example.tipcalculator.data.repository.TipCalculatorRepository
import com.example.tipcalculator.data.repository.TipCalculatorRepositoryImpl
import com.example.tipcalculator.ui.theme.TipCalculatorTheme
import com.example.tipcalculator.utils.TestTags
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
//        composeTestRule.onRoot().printToLog(tag = "homescreen")
        composeTestRule.onNodeWithTag(TestTags.homeScreen).assertIsDisplayed()
    }

    @Test
    fun error_displayed_when_badData_isPassed(){
        errorText().assertIsNotDisplayed()
        homeViewModel.getTipAmount(-20f, 100.0)
        errorText().assertExists()
    }

    private fun errorText() = composeTestRule.onNodeWithContentDescription("error")

    @Test
    fun validate_User_input(){
        composeTestRule.onNodeWithTag(TestTags.billInputText).performTextInput("10")
        composeTestRule.onNodeWithTag(TestTags.tipInputText).performTextInput("10")
        composeTestRule.onNodeWithTag(TestTags.getTipButton).performClick()
        composeTestRule.onNodeWithTag(TestTags.tipText).assertIsDisplayed().assertTextEquals("Tip amount 1.0")
    }
}