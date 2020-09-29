package com.glensun.examplenonx

import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.glensun.livedataextension.map

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