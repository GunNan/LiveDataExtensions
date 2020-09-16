package com.glensun.example

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.glensun.example.databinding.MergeExampleFragmentBinding

class MergeExampleFragment : Fragment() {

    companion object {
        fun newInstance() = MergeExampleFragment()
    }

    private lateinit var viewModel: MergeExampleViewModel

    private lateinit var binding: MergeExampleFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(MergeExampleViewModel::class.java)
        binding = MergeExampleFragmentBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.viewmodel = viewModel
        return binding.root
    }
}