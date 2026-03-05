package com.example.howexpensive.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.howexpensive.ui.screens.dashboard.DashboardScreen
import com.example.howexpensive.ui.screens.add.AddTransactionScreen

@Composable
fun AppNavGraph() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.DASHBOARD
    ) {
        composable(Routes.DASHBOARD) {
            DashboardScreen(
                onAddClick = { navController.navigate(Routes.ADD_TRANSACTION) }
            )
        }

        composable(Routes.ADD_TRANSACTION) {
            AddTransactionScreen(
                onBack = { navController.popBackStack() }
            )
        }
    }
}