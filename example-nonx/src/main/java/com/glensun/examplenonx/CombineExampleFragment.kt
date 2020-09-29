package com.glensun.examplenonx

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.glensun.examplenonx.databinding.CombineExampleFragmentBinding

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
        viewModel = ViewModelProviders.of(this).get(CombineExampleViewModel::class.java)
        binding = CombineExampleFragmentBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.viewmodel = viewModel
        return binding.root
    }
}