package com.hardik.movieui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.hardik.movieui.core.route.AppRoute
import com.hardik.movieui.ui.theme.MovieUITheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)
        setContent {
            /// from Accompanist, setting a status bar
            val systemUiController = rememberSystemUiController()
            systemUiController.setSystemBarsColor(
                color = Color.Transparent,
                darkIcons = true
            )
            systemUiController.setNavigationBarColor(
                color = Color.Transparent,
                darkIcons = true
            )
            MovieUITheme {
                /// main navigation
                val navController = rememberNavController()
                AppRoute.GenerateRoute(navController = navController)
            }
      
        }
    }
}
/*
setContent {
    MovieUITheme {
        // A surface container using the 'background' color from the theme
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
            Greeting("Android")
        }
    }
}
*/

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MovieUITheme {
        Greeting("Android")
    }
}