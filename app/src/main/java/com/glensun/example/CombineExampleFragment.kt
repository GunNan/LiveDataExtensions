package com.glensun.example

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.glensun.example.databinding.CombineExampleFragmentBinding

class CombineExampleFragment : Fragment() {

    companion object {
        fun newInstance() = CombineExampleFragment()
    }

    private lateinit var viewModel: CombineExampleViewModel

    private lateinit var binding: CombineExampleFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(CombineExampleViewModel::class.java)
        binding = CombineExampleFragmentBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.viewmodel = viewModel
        return binding.root
    }
}