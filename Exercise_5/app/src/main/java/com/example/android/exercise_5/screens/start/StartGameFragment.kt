package com.example.android.exercise_5.screens.start

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.android.exercise_5.R
import com.example.android.exercise_5.databinding.FragmentStartGameBinding

class StartGameFragment : Fragment() {
    
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val binding = DataBindingUtil.inflate<FragmentStartGameBinding>(inflater,
            R.layout.fragment_start_game, container, false)

        binding.addition.setOnClickListener {view: View ->
            view.findNavController().navigate(
                StartGameFragmentDirections.actionStartGameFragmentToGameFragment(
                    operation = "addition"
                )
            )}

        binding.subtraction.setOnClickListener {view: View ->
            view.findNavController().navigate(
                StartGameFragmentDirections.actionStartGameFragmentToGameFragment(
                    operation = "subtraction"
                )
            )}

        binding.multiplication.setOnClickListener {view: View ->
            view.findNavController().navigate(
                StartGameFragmentDirections.actionStartGameFragmentToGameFragment(
                    operation = "multiplication"
                )
            )}

        setHasOptionsMenu(true)
        return binding.root
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.overflow_menu, menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item,
            requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }
}