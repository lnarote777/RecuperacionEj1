package org.example.Juegos

import org.example.Gestores.GestorConsola

object GeneradorSeries {

    private val consola = GestorConsola()

    /**
     * Genera un par de números aleatorios que representan un rango.
     * Los números están entre 1 y 100, y la diferencia entre ellos es de al menos 30.
     *
     * @return Un par de números que representan el rango generado.
     */
    fun generarRangoAleatorio(): Pair<Int, Int> {
        do {
            val num1 = (1..100).random()
            val num2 = (1..100).random()

            if ((num1 - num2) >= 30) {
                return if (num1 < num2) Pair(num1, num2) else Pair(num2, num1)
            }

        }while (true)

    }

    /**
     * Genera una serie de números dependiendo de la relación del número dado con la mitad del rango.
     * Si el número es mayor o igual que la mitad del rango, genera una serie creciente.
     * Si el número es menor que la mitad del rango, genera una serie decreciente.
     *
     * @param numero El número a partir del cual se genera la serie.
     * @param min El valor mínimo del rango.
     * @param max El valor máximo del rango.
     */
    fun generarSerie(numero: Int, min: Int, max: Int){
        val mitad = (min + max)/2

        if (numero >= mitad){
            serieCreciente(numero, max)
        }else{
            serieDecreciente(numero, min)
        }
    }

    /**
     * Genera una serie creciente de números y muestra la suma total.
     *
     * @param numero El número inicial de la serie.
     * @param max El número máximo de la serie.
     */
    fun serieCreciente(numero: Int, max: Int){
        var suma = 0
        var count = 0
        var sumaStr = ""

        for (i in numero..max){
            val str = "($count)"
            count++
            suma += i
            if (sumaStr.isBlank()) sumaStr += " $i " else sumaStr += " + $i"

            consola.mostrarMensaje(sumaStr)
            consola.mostrarMensaje(str, true)
        }

        consola.mostrarMensaje("Suma -> $suma", true)
    }

    /**
     * Genera una serie decreciente de números y muestra la suma total.
     *
     * @param numero El número inicial de la serie.
     * @param min El número mínimo de la serie.
     */
    fun serieDecreciente(numero: Int, min: Int) {
        var total = 0
        var suma = ""
        var count = 1
        var num = numero
        var numMin = min

        while (num >= numMin) {
            var sum = 0
            var numeros = ""

            for (i in num downTo numMin) {
                sum += i
                numeros += if (i == numMin) "$i" else "$i+"
            }

            total += sum
            suma += "${count++} -> $numeros = $sum\n"
            numMin++
        }

        suma += "Total => $total"
        consola.mostrarMensaje(suma, true)
    }
}