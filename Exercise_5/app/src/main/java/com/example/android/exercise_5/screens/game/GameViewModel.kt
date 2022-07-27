package com.example.android.exercise_5.screens.game

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel() {
    var _nbQuestions = MutableLiveData<Int>()
    val nbQuestions : LiveData<Int>
        get() = _nbQuestions

    var _badAnswers = MutableLiveData<Int>()
    val badAnswers : LiveData<Int>
        get() = _badAnswers

    var _goodAnswers = MutableLiveData<Int>()
    val goodAnswers : LiveData<Int>
        get() = _goodAnswers

    var _nb1 = MutableLiveData<Int>()
    val nb1 : LiveData<Int>
        get() = _nb1

    var _nb2 = MutableLiveData<Int>()
    val nb2 : LiveData<Int>
        get() = _nb2

    var _resultDec = MutableLiveData<Int>()
    val resultDec : LiveData<Int>
        get() = _resultDec
    init {
        Log.i("msg","GameViewModel")
        _nbQuestions.value = 1
        _badAnswers.value = 0
        _goodAnswers.value = 0
        _nb1.value = 1
        _nb2.value = 1
        _resultDec.value = 0
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("msg","ViewModel Destroyed")
    }
}

