package com.example.android.exercise_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var viewPictures: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val Button_next: Button = findViewById(R.id.button_next)
        val Button_previous: Button = findViewById(R.id.button_previous)
        var nb_picture = 1
        Button_next.setOnClickListener {
            nb_picture += 1
            nextImage(nb_picture)
        }
        Button_previous.setOnClickListener {
            nb_picture -= 1
            previousImage(nb_picture)
        }
        viewPictures = findViewById(R.id.picture)
    }

    private fun nextImage(nb_picture: Int) {
        val viewPictures: ImageView = findViewById(R.id.picture)
        val drawableResource = when (nb_picture) {
            1 -> R.drawable.water_lily
            2 -> R.drawable.flowers_1
            3 -> R.drawable.flowers_2
            4 -> R.drawable.flowers_3
            5 -> R.drawable.flowers_4
            else -> R.drawable.flowers_5
        }
        viewPictures.setImageResource(drawableResource)
    }
    private fun previousImage(nb_picture: Int) {
        val viewPictures: ImageView = findViewById(R.id.picture)
        val drawableResource = when (nb_picture) {
            1 -> R.drawable.water_lily
            2 -> R.drawable.flowers_1
            3 -> R.drawable.flowers_2
            4 -> R.drawable.flowers_3
            5 -> R.drawable.flowers_4
            else -> R.drawable.flowers_5
        }
        viewPictures.setImageResource(drawableResource)
    }
}

