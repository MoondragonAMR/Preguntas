package com.example.preguntas.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.preguntas.R

@Composable
fun Pregunta() {
    val preguntas = CrearPreguntas()
    var respuesta by remember { mutableStateOf(true)}
    var respondida by remember { mutableStateOf(false)}
    var mensaje by remember { mutableStateOf("")}
    var color by remember { mutableStateOf(Color.White)}
    var color1 by remember { mutableStateOf(Color.Cyan)}
    var color2 by remember { mutableStateOf(Color.Cyan)}
    var contador by remember { mutableStateOf(0)}
    var texto by remember { mutableStateOf(preguntas.get(contador).texto)}
    var imagen by remember { mutableStateOf(preguntas.get(contador).imagen)}

    Column{
        Text(texto)
        Image(imagen, "Imagen de la pregunta")
        Text(text = mensaje, color = color)
        Row{
            Button(onClick = { respuesta = true; respondida = true}, colors = ButtonDefaults.buttonColors(color1)) {
                Text("Verdadero", color = Color.White)
            }
            Button(onClick = { respuesta = false; respondida = true}, colors = ButtonDefaults.buttonColors(color2)) {
                Text("Falso", color = Color.White)
            }
        }
        Row {
            Button(onClick = {
                if (contador == 0) {
                    contador = 4
                } else contador--
                color = Color.White
                color1 = Color.Cyan
                color2 = Color.Cyan
                respondida = false
                texto = preguntas.get(contador).texto
                imagen = preguntas.get(contador).imagen
            }) {
                Row {
                    Icon(Icons.Default.ArrowBack, "Icono de flecha atrás")
                    Text("Anterior", color = Color.White)
                }
            }
            Button(onClick = {
                if (contador == 4) {
                    contador = 0
                } else contador++
                color = Color.White
                color1 = Color.Cyan
                color2 = Color.Cyan
                respondida = false
                texto = preguntas.get(contador).texto
                imagen = preguntas.get(contador).imagen
            }) {
                Row {
                    Text("Siguiente", color = Color.White)
                    Icon(Icons.Default.ArrowForward, "Icono de flecha adelante")
                }
            }
        }
    }
    if (respondida) {
        if (respuesta) {
            if (preguntas.get(contador).resultado) {
                mensaje = "¡Correcto!"
                color = Color.Green
                color1 = Color.Green
                color2 = Color.Red
            } else {
                mensaje = "Incorrecto"
                color = Color.Red
                color1 = Color.Red
                color2 = Color.Green
            }
        } else {
            if (preguntas.get(contador).resultado) {
                mensaje = "¡Correcto!"
                color = Color.Green
                color2 = Color.Green
                color1 = Color.Red
            } else {
                mensaje = "Incorrecto"
                color = Color.Red
                color2 = Color.Red
                color1 = Color.Green
            }
        }
    }
}


@Preview
@Composable
fun PreguntaPreview(){
    Pregunta()
}

@Composable
fun CrearPreguntas(): List<Preguntas>{
    val listaPreguntas = mutableListOf<Preguntas>()
    val pregunta1 = Preguntas("El sirope de chocolate está disponible en Papa's Pancakeria", painterResource(id = R.mipmap.chocolate_syrup_foreground), false)
    listaPreguntas.add(pregunta1)
    val pregunta2 = Preguntas("El máximo de miis que puedes crear en Super Smash Bros Ultimate es 99", painterResource(id = R.mipmap.mii_foreground), true)
    listaPreguntas.add(pregunta2)
    val pregunta3 = Preguntas("Yelena es un personaje inicial en Everybody's Tennis", painterResource(id = R.mipmap.yelena_foreground), true)
    listaPreguntas.add(pregunta3)
    val pregunta4 = Preguntas("La Planta Piraña está disponible en el selector base de Super Smash Bros Ultimate", painterResource(id = R.mipmap.planta_foreground), false)
    listaPreguntas.add(pregunta4)
    val pregunta5 = Preguntas("El juego con más toppings es Papa's Cluckeria", painterResource(id = R.mipmap.topping_foreground), true)
    listaPreguntas.add(pregunta5)
    return listaPreguntas
}