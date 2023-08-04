package br.senai.sp.jandira.navigation.screen.login.menu

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import br.senai.sp.jandira.navigation.screen.login.menu.ui.theme.NavigationTheme


@Composable
fun MenuScreen(navController: NavHostController) {
    Surface (){
        Column (
            modifier = Modifier
                .background(
                    Color.Blue
                )
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceAround
        )

        {
            Text(text = "Menu")
            Spacer(modifier = Modifier.height(30.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            )
            {
                Button(onClick = { navController.navigate("perfil")}) {
                    Text(text = "Perfil")

                }
                Button(onClick = { navController.navigate("pedidos")}) {
                    Text(text = "Pedidos")

                }

            }
            Button(onClick = { navController.navigate("login") }) {
                Text(text = "Sair")

            }


        }
    }

}

