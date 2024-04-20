package org.example.Juegos

import com.google.gson.Gson
import java.io.File

class Palabra {
    companion object{
        const val RUTA_TEXTO = "src/palabras.txt"
        const val RUTA_JSON = "src/palabras.json"
        const val ES_JSON = true

        data class Palabras(val palabras: List<String>)

        /**
         * Lee el fichero de texto
         *
         * @return una lista con las palabras del fichero de texto
         */
        private fun leerFicheroTexto(ruta: String): List<String> = File(ruta).readLines()

        /**
         * Lee el fichero json
         * @return una lista con las palabras del fichero json
         */
        private fun leerFicheroJSON(ruta: String): List<String> {
            val json = File(ruta).readText()
            return Gson().fromJson(json, Palabras::class.java).palabras
        }

        /**
         * Obtiene una palabra aleatoria.
         *
         * @return La palabra aleatoria obtenida.
         */
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