package com.example.juegopalabras.ui.palabra

data class JuegoUiState(
    val palabra:String = DatosPalabras.allWords.random(),
    val puntos:Int =0,
    val auxPalabra:Int =1,

)
