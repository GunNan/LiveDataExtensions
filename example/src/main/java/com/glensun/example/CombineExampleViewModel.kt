package com.glensun.example

import android.util.Log
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.glensun.livedataextension.*

private const val TAG = "CombineExampleViewModel"

class CombineExampleViewModel : ViewModel(), LifecycleObserver {
    private val dataA = MutableLiveData<String>()
    private val dataB = MutableLiveData<String>()
    private val dataC = MutableLiveData<String>()

    // If you define a default value, 'combine' will trigger on the begin
    private val clickCount = MutableLiveData<Int>(0)

    // show data
    val showData: LiveData<String> =
        dataA.combine(dataB, dataC, clickCount) { a, b, c, count -> "$a,$b,$c,$count" }

    fun onGetGlenClick() {
        dataA.value = "glen"
        clickCount.value = (clickCount.value ?: 0) + 1
    }

    fun onGetSunClick() {
        dataB.value = "sun"
        clickCount.value = (clickCount.value ?: 0) + 1
    }

    fun onGetHelloClick() {
        dataC.value = "hello"
        clickCount.value = (clickCount.value ?: 0) + 1
    }
}