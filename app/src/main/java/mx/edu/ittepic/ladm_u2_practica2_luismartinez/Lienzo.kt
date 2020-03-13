package mx.edu.ittepic.ladm_u2_practica2_luismartinez

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.View

class Lienzo(p: MainActivity) : View(p) {
    var puntero = p
    var circulo = FiguraGeometrica(50, 50, 18)
    var circulo1 = FiguraGeometrica(400, 50, 18)
    var circulo2 = FiguraGeometrica(240, 250, 25)
    var circulo3 = FiguraGeometrica(150, 420, 40)
    var circulo4 = FiguraGeometrica(420, 400, 35)
    var circulo5 = FiguraGeometrica(300, 700, 75)
    var circulo6 = FiguraGeometrica(50, 780, 70)

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        var paint = Paint()
        paint.color= Color.argb(80,217, 136, 128)
        circulo.pintar(canvas, paint)
        paint.color= Color.argb(80,163, 228, 215 )
        circulo1.pintar(canvas, paint)
        paint.color= Color.argb(80,210, 180, 222 )
        circulo2.pintar(canvas, paint)
        paint.color= Color.argb(80,46, 204, 113)
        circulo3.pintar(canvas, paint)
        paint.color= Color.argb(80,46, 66, 148 )
        circulo4.pintar(canvas, paint)
        paint.color= Color.argb(80,244, 208, 63 )
        circulo5.pintar(canvas, paint)
        paint.color= Color.argb(80,245, 87, 92 )
        circulo6.pintar(canvas, paint)

    }//onDraw

    fun animarCirculo() {
        circulo.rebote(width,height)
        circulo1.rebote(width,height)
        circulo2.rebote(width,height)
        circulo3.rebote(width,height)
        circulo4.rebote(width,height)
        circulo5.rebote(width,height)
        circulo6.rebote(width,height)
        invalidate()
    }
}//class