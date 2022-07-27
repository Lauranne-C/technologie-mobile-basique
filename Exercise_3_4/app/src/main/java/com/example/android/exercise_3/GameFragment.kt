package com.example.android.exercise_3

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.android.exercise_3.databinding.FragmentGameBinding


private var nb1 = 0
private var nb2 = 0

class GameFragment : Fragment() {
    private var nb_questions = 1
    private var bad_answers = 0
    private  var good_answers = 0
    private var result = 0
    private lateinit var timer : Timer

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        timer = Timer()
        val binding = DataBindingUtil.inflate<FragmentGameBinding>(inflater, R.layout.fragment_game, container, false)
        var args = GameFragmentArgs.fromBundle(requireArguments())
        val calc = binding.calculation
        binding.game = this
        val resp = binding.response
        val msg = binding.message


        if (savedInstanceState != null) {
            bad_answers = savedInstanceState.getInt("bad_answers_key")
            good_answers = savedInstanceState.getInt("good_answers_key")
            nb_questions = savedInstanceState.getInt("nb_questions_key")
            timer.secondsCount = savedInstanceState.getInt("timer_key")
        }

        if (args.operation == "addition") {
            msg.text = ""
            if (nb1 == 0) {
                var (nb1,nb2) = calculation()
                calc.text = "" + nb1 + "+" + nb2
                result = nb1 + nb2
            }
            else {
                calc.text = "" + nb1 + "+" + nb2
                result = nb1 + nb2
            }
            binding.next.setOnClickListener {
                if (resp.text.toString() == (result.toString())) {
                    msg.text = "good answer !"
                    good_answers += 1
                }
                else {
                    msg.text = "bad answer"
                    bad_answers += 1
                }
                if (nb_questions < 10 && bad_answers != 3) {
                    nb_questions += 1
                    resp.setText("")
                    var (nb1,nb2) = calculation()
                    calc.text = "" + nb1 + "+" + nb2
                    result = nb1 + nb2
                }
                else {
                    binding.next.setOnClickListener {view : View ->
                        view.findNavController().navigate(GameFragmentDirections.actionGameFragmentToScoreFragment(nb_questions,good_answers,args.operation,timer.secondsCount))
                    }
                }
            }
        }


        if (args.operation == "subtraction") {
            msg.text = ""
            if (nb1 == 0) {
                var (nb1,nb2) = calculation()
                calc.text = "" + nb1 + "-" + nb2
                result = nb1 - nb2
            }
            else {
                calc.text = "" + nb1 + "-" + nb2
                result = nb1 - nb2
            }
            binding.next.setOnClickListener {
                if (resp.text.toString() == (result.toString())) {
                    msg.text = "good answer !"
                    good_answers += 1
                }
                else {
                    msg.text = "bad answer"
                    bad_answers += 1
                }
                if (nb_questions < 10 && bad_answers != 3) {
                    nb_questions += 1
                    resp.setText("")
                    var (nb1,nb2) = calculation()
                    calc.text = "" + nb1 + "-" + nb2
                    result = nb1 - nb2
                }
                else {
                    binding.next.setOnClickListener {view : View ->
                        view.findNavController().navigate(GameFragmentDirections.actionGameFragmentToScoreFragment(nb_questions,good_answers,args.operation,timer.secondsCount))
                    }
                }
            }
        }

        if (args.operation == "multiplication") {
            msg.text = ""
            if (nb1 == 0) {
                var (nb1,nb2) = calculation()
                calc.text = "" + nb1 + "*" + nb2
                result = nb1 * nb2
            }
            else {
                calc.text = "" + nb1 + "*" + nb2
                result = nb1 * nb2
            }
            binding.next.setOnClickListener {
                if (resp.text.toString() == (result.toString())) {
                    msg.text = "good answer !"
                    good_answers += 1
                }
                else {
                    msg.text = "bad answer"
                    bad_answers += 1
                }
                if (nb_questions < 10 && bad_answers != 3) {
                    nb_questions += 1
                    resp.setText("")
                    var (nb1,nb2) = calculation()
                    calc.text = "" + nb1 + "*" + nb2
                    result = nb1 * nb2
                }
                else {
                    binding.next.setOnClickListener {view : View ->
                        view.findNavController().navigate(GameFragmentDirections.actionGameFragmentToScoreFragment(nb_questions,good_answers,args.operation,timer.secondsCount))
                    }
                }
            }
        }
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        timer.startTimer()
    }

    override fun onStop(){
        super.onStop()
        timer.stopTimer()
        nb1 = nb1
        nb2 = nb2

    }
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d("msg","onSaveInstanceState")
        outState.putInt("bad_answers_key",bad_answers)
        outState.putInt("good_answers_key", good_answers)
        outState.putInt("nb_questions_key",nb_questions)
        outState.putInt("timer_key", timer.secondsCount)
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
    }
}
@SuppressLint("SetTextI18n")
fun calculation(): Pair<Int,Int> {
    nb1 = (1 until 10).random()
    nb2 = (1 until 10).random()
    return Pair(nb1,nb2)
}




