package com.glensun.example

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.glensun.livedataextension.merge

private const val TAG = "MergeExampleViewModel"

class MergeExampleViewModel : ViewModel(), LifecycleObserver {
    private val dataA = MutableLiveData<String>()
    private val dataB = MutableLiveData<String>()
    private val dataC = MutableLiveData<String>()

    // show data
    val showData = dataA.merge(dataB).merge(dataC)

    fun onGetGlenClick() {
        dataA.value = "glen"
    }

    fun onGetSunClick() {
        dataB.value = "sun"
    }

    fun onGetHelloClick() {
        dataC.value = "hello"
    }
}