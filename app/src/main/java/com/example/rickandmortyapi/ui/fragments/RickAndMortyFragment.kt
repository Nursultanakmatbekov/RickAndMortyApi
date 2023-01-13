package com.example.rickandmortyapi.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.rickandmortyapi.databinding.FragmentRickAndMortyBinding
import com.example.rickandmortyapi.ui.adapters.CheracterAdapter

class RickAndMortyFragment : Fragment() {

    private var binding: FragmentRickAndMortyBinding? = null
    private val viewModel by viewModels<RickAndMortyViewModel>()
    private val characterAdapter = CheracterAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRickAndMortyBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObserve()
        initialize()
    }

    private fun initialize() {
        binding?.rvView?.adapter = characterAdapter
    }

    private fun setupObserve() {
        viewModel.charactersLiveData.observe(viewLifecycleOwner) {
            characterAdapter.submitList(it)
        }

        viewModel.errorLiveData.observe(viewLifecycleOwner) {

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}