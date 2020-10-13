package com.glensun.example

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.glensun.livedataextension.map
import com.glensun.livedataextension.merge
import com.glensun.livedataextension.*
import kotlin.concurrent.thread

class SwitchMapExampleViewModel : ViewModel(), LifecycleObserver {
    private val dataA = MutableLiveData<Boolean>(false)

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