package com.glensun.example

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.glensun.livedataextension.R

class CombineExampleFragment : Fragment() {

    companion object {
        fun newInstance() = CombineExampleFragment()
    }

    private lateinit var viewModel: CombineExampleViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.combine_example_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(CombineExampleViewModel::class.java)
        // TODO: Use the ViewModel
    }

}