package com.example.android.exercise_5.screens.game

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import com.example.android.exercise_5.R
import com.example.android.exercise_5.Timer
import com.example.android.exercise_5.databinding.FragmentGameBinding

private var nb1 = 0
private var nb2 = 0

class GameFragment : Fragment() {
    @SuppressLint("SetTextI18n")
    private lateinit var viewModel: GameViewModel
    private lateinit var timer: Timer

    @SuppressLint("LogNotTimber", "SetTextI18n")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        timer = Timer()
        val binding = DataBindingUtil.inflate<FragmentGameBinding>(
            inflater,
            R.layout.fragment_game, container, false
        )
        Log.d("msg", "called ViewModelProviders.of")
        viewModel = ViewModelProviders.of(this).get(GameViewModel::class.java)

        val args =
            GameFragmentArgs.fromBundle(
                requireArguments()
            )
        val calc = binding.calculation
        binding.game = this
        val resp = binding.response
        val msg = binding.message


        if (args.operation == "addition") {
            msg.text = ""
            if (nb1 == 0){
                var (nb1,nb2) = calculation(viewModel, calc)
                calc.text = "" + nb1 + "+" + nb2
                viewModel._resultDec.value = nb1 + nb2
            }
            else {
                calc.text = "" + nb1 + "+" + nb2
                viewModel._resultDec.value = nb1 + nb2
            }

            viewModel._goodAnswers.observe(viewLifecycleOwner, Observer { newScore -> binding.score.text = "" + newScore.toString() + "/" + viewModel._nbQuestions.value })

            binding.next.setOnClickListener {
                if (resp.text.toString() == viewModel._resultDec.value.toString()) {
                    msg.text = "Good answers"
                    viewModel._goodAnswers.value = viewModel._goodAnswers.value?.plus(1)
                } else {
                    msg.text = "Bad answers"
                    viewModel._badAnswers.value = viewModel._badAnswers.value?.plus(1)
                }
                if (viewModel._nbQuestions.value!! < 10 && viewModel._badAnswers.value != 3) {
                    resp.setText("")
                    viewModel._goodAnswers.observe(
                        viewLifecycleOwner,
                        Observer { newScore ->
                            binding.score.text =
                                "" + newScore.toString() + "/" + viewModel._nbQuestions.value
                        })
                    viewModel._nbQuestions.value = (viewModel._nbQuestions.value)?.plus(1)
                    var (nb1,nb2) = calculation(viewModel, calc)
                    calc.text = "" + nb1 + "+" + nb2
                    viewModel._resultDec.value = nb1 + nb2
                } else {
                    binding.next.setOnClickListener { view: View ->
                        view.findNavController().navigate(
                            GameFragmentDirections.actionGameFragmentToScoreFragment(
                                viewModel._nbQuestions.value!!,
                                viewModel._goodAnswers.value!!,
                                args.operation,
                                timer.secondsCount
                            )
                        )
                    }
                }
            }
        }


        if (args.operation == "subtraction") {
            msg.text = ""
            if (nb1 == 0){
                var (nb1,nb2) = calculation(viewModel, calc)
                calc.text = "" + nb1 + "-" + nb2
                viewModel._resultDec.value = nb1 - nb2
            }
            else {
                calc.text = "" + nb1 + "-" + nb2
                viewModel._resultDec.value = nb1 - nb2
            }

            viewModel._goodAnswers.observe(viewLifecycleOwner, Observer { newScore -> binding.score.text = "" + newScore.toString() + "/" + viewModel._nbQuestions.value })

            binding.next.setOnClickListener {
                if (resp.text.toString() == viewModel._resultDec.value.toString()) {
                    msg.text = "Good answers"
                    viewModel._goodAnswers.value = viewModel._goodAnswers.value?.plus(1)
                } else {
                    msg.text = "Bad answers"
                    viewModel._badAnswers.value = viewModel._badAnswers.value?.plus(1)
                }
                if (viewModel._nbQuestions.value!! < 10 && viewModel._badAnswers.value != 3) {
                    resp.setText("")
                    viewModel._goodAnswers.observe(
                        viewLifecycleOwner,
                        Observer { newScore ->
                            binding.score.text =
                                "" + newScore.toString() + "/" + viewModel._nbQuestions.value
                        })
                    viewModel._nbQuestions.value = (viewModel._nbQuestions.value)?.plus(1)
                    var (nb1,nb2) = calculation(viewModel, calc)
                    calc.text = "" + nb1 + "-" + nb2
                    viewModel._resultDec.value = nb1 - nb2
                } else {
                    binding.next.setOnClickListener { view: View ->
                        view.findNavController().navigate(
                            GameFragmentDirections.actionGameFragmentToScoreFragment(
                                viewModel._nbQuestions.value!!,
                                viewModel._goodAnswers.value!!,
                                args.operation,
                                timer.secondsCount
                            )
                        )
                    }
                }
            }
        }

        if (args.operation == "multiplication") {
            msg.text = ""
            if (nb1 == 0){
                var (nb1,nb2) = calculation(viewModel, calc)
                calc.text = "" + nb1 + "*" + nb2
                viewModel._resultDec.value = nb1 * nb2
            }
            else {
                calc.text = "" + nb1 + "*" + nb2
                viewModel._resultDec.value = nb1 * nb2
            }

            viewModel._goodAnswers.observe(viewLifecycleOwner, Observer { newScore -> binding.score.text = "" + newScore.toString() + "/" + viewModel._nbQuestions.value })

            binding.next.setOnClickListener {
                if (resp.text.toString() == viewModel._resultDec.value.toString()) {
                    msg.text = "Good answers"
                    viewModel._goodAnswers.value = viewModel._goodAnswers.value?.plus(1)
                } else {
                    msg.text = "Bad answers"
                    viewModel._badAnswers.value = viewModel._badAnswers.value?.plus(1)
                }
                if (viewModel._nbQuestions.value!! < 10 && viewModel._badAnswers.value != 3) {
                    resp.setText("")
                    viewModel._goodAnswers.observe(
                        viewLifecycleOwner,
                        Observer { newScore ->
                            binding.score.text =
                                "" + newScore.toString() + "/" + viewModel._nbQuestions.value
                        })
                    viewModel._nbQuestions.value = (viewModel._nbQuestions.value)?.plus(1)
                    var (nb1,nb2) = calculation(viewModel, calc)
                    calc.text = "" + nb1 + "*" + nb2
                    viewModel._resultDec.value = nb1 * nb2
                } else {
                    binding.next.setOnClickListener { view: View ->
                        view.findNavController().navigate(
                            GameFragmentDirections.actionGameFragmentToScoreFragment(
                                viewModel._nbQuestions.value!!,
                                viewModel._goodAnswers.value!!,
                                args.operation,
                                timer.secondsCount
                            )
                        )
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

    override fun onStop() {
        super.onStop()
        timer.stopTimer()
        viewModel._nb1.value = nb1
        viewModel._nb2.value = nb2
    }
}
@SuppressLint("SetTextI18n")
fun calculation(viewModel: GameViewModel, calc: TextView): Pair<Int,Int> {
    viewModel._nb1.value = (1 until 10).random()
    viewModel._nb2.value = (1 until 10).random()
    nb1 = viewModel._nb1.value!!
    nb2 = viewModel._nb2.value!!

    return Pair(nb1,nb2)
}





