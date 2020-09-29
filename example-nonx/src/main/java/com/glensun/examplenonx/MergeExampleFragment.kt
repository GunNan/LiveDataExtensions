package com.glensun.examplenonx

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.glensun.examplenonx.databinding.MergeExampleFragmentBinding

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
        viewModel = ViewModelProviders.of(this).get(MergeExampleViewModel::class.java)
        binding = MergeExampleFragmentBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.viewmodel = viewModel
        return binding.root
    }
}