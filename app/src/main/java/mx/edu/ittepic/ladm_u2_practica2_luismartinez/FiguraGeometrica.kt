package mx.edu.ittepic.ladm_u2_practica2_luismartinez

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Paint
import android.view.MotionEvent


class FiguraGeometrica() {
    var x = 0f
    var y = 0f
    var tipo = 1 //1 circulo 2 rectangulo // 3 bitmap
    var radio = 0f
    var ancho = 0f
    var alto = 0f
    var incX = 1
    var incY = 1
    var bitmap: Bitmap? = null
    var tamanoTexto = 0f
    var texto = ""

    constructor(x: Int, y: Int, radio: Int) : this() {
        this.x = x.toFloat()
        this.y = y.toFloat()
        this.radio = radio.toFloat()
        //////////////////////////////////////////////////
        ancho = this.radio * 2
        alto = ancho

        if(this.radio<20){
            incX=5
            incY=5
        }
        if(this.radio>=20 && radio<50){
            incX=3
            incY=3
        }
        if(this.radio>=50){
            incX=1
            incY=1
        }
    }

    constructor(x: Int, y: Int, ancho: Int, alto: Int) : this() {
        this.x = x.toFloat()
        this.y = y.toFloat()
        this.ancho = ancho.toFloat()
        this.alto = alto.toFloat()
        tipo = 2
    }

    constructor(imagen: Bitmap, x: Int, y: Int) : this() {
        bitmap = imagen
        this.x = x.toFloat()
        this.y = y.toFloat()
        ancho = bitmap!!.width.toFloat()
        alto = bitmap!!.height.toFloat()
        tipo = 3

    }

    fun pintar(c: Canvas, p: Paint) {
        when (tipo) {
            1 -> {
                //////////////////////////////////////////////////
                c.drawCircle(x + radio, y + radio, radio, p)
            }
            2 -> {
                c.drawRect(x, y, x + ancho, y + alto, p)
            }

            3 -> {
                c.drawBitmap(bitmap!!, x, y, p)
            }

        }
    }

    fun estaEnArea(event: MotionEvent): Boolean {
        if (event.x >= x && event.x <= x + ancho) {
            if (event.y >= y && event.y <= y + alto) {
                return true
            }
        }
        return false
    }

    fun estaEnArea(posX: Float, posY: Float): Boolean {
        if (posX >= x && posX <= x + ancho) {
            if (posY >= y && posY <= y + alto) {
                return true
            }
        }
        return false
    }

    fun arrastrar(event: MotionEvent) {
        x = event.x - (ancho / 2)
        y = event.y - (alto / 2)
    }

    fun rebote(ancho: Int, alto: Int) {

        x += incX
        if (x <= -100 || x >= ancho) {
            incX *= -1
        }
        y += incY
        if (y <= -100 || y >= alto) {
            incY *= -1
        }

    }

    fun colision(objetoB: FiguraGeometrica): Boolean {
        var x2 = x + ancho
        var y2 = y + alto

        //Caso 1
        if (objetoB.estaEnArea(x2, y2 + alto)) {
            return true
        }

        //Caso 2
        if (objetoB.estaEnArea(x, y2)) {
            return true
        }

        //Caso 3
        if (objetoB.estaEnArea(x2, y)) {
            return true
        }

        //Caso 4
        if (objetoB.estaEnArea(x, y)) {
            return true
        }

        return false
    }


}