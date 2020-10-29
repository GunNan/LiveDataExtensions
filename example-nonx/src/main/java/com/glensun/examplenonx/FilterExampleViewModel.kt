package com.glensun.examplenonx

import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.glensun.livedataextension.map
import com.glensun.livedataextension.*

private const val TAG = "ZipExampleViewModel"

class FilterExampleViewModel : ViewModel(), LifecycleObserver {
    private val data: MutableLiveData<Int> = MutableLiveData<Int>()
        .startWith(1)
        .toMutable()

    // show data
    val showData: LiveData<String> = data
        .filter { (it ?: 1) % 2 == 0 }
        .map { it.toString() }

    fun onAddClick() {
        data.value = (data.value ?: 0) + 1
    }
}