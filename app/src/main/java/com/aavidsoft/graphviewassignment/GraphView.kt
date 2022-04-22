package com.aavidsoft.graphviewassignment

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.widget.ImageView
import java.util.*
import kotlin.math.absoluteValue

@SuppressLint("AppCompatCustomView")
class GraphView(context: Context, attributeSet: AttributeSet?) : ImageView(context, attributeSet) {

    var values: Array<Int>? = null
    set(value) {
        field = value
        invalidate()
    }
    var paint = Paint()

    init {
        paint.setColor(Color.RED)
    }


    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)



        if (values == null) {
            return
        }

        var barWidth = width / values!!.size
        var percentageHeight = height / 100

        var left = 0

        var random = Random()

        for (i in 0..values!!.size - 1) {

            paint.setColor(Color.rgb(random.nextInt().absoluteValue%255, random.nextInt().absoluteValue%255, random.nextInt().absoluteValue%255))

            canvas!!.drawRect(
                left.toFloat(), (height - percentageHeight * values!![i]).toFloat() ,
                left + barWidth.toFloat() -5, height.toFloat(),
                paint
            )
            left += barWidth
        }

        canvas!!.drawText(
            "BitCode Student Marks",
            100F, height.toFloat()/2, paint
        )
    }

}