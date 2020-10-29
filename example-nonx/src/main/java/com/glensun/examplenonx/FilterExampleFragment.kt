package com.glensun.examplenonx

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.glensun.examplenonx.databinding.FilterExampleFragmentBinding
import com.glensun.examplenonx.databinding.ZipExampleFragmentBinding

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
        viewModel = ViewModelProviders.of(this).get(FilterExampleViewModel::class.java)
        binding = FilterExampleFragmentBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.viewmodel = viewModel
        return binding.root
    }
}