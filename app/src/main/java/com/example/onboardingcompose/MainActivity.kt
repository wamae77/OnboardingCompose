package com.example.onboardingcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.onboardingcompose.ui.onboarding_screens.CountrySelectionScreen
import com.example.onboardingcompose.ui.onboarding_screens.EmploymentDetailsScreen
import com.example.onboardingcompose.ui.onboarding_screens.PreviewEmploymentDetailsScreen
import com.example.onboardingcompose.ui.theme.OnboardingComposeTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OnboardingComposeTheme {
                // A surface container using the 'background' color from the theme
                val navController = rememberNavController()
                Scaffold(modifier = Modifier.fillMaxSize(), topBar = {
                    TopAppBar(
                        title = {
                            navController.currentDestination?.displayName?.let {
                                Text(
                                    it, maxLines = 1, overflow = TextOverflow.Ellipsis
                                )
                            }
                        },
                        navigationIcon = {
                            IconButton(onClick = {
                                navController.popBackStack()
                            }) {
                                Icon(Icons.Default.KeyboardArrowLeft, contentDescription = "back")
                            }
                        },

                        )
                }

                ) { paddingValues ->
                    NavHost(
                        navController = navController,
                        startDestination = CountrySelection.route,
                        modifier = Modifier.padding(paddingValues)
                    ) {
                        composable(route = CountrySelection.route) {
                            CountrySelectionScreen(onClick = {
                                navController.navigateSingleTopTo(
                                    EmploymentDetails.route
                                )
                            })
                        }
                        composable(route = EmploymentDetails.route) {
                            EmploymentDetailsScreen(navigate = {
                                navController.navigateSingleTopTo(
                                    PersonalInfo.route
                                )
                            })
                        }
                        composable(route = PersonalInfo.route) {
                            PreviewEmploymentDetailsScreen(navigate = {})
                        }
                    }
                }
            }
        }
    }
}

fun NavHostController.navigateSingleTopTo(route: String) =
    this.navigate(route) { launchSingleTop = true }

