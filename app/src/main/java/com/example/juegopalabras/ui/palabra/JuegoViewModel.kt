package com.example.juegopalabras.ui.palabra

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class JuegoViewModel: ViewModel() {

    private val _uiState = MutableStateFlow(JuegoUiState())
    val uiState: StateFlow<JuegoUiState> = _uiState.asStateFlow()


    fun validar(valoActualTextField:String){
        if(valoActualTextField == _uiState.value.palabra){
            var auxnumPalabra = _uiState.value.auxPalabra
            auxnumPalabra++
            if(auxnumPalabra == 11){
                _uiState.update { currentState -> currentState.copy(
                    auxPalabra = 1,
                    palabra = DatosPalabras.allWords.random(),
                    puntos = 0,
                )  }
            }else{
                var newPuntos = _uiState.value.puntos
                newPuntos+=10
                var auxnumPalabra = _uiState.value.auxPalabra
                auxnumPalabra++
                _uiState.update { currentState -> currentState.copy(
                    auxPalabra = auxnumPalabra,
                    palabra = DatosPalabras.allWords.random(),
                    puntos = newPuntos,
                )  }
            }
        }else{
            var auxnumPalabra = _uiState.value.auxPalabra
            auxnumPalabra++
            if(auxnumPalabra == 11){
                _uiState.update { currentState -> currentState.copy(
                    auxPalabra = 1,
                    palabra = DatosPalabras.allWords.random(),
                    puntos = 0,
                )  }
            }else{
                var auxnumPalabra = _uiState.value.auxPalabra
                auxnumPalabra++
                _uiState.update { currentState -> currentState.copy(
                    auxPalabra = auxnumPalabra,
                    palabra = DatosPalabras.allWords.random(),
                )  }
            }
        }
    }

    fun siguiente(){
        var auxnumPalabra = _uiState.value.auxPalabra
        auxnumPalabra++


        if(auxnumPalabra==11){
            _uiState.update { currentState -> currentState.copy(
                auxPalabra = 0,
                palabra = DatosPalabras.allWords.random()
            )  }
        }else{
            _uiState.update { currentState -> currentState.copy(
                auxPalabra = auxnumPalabra,
                palabra = DatosPalabras.allWords.random()
            )  }
        }


    }

}