package com.glensun.examplenonx

import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.glensun.livedataextension.filter
import com.glensun.livedataextension.startWith
import com.glensun.livedataextension.switchMap
import com.glensun.livedataextension.toMutable
import kotlin.concurrent.thread

class SwitchMapExampleViewModel : ViewModel(), LifecycleObserver {
    private val dataA = MutableLiveData<Boolean>().startWith(false).toMutable()

    // show data
    val showData = dataA
        .filter { it == true }
        .switchMap {
            return@switchMap fetchData()
        }.startWith("default")

    fun onFetchClick() {
        dataA.value = true
    }

    private fun fetchData(): LiveData<String> {
        val result = MutableLiveData<String>()

        thread {
            Thread.sleep(1000)
            result.postValue("hello from remote")
        }
        return result
    }
}