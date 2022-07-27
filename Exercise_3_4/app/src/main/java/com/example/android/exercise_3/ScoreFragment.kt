package com.example.android.exercise_3

import android.content.Intent
import android.os.Bundle
import android.provider.Settings.Global.getString
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.android.exercise_3.databinding.FragmentScoreBinding
import com.example.android.exercise_3.databinding.FragmentStartGameBinding
import kotlinx.android.synthetic.main.fragment_score.*
import com.example.android.exercise_3.databinding.FragmentGameBinding
import com.example.android.exercise_3.MainActivity
import kotlin.concurrent.timer

class ScoreFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentScoreBinding>(inflater, R.layout.fragment_score, container, false)
        var args = ScoreFragmentArgs.fromBundle(requireArguments())
        binding.restart.setOnClickListener { view: View -> view.findNavController().navigate(ScoreFragmentDirections.actionScoreFragmentToGameFragment(args.operation))}
        binding.change.setOnClickListener {view: View -> view.findNavController().navigate(ScoreFragmentDirections.actionScoreFragmentToStartGameFragment())}
        var msg = binding.message

        msg.text = "You have ${args.goodAnswers} good answers on ${args.nbQuestions} in ${args.time} seconds"

        setHasOptionsMenu(true)
        return binding.root
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.share_menu, menu)
    }
    private fun getShareIntent() : Intent {
        var args = ScoreFragmentArgs.fromBundle(requireArguments())
        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.setType("text/plain")
            .putExtra(Intent.EXTRA_TEXT, getString(R.string.share_success_text, args.goodAnswers, args.nbQuestions))
        return shareIntent
    }
    private fun shareSuccess() {
        startActivity(getShareIntent())
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item!!.itemId) {
            R.id.share -> shareSuccess()
        }
        return super.onOptionsItemSelected(item)
    }
}
