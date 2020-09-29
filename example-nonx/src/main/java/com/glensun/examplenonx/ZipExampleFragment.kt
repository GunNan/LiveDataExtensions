package com.glensun.examplenonx

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.glensun.examplenonx.databinding.ZipExampleFragmentBinding

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
        viewModel = ViewModelProviders.of(this).get(ZipExampleViewModel::class.java)
        binding = ZipExampleFragmentBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.viewmodel = viewModel
        return binding.root
    }
}