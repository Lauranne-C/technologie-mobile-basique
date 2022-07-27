package com.example.android.exercise_2_my_hobby

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.VISIBLE
import android.widget.Button
import androidx.databinding.DataBindingUtil
import com.example.android.exercise_2_my_hobby.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private val title: Title = Title("My hobby: read books")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.title = title

        binding.opinionButton.setOnClickListener {
            binding.apply {
                invalidateAll()
                under_title_opinion.visibility = View.VISIBLE
                my_opinion.visibility = View.VISIBLE
                opinion_button.visibility = View.GONE
            }
        }
    }
}