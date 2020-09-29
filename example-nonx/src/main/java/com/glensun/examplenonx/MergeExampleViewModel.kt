package com.glensun.examplenonx

import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
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