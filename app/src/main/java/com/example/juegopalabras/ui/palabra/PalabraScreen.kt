package com.example.juegopalabras.ui.palabra

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.style.TextAlign

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PalabraScreen(viewModel: JuegoViewModel = viewModel()) {
    val juegoUiState by viewModel.uiState.collectAsState()
    var textTextFiel by remember { mutableStateOf("") }
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(10.dp)
            .background(Color.DarkGray)
    ) {
        Text(
            modifier = Modifier.align(alignment = Alignment.CenterHorizontally),
            text = "Juego de palabras.",
            fontSize = 25.sp
        )
        Box(
            modifier = Modifier
                .background(Color.Red)
                .padding(10.dp)
        ){
            Column {
                Text(
                    modifier = Modifier
                        .align(alignment = Alignment.End)
                        .background(Color.Black)
                        .padding(4.dp),
                    text = juegoUiState.auxPalabra.toString() +"/10",
                    fontSize = 25.sp,
                    color = Color.Blue
                )
                Text(
                    modifier = Modifier
                        .align(alignment = Alignment.CenterHorizontally)
                        .padding(bottom = 5.dp, top = 5.dp),
                    text = juegoUiState.palabra,
                    fontSize = 35.sp
                )
                Text(
                    modifier = Modifier
                        .align(alignment = Alignment.CenterHorizontally)
                        .padding(bottom = 5.dp, top = 5.dp),
                    text = "Aprende a ordenar palabras.",
                    fontFamily = FontFamily.Cursive
                )
                TextField(
                    modifier = Modifier.padding(bottom = 5.dp, top = 5.dp),
                    value = textTextFiel,
                    onValueChange = {textTextFiel = it}
                )
            }
        }

        Button(
            modifier = Modifier.fillMaxWidth().padding(bottom = 5.dp, top = 5.dp),
            onClick = {
                viewModel.validar(textTextFiel)
            }
        ) {
            Text(text = "Validar")
        }

        Button(
            modifier = Modifier.fillMaxWidth().padding(bottom = 5.dp, top = 5.dp),
            onClick = {
                viewModel.siguiente()
            }
        ) {
            Text(text = "Siguiente")
        }

        Text(
            modifier = Modifier.background(Color.Magenta).padding(bottom = 5.dp, top = 5.dp).width(50.dp),
            text = juegoUiState.puntos.toString(),
            textAlign = TextAlign.Center
        )
    }
}