package br.senai.sp.jandira.navigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.shrinkHorizontally
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
//import androidx.navigation.compose.NavHost
//import androidx.navigation.compose.composable
//import androidx.navigation.compose.rememberNavController
import br.senai.sp.jandira.navigation.screen.login.loginScreen
import br.senai.sp.jandira.navigation.screen.login.menu.MenuScreen
import br.senai.sp.jandira.navigation.screen.login.pedidos.PedidosScreen
import br.senai.sp.jandira.navigation.screen.login.voltar.VoltarScreen
import br.senai.sp.jandira.navigation.ui.theme.NavigationTheme
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.google.accompanist.navigation.animation.composable

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalAnimationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavigationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                   val navController = rememberAnimatedNavController()
                    AnimatedNavHost(
                        navController = navController,
                        startDestination = "login",
                        exitTransition = {
                            //slideOutOfContainer(
                                //AnimatedContentScope.SlideDirection.End,
                                //tween(1000)
                            //)
                             shrinkHorizontally(tween(2000)) +
                                     fadeOut(tween(2000)) +
                                     slideOutOfContainer(AnimatedContentScope.SlideDirection.Down,
                                         tween(2000)
                                     )
                        },
                        enterTransition = {
                          //  scaleIn(tween(2000))
                            expandVertically(tween(3000))
                        }
                    ){
                        composable(route = "Login"){ loginScreen(navController)}
                        composable(route = "menu"){ MenuScreen(navController)}
                        composable(route = "perfil"){ VoltarScreen(navController)}
                        composable(route = "pedidos"){ PedidosScreen(navController) }
                    }
                }
            }
        }
    }
}

