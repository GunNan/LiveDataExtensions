package com.glensun.examplenonx

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.glensun.examplenonx.databinding.SwitchmapExampleFragmentBinding

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
        viewModel = ViewModelProviders.of(this).get(SwitchMapExampleViewModel::class.java)
        binding = SwitchmapExampleFragmentBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.viewmodel = viewModel
        return binding.root
    }
}