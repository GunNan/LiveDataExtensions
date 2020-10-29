package com.glensun.example

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.glensun.livedataextension.map
import com.glensun.livedataextension.merge
import com.glensun.livedataextension.*

private const val TAG = "ZipExampleViewModel"

class FilterExampleViewModel : ViewModel(), LifecycleObserver {
    private val data = MutableLiveData<Int>(1)

    // show data
    val showData: LiveData<String> = data
        .filter { (it ?: 1) % 2 == 0 }
        .map { it.toString() }

    fun onAddClick() {
        data.value = (data.value ?: 0) + 1
    }
}