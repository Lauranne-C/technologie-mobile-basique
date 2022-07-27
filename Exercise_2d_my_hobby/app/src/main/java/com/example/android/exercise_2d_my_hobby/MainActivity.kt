package com.example.android.exercise_2d_my_hobby

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.button).setOnClickListener{
            under_title_opinion.visibility = View.VISIBLE
            my_opinion.visibility = View.VISIBLE
            button.visibility = View.GONE
        }
    }
}