package com.glensun.example

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.glensun.example.databinding.ZipExampleFragmentBinding

class ZipExampleFragment : Fragment() {

    companion object {
        fun newInstance() = ZipExampleFragment()
    }

    private lateinit var viewModel: ZipExampleViewModel

    private lateinit var binding: ZipExampleFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(ZipExampleViewModel::class.java)
        binding = ZipExampleFragmentBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.viewmodel = viewModel
        return binding.root
    }
}