package com.glensun.example

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.glensun.example.databinding.SwitchmapExampleFragmentBinding
import com.glensun.example.databinding.ZipExampleFragmentBinding

class SwitchMapExampleFragment : Fragment() {

    companion object {
        fun newInstance() = SwitchMapExampleFragment()
    }

    private lateinit var viewModel: SwitchMapExampleViewModel

    private lateinit var binding: SwitchmapExampleFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(SwitchMapExampleViewModel::class.java)
        binding = SwitchmapExampleFragmentBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.viewmodel = viewModel
        return binding.root
    }
}