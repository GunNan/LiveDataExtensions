package com.glensun.examplenonx

import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.glensun.livedataextension.map
import com.glensun.livedataextension.*

private const val TAG = "ZipExampleViewModel"

class ZipExampleViewModel : ViewModel(), LifecycleObserver {
    private val dataA = MutableLiveData<Boolean>()
    private val dataB = MutableLiveData<Boolean>()
    private val dataC = MutableLiveData<Boolean>()

    // show data
    private val zipData: LiveData<List<Boolean>> = dataA.zip(dataB).zip(dataC)
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