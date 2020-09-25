package com.glensun.example

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.glensun.example.databinding.CombineExampleFragmentBinding
import com.glensun.example.databinding.CrashExampleFragmentBinding

class CrashExampleFragment : Fragment() {

    companion object {
        fun newInstance() = CrashExampleFragment()
    }

    private lateinit var viewModel: CrashExampleViewModel

    private lateinit var binding: CrashExampleFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(CrashExampleViewModel::class.java)
        binding = CrashExampleFragmentBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.viewmodel = viewModel
        return binding.root
    }
}