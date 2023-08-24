package com.example.efinal.ui.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.efinal.databinding.FragmentDigimonListBinding
import com.example.efinal.ui.viewmodels.ListViewModel
import com.example.efinal.ui.viewmodels.adapters.DigimonAdapter
class DigimonListFragment : Fragment() {
    private lateinit var binding: FragmentDigimonListBinding
    private lateinit var viewModel: ListViewModel
    private lateinit var adapter: DigimonAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDigimonListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this)[ListViewModel::class.java]

        setupRecyclerView()

        viewModel.listaDigimons.observe(viewLifecycleOwner) { digimons ->
            adapter.listaDigimons = digimons
            adapter.notifyDataSetChanged()
        }

        viewModel.obtenerDigimons()
    }

    private fun setupRecyclerView() {
        adapter = DigimonAdapter(requireContext(), arrayListOf())
        binding.rvDigimons.layoutManager = GridLayoutManager(requireContext(), 1)
        binding.rvDigimons.adapter = adapter
    }
}
