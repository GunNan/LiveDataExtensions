package com.glensun.examplenonx

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.glensun.examplenonx.databinding.CrashExampleFragmentBinding

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
        viewModel = ViewModelProviders.of(this).get(CrashExampleViewModel::class.java)
        binding = CrashExampleFragmentBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.viewmodel = viewModel
        return binding.root
    }
}