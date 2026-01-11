package com.example.yeniuygulama.ui.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.yeniuygulama.ui.screens.*
import com.example.yeniuygulama.ui.theme.DarkBackground

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Reels : Screen("reels")
    object Explore : Screen("explore")
    object CategoryDetail : Screen("category/{categoryName}") {
        fun createRoute(categoryName: String) = "category/$categoryName"
    }
}

data class BottomNavItem(
    val title: String,
    val route: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainNavigation() {
    val navController = rememberNavController()
    
    val bottomNavItems = listOf(
        BottomNavItem(
            title = "Menü",
            route = Screen.Home.route,
            selectedIcon = Icons.Filled.Home,
            unselectedIcon = Icons.Outlined.Home
        ),
        BottomNavItem(
            title = "Keşfet",
            route = Screen.Reels.route,
            selectedIcon = Icons.Filled.Home, // Will use custom icon
            unselectedIcon = Icons.Outlined.Home
        ),
        BottomNavItem(
            title = "Ara",
            route = Screen.Explore.route,
            selectedIcon = Icons.Filled.Search,
            unselectedIcon = Icons.Outlined.Search
        )
    )
    
    Scaffold(
        containerColor = DarkBackground,
        bottomBar = {
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentDestination = navBackStackEntry?.destination
            
            // Hide bottom bar on category detail
            val showBottomBar = currentDestination?.route?.startsWith("category") != true
            
            if (showBottomBar) {
                NavigationBar(
                    containerColor = DarkBackground
                ) {
                    bottomNavItems.forEachIndexed { index, item ->
                        val selected = currentDestination?.hierarchy?.any { it.route == item.route } == true
                        
                        NavigationBarItem(
                            icon = {
                                if (index == 1) {
                                    // Reels icon - use play icon text
                                    Text(
                                        text = "▶",
                                        style = MaterialTheme.typography.titleLarge,
                                        color = if (selected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurfaceVariant
                                    )
                                } else {
                                    Icon(
                                        imageVector = if (selected) item.selectedIcon else item.unselectedIcon,
                                        contentDescription = item.title
                                    )
                                }
                            },
                            label = { Text(item.title) },
                            selected = selected,
                            colors = NavigationBarItemDefaults.colors(
                                selectedIconColor = MaterialTheme.colorScheme.primary,
                                selectedTextColor = androidx.compose.ui.graphics.Color.White,
                                unselectedIconColor = MaterialTheme.colorScheme.onSurfaceVariant,
                                unselectedTextColor = MaterialTheme.colorScheme.onSurfaceVariant,
                                indicatorColor = androidx.compose.ui.graphics.Color.Transparent
                            ),
                            onClick = {
                                navController.navigate(item.route) {
                                    popUpTo(navController.graph.findStartDestination().id) {
                                        saveState = true
                                    }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            }
                        )
                    }
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Screen.Home.route) {
                HomeScreen()
            }
            composable(Screen.Reels.route) {
                ReelsScreen()
            }
            composable(Screen.Explore.route) {
                ExploreScreen(
                    onCategoryClick = { categoryName ->
                        navController.navigate(Screen.CategoryDetail.createRoute(categoryName))
                    }
                )
            }
            composable(
                route = Screen.CategoryDetail.route,
                arguments = listOf(navArgument("categoryName") { type = NavType.StringType })
            ) { backStackEntry ->
                val categoryName = backStackEntry.arguments?.getString("categoryName") ?: ""
                CategoryDetailScreen(
                    categoryName = categoryName,
                    onBackClick = { navController.popBackStack() }
                )
            }
        }
    }
}
