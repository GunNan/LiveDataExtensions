package com.glensun.livedataextension

import android.os.Handler
import android.os.Looper
import androidx.lifecycle.*

/**
 * Created by glensun on 2020/7/16 5:04 PM.
 * Copyright (c) 2020 Tencent. All rights reserved.
 */

// 多个LiveData联合触发
fun <T, K, R> LiveData<T>.combineWith(
        liveData: LiveData<K>?,
        block: (T?, K?) -> R
): LiveData<R> {
    val result = MediatorLiveData<R>()
    result.addSource(this) {
        result.value = block.invoke(this.value, liveData?.value)
    }
    if (liveData != null) {
        result.addSource(liveData) {
            result.value = block.invoke(this.value, liveData.value)
        }
    }
    return result
}

fun <T, K, U, R> LiveData<T>.combineWith(
        liveData1: LiveData<K>?,
        liveData2: LiveData<U>?,
        block: (T?, K?, U?) -> R
): LiveData<R> {
    val result = MediatorLiveData<R>()
    result.addSource(this) {
        result.value = block.invoke(this.value, liveData1?.value, liveData2?.value)
    }
    if (liveData1 != null) {
        result.addSource(liveData1) {
            result.value = block.invoke(this.value, liveData1.value, liveData2?.value)
        }
    }
    if (liveData2 != null) {
        result.addSource(liveData2) {
            result.value = block.invoke(this.value, liveData1?.value, liveData2.value)
        }
    }
    return result
}


fun <T, K, U, V, R> LiveData<T>.combineWith(
        liveData1: LiveData<K>?,
        liveData2: LiveData<U>?,
        liveData3: LiveData<V>?,
        block: (T?, K?, U?, V?) -> R
): LiveData<R> {
    val result = MediatorLiveData<R>()
    result.addSource(this) {
        result.value = block.invoke(this.value, liveData1?.value, liveData2?.value, liveData3?.value)
    }
    if (liveData1 != null) {
        result.addSource(liveData1) {
            result.value = block.invoke(this.value, liveData1.value, liveData2?.value, liveData3?.value)
        }
    }
    if (liveData2 != null) {
        result.addSource(liveData2) {
            result.value = block.invoke(this.value, liveData1?.value, liveData2.value, liveData3?.value)
        }
    }
    if (liveData3 != null) {
        result.addSource(liveData3) {
            result.value = block.invoke(this.value, liveData1?.value, liveData2?.value, liveData3.value)
        }
    }
    return result
}

fun <T, K, U, V, R, S> LiveData<T>.combineWith(
        liveData1: LiveData<K>?,
        liveData2: LiveData<U>?,
        liveData3: LiveData<V>?,
        liveData4: LiveData<R>?,
        block: (T?, K?, U?, V?, R?) -> S
): LiveData<S> {
    val result = MediatorLiveData<S>()
    result.addSource(this) {
        result.value = block.invoke(this.value, liveData1?.value, liveData2?.value, liveData3?.value, liveData4?.value)
    }
    if (liveData1 != null) {
        result.addSource(liveData1) {
            result.value = block.invoke(this.value, liveData1.value, liveData2?.value, liveData3?.value, liveData4?.value)
        }
    }
    if (liveData2 != null) {
        result.addSource(liveData2) {
            result.value = block.invoke(this.value, liveData1?.value, liveData2.value, liveData3?.value, liveData4?.value)
        }
    }
    if (liveData3 != null) {
        result.addSource(liveData3) {
            result.value = block.invoke(this.value, liveData1?.value, liveData2?.value, liveData3.value, liveData4?.value)
        }
    }
    if (liveData4 != null) {
        result.addSource(liveData4) {
            result.value = block.invoke(this.value, liveData1?.value, liveData2?.value, liveData3?.value, liveData4.value)
        }
    }
    return result
}

// 过滤一些触发条件
fun <X> LiveData<X>.filterMap(predicate: (X) -> Boolean): LiveData<X> = Transformations.switchMap(this) {
    val result = MutableLiveData<X>()
    if (predicate(it)) {
        result.postValue(it)
    }
    return@switchMap result
}

// 过滤null的情况
fun <X> LiveData<X>.filterNullMap(): LiveData<X> = filterMap { it != null }

// 延迟发射, 注意LiveData的特点，如果lifecycle的生命周期没走到START，那是不会发射的
fun <X> LiveData<X>.delay(milliseconds: Long): LiveData<X> {
    val result = MediatorLiveData<X>()
    result.addSource(this, object : Observer<X> {
        override fun onChanged(x: X) {
            Handler(Looper.getMainLooper())
                    .postDelayed({ result.postValue(x) },
                            milliseconds)
        }
    })
    return result
}

// 延迟发射, 注意LiveData的特点，如果lifecycle的生命周期没走到START，那是不会发射的
// 另外，这个是MutableLiveData, 会使用原LiveData进行发射
fun <X> MutableLiveData<X>.delay(milliseconds: Long): MutableLiveData<Pair<Boolean, X?>> {
    val result = MediatorLiveData<Pair<Boolean, X?>>()
    Handler(Looper.getMainLooper())
            .postDelayed({
                result.postValue(Pair(true, this.value))
            }, milliseconds)
    result.postValue(Pair(false, this.value))
    return result
}


//fun <X> MutableLiveData<X>.suspendDelay(milliseconds: Long, block: MutableLiveData<X>.() -> Unit): MutableLiveData<X> {
//    val result = MediatorLiveData<X>()
//    result.addSource(this, object : Observer<X> {
//        override fun onChanged(x: X) {
//
//        }
//    })
//    Handler(Looper.getMainLooper())
//            .postDelayed({
//                this.postValue(this.value)
//                block()
//            }, milliseconds)
//    return this
//}

// 转变成mutableLiveData
fun <X> LiveData<X>.toMutable(): MutableLiveData<X> {
    if (this is MutableLiveData) {
        return this
    } else {
        val result = MediatorLiveData<X>()
        result.addSource(this, object : Observer<X> {
            override fun onChanged(x: X) {
                result.postValue(x)
            }
        })
        return result
    }
}

// 转变成mutableLiveData
fun <X> LiveData<X>.toMutableAndEmit(): MutableLiveData<X> {
    if (this is MutableLiveData) {
        this.postValue(this.value)
        return this
    } else {
        val result = MediatorLiveData<X>()
        result.addSource(this, object : Observer<X> {
            override fun onChanged(x: X) {
                result.postValue(x)
            }
        })
        result.postValue(this.value)
        return result
    }
}

// 发射一个元素
fun <X> MutableLiveData<X>.emitter(block: () -> X): MutableLiveData<X> {
    this.postValue(block())
    return this
}

// 打个log
fun <X> LiveData<X>.log(printer: (X) -> Unit): LiveData<X> {
    return this.map {
        printer(it)
        it
    }
}

// 对于一个Boolean类型的LiveData，判断其值是否为真
fun LiveData<Boolean>.isTrue(): Boolean {
    return this.value == true
}