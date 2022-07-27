package com.example.android.exercise_3

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.android.exercise_3.databinding.FragmentStartGameBinding
import timber.log.Timber

class StartGameFragment : Fragment() {
    
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val binding = DataBindingUtil.inflate<FragmentStartGameBinding>(inflater, R.layout.fragment_start_game, container, false)

        binding.addition.setOnClickListener {view: View ->
            view.findNavController().navigate(StartGameFragmentDirections.actionStartGameFragmentToGameFragment(operation = "addition"))}

        binding.subtraction.setOnClickListener {view: View ->
            view.findNavController().navigate(StartGameFragmentDirections.actionStartGameFragmentToGameFragment(operation = "subtraction"))}

        binding.multiplication.setOnClickListener {view: View ->
            view.findNavController().navigate(StartGameFragmentDirections.actionStartGameFragmentToGameFragment(operation = "multiplication"))}

        setHasOptionsMenu(true)
        return binding.root
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.overflow_menu, menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item!!,
            requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }
}