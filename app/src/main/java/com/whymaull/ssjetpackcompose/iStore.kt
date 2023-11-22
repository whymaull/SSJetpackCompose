package com.whymaull.ssjetpackcompose

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.whymaull.ssjetpackcompose.ui.components.Search
import com.whymaull.ssjetpackcompose.ui.navigation.Item
import com.whymaull.ssjetpackcompose.ui.navigation.Screen
import com.whymaull.ssjetpackcompose.ui.page.account.Profile
import com.whymaull.ssjetpackcompose.ui.page.favorite.FavoritePage
import com.whymaull.ssjetpackcompose.ui.page.home.HomePage
import com.whymaull.ssjetpackcompose.ui.theme.SSJetpackComposeTheme


@Composable
fun IStoreApp(modifier: Modifier = Modifier, navController: NavHostController = rememberNavController()) {

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold(
        topBar = {
            if (currentRoute != Screen.Detail.route) {
                Search(
                    modifier = Modifier.padding(8.dp)
                )
            }
        },
        bottomBar = {
            if (currentRoute != Screen.Detail.route) {
                BottomBar(navController)
            }
        },
        modifier = modifier
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Screen.Home.route) {
                HomePage(

                )
            }
            composable(Screen.Favorite.route) {
                val context = LocalContext.current
                FavoritePage(

                )
            }
            composable(Screen.Profile.route) {
                Profile()
            }

        }
    }
}

@Composable
fun BottomBar(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavigationBar (
        modifier = modifier,
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        val navigationItems = listOf(
            Item(
                title = "Home",
                icon = Icons.Rounded.Home,
                screen = Screen.Home
            ),
            Item(
                title = "Favorite",
                icon = Icons.Rounded.Favorite,
                screen = Screen.Favorite
            ),
            Item(
                title = "Profile",
                icon = Icons.Rounded.Person,
                screen = Screen.Profile
            ),
        )
        navigationItems.map { item ->
            NavigationBarItem(
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = item.title
                    )
                },
                label = { Text(item.title) },
                selected = currentRoute == item.screen.route,
                onClick = {
                    navController.navigate(item.screen.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        restoreState = true
                        launchSingleTop = true
                    }
                }
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun IPreview() {
    SSJetpackComposeTheme {
        IStoreApp()
    }
}


