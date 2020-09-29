package com.glensun.examplenonx

import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.glensun.livedataextension.*

private const val TAG = "CombineExampleViewModel"

class CombineExampleViewModel : ViewModel(), LifecycleObserver {
    private val dataA = MutableLiveData<String>()
    private val dataB = MutableLiveData<String>()
    private val dataC = MutableLiveData<String>()

    // If you define a default value, 'combine' will trigger on the begin
    private val clickCount: MutableLiveData<Int> = MutableLiveData<Int>().startWith(0).toMutable()

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