package com.glensun.livedataextension

import android.os.Handler
import android.os.Looper
import androidx.annotation.MainThread
import androidx.lifecycle.*

/**
 * React on LiveData changed, map the data by transform
 */
@MainThread
inline fun <X, Y> LiveData<X>.map(crossinline transform: (X?) -> Y): LiveData<Y> {
    val result = MediatorLiveData<Y>()
    result.addSource(this) { result.setValue(transform(it)) }
    return result
}

/**
 * Combine with multi LiveData changed, merge the data by transform
 */
@MainThread
inline fun <A, B, R> LiveData<A>.combine(
    liveData: LiveData<B>?,
    crossinline transform: (A?, B?) -> R
): LiveData<R> {
    val result = MediatorLiveData<R>()
    result.addSource(this) { a -> result.setValue(transform(a, liveData?.value)) }
    if (liveData != null) {
        result.addSource(liveData) { b -> result.setValue(transform(this@combine.value, b)) }
    }
    return result
}

/**
 * Combine with multi LiveData changed, merge the data by transform
 */
@MainThread
inline fun <A, B, C, R> LiveData<A>.combine(
    liveData1: LiveData<B>?,
    liveData2: LiveData<C>?,
    crossinline transform: (A?, B?, C?) -> R
): LiveData<R> {
    val result = MediatorLiveData<R>()
    result.addSource(this) { a ->
        result.setValue(transform(a, liveData1?.value, liveData2?.value))
    }
    if (liveData1 != null) {
        result.addSource(liveData1) { b ->
            result.setValue(transform(this@combine.value, b, liveData2?.value))
        }
    }
    if (liveData2 != null) {
        result.addSource(liveData2) { c ->
            result.setValue(transform(this@combine.value, liveData1?.value, c))
        }
    }
    return result
}

/**
 * Combine with multi LiveData changed, merge the data by transform
 */
@MainThread
inline fun <A, B, C, D, R> LiveData<A>.combine(
    liveData1: LiveData<B>?,
    liveData2: LiveData<C>?,
    liveData3: LiveData<D>?,
    crossinline transform: (A?, B?, C?, D?) -> R
): LiveData<R> {
    val result = MediatorLiveData<R>()
    result.addSource(this) { a ->
        result.setValue(transform(a, liveData1?.value, liveData2?.value, liveData3?.value))
    }
    if (liveData1 != null) {
        result.addSource(liveData1) { b ->
            result.setValue(transform(this@combine.value, b, liveData2?.value, liveData3?.value))
        }
    }
    if (liveData2 != null) {
        result.addSource(liveData2) { c ->
            result.setValue(transform(this@combine.value, liveData1?.value, c, liveData3?.value))
        }
    }
    if (liveData3 != null) {
        result.addSource(liveData3) { d ->
            result.setValue(transform(this@combine.value, liveData1?.value, liveData2?.value, d))
        }
    }
    return result
}

/**
 * Combine with multi LiveData changed, merge the data by transform
 */
@MainThread
inline fun <A, B, C, D, E, R> LiveData<A>.combine(
    liveData1: LiveData<B>?,
    liveData2: LiveData<C>?,
    liveData3: LiveData<D>?,
    liveData4: LiveData<E>?,
    crossinline transform: (A?, B?, C?, D?, E?) -> R
): LiveData<R> {
    val result = MediatorLiveData<R>()
    result.addSource(this) { a ->
        result.setValue(
            transform(
                a,
                liveData1?.value,
                liveData2?.value,
                liveData3?.value,
                liveData4?.value
            )
        )
    }
    if (liveData1 != null) {
        result.addSource(liveData1) { b ->
            result.setValue(
                transform(
                    this@combine.value,
                    b,
                    liveData2?.value,
                    liveData3?.value,
                    liveData4?.value
                )
            )
        }
    }
    if (liveData2 != null) {
        result.addSource(liveData2) { c ->
            result.setValue(
                transform(
                    this@combine.value,
                    liveData1?.value,
                    c,
                    liveData3?.value,
                    liveData4?.value
                )
            )
        }
    }
    if (liveData3 != null) {
        result.addSource(liveData3) { d ->
            result.setValue(
                transform(
                    this@combine.value,
                    liveData1?.value,
                    liveData2?.value,
                    d,
                    liveData4?.value
                )
            )
        }
    }
    if (liveData4 != null) {
        result.addSource(liveData4) { e ->
            result.setValue(
                transform(
                    this@combine.value,
                    liveData1?.value,
                    liveData2?.value,
                    liveData3?.value,
                    e
                )
            )
        }
    }
    return result
}


///**
// * Combine multi LiveDatas, merge the data by transform
// */
//@JvmName("resetMediaListByMvList")
//@MainThread
//inline fun <A, B, R> combine(
//    liveData1: LiveData<A>?,
//    liveData2: LiveData<B>?,
//    crossinline transform: (A?, B?) -> R
//): LiveData<R> {
//    val result = MediatorLiveData<R>()
//    result.addSource(this) { a ->
//        result.setValue(
//            transform(
//                a,
//                liveData1?.value,
//                liveData2?.value,
//                liveData3?.value,
//                liveData4?.value
//            )
//        )
//    }
//    if (liveData1 != null) {
//        result.addSource(liveData1) { b ->
//            result.setValue(
//                transform(
//                    this@combine.value,
//                    b,
//                    liveData2?.value,
//                    liveData3?.value,
//                    liveData4?.value
//                )
//            )
//        }
//    }
//    if (liveData2 != null) {
//        result.addSource(liveData2) { c ->
//            result.setValue(
//                transform(
//                    this@combine.value,
//                    liveData1?.value,
//                    c,
//                    liveData3?.value,
//                    liveData4?.value
//                )
//            )
//        }
//    }
//    if (liveData3 != null) {
//        result.addSource(liveData3) { d ->
//            result.setValue(
//                transform(
//                    this@combine.value,
//                    liveData1?.value,
//                    liveData2?.value,
//                    d,
//                    liveData4?.value
//                )
//            )
//        }
//    }
//    if (liveData4 != null) {
//        result.addSource(liveData4) { e ->
//            result.setValue(
//                transform(
//                    this@combine.value,
//                    liveData1?.value,
//                    liveData2?.value,
//                    liveData3?.value,
//                    e
//                )
//            )
//        }
//    }
//    return result
//}

/**
 * Merge multi LiveData, which has same type
 */
inline fun <T> merge(vararg liveDatas: LiveData<T>): LiveData<T> {
    val result = MediatorLiveData<T>()
    liveDatas.forEach { liveData ->
        result.addSource(liveData) { result.setValue(it) }
    }
    return result
}


// 过滤一些触发条件
fun <X> LiveData<X>.filterMap(predicate: (X) -> Boolean): LiveData<X> =
    Transformations.switchMap(this) {
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
                .postDelayed(
                    { result.postValue(x) },
                    milliseconds
                )
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
    val result = MediatorLiveData<X>()
    result.addSource(this, object : Observer<X> {
        override fun onChanged(x: X) {
            printer(x)
            result.postValue(x)
        }
    })
    return result
}

// 对于一个Boolean类型的LiveData，判断其值是否为真
fun LiveData<Boolean>.isTrue(): Boolean {
    return this.value == true
}

//inline fun <X, Y> LiveData<X>.switchMap(
//    crossinline transform: (X?) -> LiveData<Y>
//): LiveData<Y> = Transformations.switchMap(this) { transform(it) }
//
//inline fun <X> LiveData<X>.distinctUntilChanged(): LiveData<X> =
//    Transformations.distinctUntilChanged(this)

//
//fun <T> merge(vararg liveDatas: LiveData<T>): LiveData<List<T?>> {
//    return merge(liveDatas.toList())
//}
//
//fun <T> merge(liveDatas: List<LiveData<T>>): LiveData<List<T?>> {
//    val result = MediatorLiveData<List<T?>>()
//
//    liveDatas.forEachIndexed { index, liveData ->
//        result.addSource(liveData) {
//            var resultList = result.value?.toMutableList()
//            if (resultList == null) {
//                resultList = MutableList(liveDatas.size) { null }
//            }
//            resultList[index] = it
//
//            result.postValue(resultList)
//        }
//    }
//    return result
//}
//
//fun <T> LiveData<List<T?>>.merge(liveData: LiveData<T>): LiveData<List<T?>> {
//    val result = MediatorLiveData<List<T?>>()
//    result.addSource(this, object : Observer<List<T?>> {
//        override fun onChanged(it: List<T?>?) {
//            it?.toMutableList()?.add(liveData.value)
//            result.postValue(it)
//        }
//    }
//    )
//    result.addSource(liveData, object : Observer<T> {
//        override fun onChanged(it: T) {
//            val list = this@merge.value
//            list?.toMutableList()?.add(it)
//            result.postValue(list)
//        }
//
//    })
//    return result
//}
