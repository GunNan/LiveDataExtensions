package com.glensun.example

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.glensun.livedataextension.map
import com.glensun.livedataextension.merge
import com.glensun.livedataextension.*

private const val TAG = "ZipExampleViewModel"

class ZipExampleViewModel : ViewModel(), LifecycleObserver {
    private val dataA = MutableLiveData<Boolean>(false)
    private val dataB = MutableLiveData<Boolean>(false)
    private val dataC = MutableLiveData<Boolean>(false)

    // show data
    private val zipData = dataA.zip(dataB).zip(dataC)
    val showData = zipData.map { it?.joinToString() }
    val isAllTrue = zipData.isAllTrue().map { "isAllTrue: $it" }

    fun onToggle1Click() {
        dataA.value = dataA.value.revert()
    }

    fun onToggle2Click() {
        dataB.value = dataB.value.revert()
    }

    fun onToggle3Click() {
        dataC.value = dataC.value.revert()
    }

    private fun Boolean?.revert(): Boolean {
        return this != true
    }
}