 package com.example.efinal.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.efinal.databinding.FragmentDigimonDetailBinding


 class DigimonDetailFragment : Fragment() {
private lateinit var binding: FragmentDigimonDetailBinding

    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDigimonDetailBinding.inflate(inflater,container,false)
        return binding.root
    }

}