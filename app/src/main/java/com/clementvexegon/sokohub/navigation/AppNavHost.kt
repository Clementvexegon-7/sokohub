package com.clementvexegon.sokohub.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx. navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.clementvexegon.sokohub.ui.screens.about.AboutScreen
import com.clementvexegon.sokohub.ui.screens.auth.LoginScreen
import com.clementvexegon.sokohub.ui.screens.auth.RegisterScreen
import com.clementvexegon.sokohub.ui.screens.home.HomeScreen
import com.clementvexegon.sokohub.ui.screens.onboarding.OnboardingScreen
import com.clementvexegon.sokohub.ui.screens.service.ServiceScreen

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = ROUT_HOME
) {

    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable(ROUT_HOME) {
            HomeScreen(navController)
        }
        composable(ROUT_ABOUT) {
            AboutScreen(navController)
        }

        composable(ROUT_LOGIN) {
            LoginScreen(navController)
        }

        composable(ROUT_REGISTER) {
            RegisterScreen(navController)
        }

        composable(ROUT_ONBOARDING) {
            OnboardingScreen(navController)
        }

        composable(ROUT_SERVICE) {
            ServiceScreen(navController)
        }


    }
}