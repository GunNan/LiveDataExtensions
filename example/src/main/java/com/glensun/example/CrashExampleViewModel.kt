package com.glensun.example

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.glensun.livedataextension.map
import com.glensun.livedataextension.merge
import com.glensun.livedataextension.*

private const val TAG = "ZipExampleViewModel"

class CrashExampleViewModel : ViewModel(), LifecycleObserver {
    private val dataA = MutableLiveData<List<String>>()

    // show data
    val showData = dataA.map { it?.get(1) }

    fun onCrashHappenedClick() {
        dataA.value = emptyList()
    }

    fun onCatchCrashClick() {
        try {
            dataA.value = emptyList()
        } catch (ignore: Exception) {
        }
        dataA.value = listOf("a", "b", "c")
    }
}