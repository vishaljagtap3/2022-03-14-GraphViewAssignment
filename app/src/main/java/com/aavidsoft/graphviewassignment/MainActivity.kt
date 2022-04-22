package com.aavidsoft.graphviewassignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import java.util.*
import kotlin.math.absoluteValue

class MainActivity : AppCompatActivity() {

    private lateinit var graphView : GraphView
    private lateinit var btnRefrehValues : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        graphView = findViewById(R.id.graphView)
        graphView.values = arrayOf(80, 60, 50, 90)

        btnRefrehValues = findViewById(R.id.btnRefreshValues)
        btnRefrehValues.setOnClickListener {
            var random = Random()
            graphView.values = Array<Int>(
                random.nextInt().absoluteValue % 8 + 1,
                {index ->random.nextInt().absoluteValue % 101}
            )
        }

    }


}