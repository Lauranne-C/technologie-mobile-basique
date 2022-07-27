package com.example.android.exercise_5.screens.score

import android.util.Log
import androidx.lifecycle.ViewModel
import timber.log.Timber

class ScoreViewModel : ViewModel() {

    init {
        Timber.i("GameViewModel")
    }

    override fun onCleared() {
        super.onCleared()
        Timber.i("ViewModel Destroyed")
    }
}