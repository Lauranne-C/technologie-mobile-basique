package com.example.android.exercise_2e


import android.annotation.SuppressLint
import android.media.Image
import android.nfc.Tag
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.annotation.RequiresApi
import androidx.core.widget.ImageViewCompat
import com.example.android.exercise_2e.R.drawable.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val images : MutableList<Int> = mutableListOf(flowers_1, flowers_2, flowers_3, flowers_4, flowers_5, flowers_6,
            flowers_1, flowers_2, flowers_3, flowers_4, flowers_5, flowers_6)
        val case : MutableList<ImageView> = mutableListOf(picture_1,picture_2,picture_3,picture_4,picture_5,picture_6,
            picture_7,picture_8,picture_9,picture_10,picture_11,picture_12)
        var pair = mutableListOf<ImageView>()
        var nb = 0
        var step = 0

        shuffleCards(images,case)


        for (item in case) {
            item.setOnClickListener {
                if (step == 0) {
                    for (i in 0..11) {
                        if (item == case[i]) {
                            item.setImageResource(images[i])
                        }
                    }
                    pair.add(0, item)
                    step += 1
                } else if (step == 1) {
                    for (i in 0..11) {
                        if (item == case[i]) {
                            item.setImageResource(images[i])
                        }
                    }
                    pair.add(1, item)
                    step = 0

                    if (pair[0].tag == pair[1].tag && pair[0].id != pair[1].id) {
                        nb += 2
                        message.text = "Great it's a pair"

                        if (nb == 12) {
                            message.text = "You guessed all, great work !"
                        }
                    } else {
                        message.text = "Sorry, it's not a pair"
                        pair[0].setImageResource(cover)
                        pair[1].setImageResource(cover)
                    }
                }
            }
        }

        restart_button.setOnClickListener{
            shuffleCards(images, case)
            message.text = ""
        }
    }
}

private fun shuffleCards(images: MutableList<Int>,case: MutableList<ImageView>) {
    images.shuffle()
    case.shuffle()
    for (i in 0..11) {
        case[i].setImageResource(cover)
        case[i].tag= images[i]
    }
}
