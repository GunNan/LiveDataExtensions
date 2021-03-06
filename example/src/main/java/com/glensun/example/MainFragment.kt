package com.glensun.example

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.glensun.example.R

class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.main_fragment, container, false)
        root.findViewById<Button>(R.id.combine_btn).setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_combineExampleFragment)
        }
        root.findViewById<Button>(R.id.merge_btn).setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_mergeExampleFragment)
        }
        root.findViewById<Button>(R.id.zip_btn).setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_zipExampleFragment)
        }
        root.findViewById<Button>(R.id.crash_btn).setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_crashExampleFragment)
        }
        root.findViewById<Button>(R.id.switch_map_btn).setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_switchmapExampleFragment)
        }
        return root
    }
}