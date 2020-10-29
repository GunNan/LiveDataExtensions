package com.glensun.example

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.glensun.example.databinding.FilterExampleFragmentBinding
import com.glensun.example.databinding.ZipExampleFragmentBinding

class FilterExampleFragment : Fragment() {

    companion object {
        fun newInstance() = FilterExampleFragment()
    }

    private lateinit var viewModel: FilterExampleViewModel

    private lateinit var binding: FilterExampleFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(FilterExampleViewModel::class.java)
        binding = FilterExampleFragmentBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.viewmodel = viewModel
        return binding.root
    }
}