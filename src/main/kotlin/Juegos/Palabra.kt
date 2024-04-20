package org.example.Juegos

import com.google.gson.Gson
import java.io.File

class Palabra {
    companion object{
        const val RUTA_TEXTO = "src/palabras.txt"
        const val RUTA_JSON = "src/palabras.json"
        const val ES_JSON = true

        data class Palabras(val palabras: List<String>)

        private fun leerFicheroTexto(ruta: String): List<String> = File(ruta).readLines()

        private fun leerFicheroJSON(ruta: String): List<String> {
            val json = File(ruta).readText()
            return Gson().fromJson(json, Palabras::class.java).palabras
        }

        fun obtenerPalabraAleatoria(): String{
            var palabras: List<String>
            var palabra : String

            if (ES_JSON) {
                palabras = leerFicheroJSON(RUTA_JSON)
                palabra = palabras.random()
            } else {
                palabras = leerFicheroTexto(RUTA_TEXTO)
                palabra = palabras.random()
            }

            return palabra

        }
    }
}