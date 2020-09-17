package com.glensun.livedataextension

import androidx.annotation.MainThread
import androidx.lifecycle.*

/**
 * Combine with multi LiveData changed, map the data by transform
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
 * Combine with multi LiveData changed, map the data by transform
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
 * Combine with multi LiveData changed, map the data by transform
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
 * Combine with multi LiveData changed, map the data by transform
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

/**
 * Combine multi LiveDatas, map the data by transform
 */
@JvmName("combineAll")
@MainThread
inline fun <A, B, R> combine(
    liveData1: LiveData<A>?,
    liveData2: LiveData<B>?,
    crossinline transform: (A?, B?) -> R
): LiveData<R> {
    val result = MediatorLiveData<R>()
    if (liveData1 != null) {
        result.addSource(liveData1) { a -> result.setValue(transform(a, liveData2?.value)) }
    }
    if (liveData2 != null) {
        result.addSource(liveData2) { b -> result.setValue(transform(liveData1?.value, b)) }
    }
    return result
}

/**
 * Combine multi LiveDatas, map the data by transform
 */
@JvmName("combineAll")
@MainThread
inline fun <A, B, C, R> combine(
    liveData1: LiveData<A>?,
    liveData2: LiveData<B>?,
    liveData3: LiveData<C>?,
    crossinline transform: (A?, B?, C?) -> R
): LiveData<R> {
    val result = MediatorLiveData<R>()
    if (liveData1 != null) {
        result.addSource(liveData1) { a ->
            result.setValue(transform(a, liveData2?.value, liveData3?.value))
        }
    }
    if (liveData2 != null) {
        result.addSource(liveData2) { b ->
            result.setValue(transform(liveData1?.value, b, liveData3?.value))
        }
    }
    if (liveData3 != null) {
        result.addSource(liveData3) { c ->
            result.setValue(transform(liveData1?.value, liveData2?.value, c))
        }
    }
    return result
}

/**
 * Combine multi LiveDatas, map the data by transform
 */
@JvmName("combineAll")
@MainThread
inline fun <A, B, C, D, R> combine(
    liveData1: LiveData<A>?,
    liveData2: LiveData<B>?,
    liveData3: LiveData<C>?,
    liveData4: LiveData<D>?,
    crossinline transform: (A?, B?, C?, D?) -> R
): LiveData<R> {
    val result = MediatorLiveData<R>()
    if (liveData1 != null) {
        result.addSource(liveData1) { a ->
            result.setValue(transform(a, liveData2?.value, liveData3?.value, liveData4?.value))
        }
    }
    if (liveData2 != null) {
        result.addSource(liveData2) { b ->
            result.setValue(transform(liveData1?.value, b, liveData3?.value, liveData4?.value))
        }
    }
    if (liveData3 != null) {
        result.addSource(liveData3) { c ->
            result.setValue(transform(liveData1?.value, liveData2?.value, c, liveData4?.value))
        }
    }
    if (liveData4 != null) {
        result.addSource(liveData4) { d ->
            result.setValue(transform(liveData1?.value, liveData2?.value, liveData3?.value, d))
        }
    }
    return result
}

/**
 * Combine multi LiveDatas, map the data by transform
 */
@JvmName("combineAll")
@MainThread
inline fun <A, B, C, D, E, R> combine(
    liveData1: LiveData<A>?,
    liveData2: LiveData<B>?,
    liveData3: LiveData<C>?,
    liveData4: LiveData<D>?,
    liveData5: LiveData<E>?,
    crossinline transform: (A?, B?, C?, D?, E?) -> R
): LiveData<R> {
    val result = MediatorLiveData<R>()
    if (liveData1 != null) {
        result.addSource(liveData1) { a ->
            result.setValue(
                transform(
                    a,
                    liveData2?.value,
                    liveData3?.value,
                    liveData4?.value,
                    liveData5?.value
                )
            )
        }
    }
    if (liveData2 != null) {
        result.addSource(liveData2) { b ->
            result.setValue(
                transform(
                    liveData1?.value,
                    b,
                    liveData3?.value,
                    liveData4?.value,
                    liveData5?.value
                )
            )
        }
    }
    if (liveData3 != null) {
        result.addSource(liveData3) { c ->
            result.setValue(
                transform(
                    liveData1?.value,
                    liveData2?.value,
                    c,
                    liveData4?.value,
                    liveData5?.value
                )
            )
        }
    }
    if (liveData4 != null) {
        result.addSource(liveData4) { d ->
            result.setValue(
                transform(
                    liveData1?.value,
                    liveData2?.value,
                    liveData3?.value,
                    d,
                    liveData5?.value
                )
            )
        }
    }
    if (liveData5 != null) {
        result.addSource(liveData5) { e ->
            result.setValue(
                transform(
                    liveData1?.value,
                    liveData2?.value,
                    liveData3?.value,
                    liveData4?.value,
                    e
                )
            )
        }
    }
    return result
}

/**
 * Merge multi LiveData, which has same type
 */
@MainThread
inline fun <T> merge(vararg liveDatas: LiveData<T>): LiveData<T> {
    val result = MediatorLiveData<T>()
    liveDatas.forEach { liveData ->
        result.addSource(liveData) { it -> result.setValue(it) }
    }
    return result
}

/**
 * Merge with other LiveData
 */
@MainThread
inline fun <T> LiveData<T>.merge(liveData: LiveData<T>?): LiveData<T> {
    val result = MediatorLiveData<T>()
    result.addSource(this) { result.setValue(it) }
    if (liveData != null) {
        result.addSource(liveData) { result.setValue(it) }
    }
    return result
}

/**
 * Zip with other LiveData, generate a LiveData<List>
 */
@MainThread
inline fun <T> LiveData<T>.zip(liveData: LiveData<T>?): LiveData<List<T>> {
    return this.combineNonNull(liveData) { thisValue, liveDataValue ->
        listOf(thisValue, liveDataValue)
    }
}

/**
 * Zip with other LiveData, generate a LiveData<List>
 */
@JvmName("zipList")
@MainThread
inline fun <T> LiveData<List<T>>.zip(liveData: LiveData<T>?): LiveData<List<T>> {
    return this.combineNonNull(liveData) { thisValue, liveDataValue ->
        thisValue + liveDataValue
    }
}

/**
 * Zip multi LiveData, which has same type, generate a LiveData<List>
 */
@JvmName("zipAll")
@MainThread
inline fun <T> zip(vararg liveDatas: LiveData<T>): LiveData<List<T>> {
    val resultList = MutableList<T?>(liveDatas.size) { null }
    val result = MediatorLiveData<List<T>>()
    liveDatas.forEachIndexed { index, liveData ->
        result.addSource(liveData) { it ->
            resultList[index] = it
            if (resultList.isItemNonNull()) {
                result.setValue(resultList.map { it!! })
            }
        }
    }
    return result
}

/**
 * Combine with multi LiveData changed, map the data by transform
 */
@MainThread
inline fun <A, B, R> LiveData<A>.combineNonNull(
    liveData: LiveData<B>?,
    crossinline transform: (A, B) -> R
): LiveData<R> {
    val result = MediatorLiveData<R>()
    result.addSource(this) { a ->
        val liveDataValue = liveData?.value
        if (a != null && liveDataValue != null) {
            result.setValue(transform(a, liveDataValue))
        }
    }
    if (liveData != null) {
        result.addSource(liveData) { b ->
            val liveDataValue = this@combineNonNull.value
            if (b != null && liveDataValue != null) {
                result.setValue(transform(liveDataValue, b))
            }
        }
    }
    return result
}


/**
 * Combine with multi LiveData changed, map the data by transform
 */
@MainThread
inline fun <A, B, C, R> LiveData<A>.combineNonNull(
    liveData1: LiveData<B>?,
    liveData2: LiveData<C>?,
    crossinline transform: (A, B, C) -> R
): LiveData<R> {
    val result = MediatorLiveData<R>()
    result.addSource(this) { a ->
        val liveData1Value = liveData1?.value
        val liveData2Value = liveData2?.value
        if (a != null && liveData1Value != null && liveData2Value != null) {
            result.setValue(transform(a, liveData1Value, liveData2Value))
        }
    }
    if (liveData1 != null) {
        result.addSource(liveData1) { b ->
            val liveDataValue = this@combineNonNull.value
            val liveData2Value = liveData2?.value
            if (b != null && liveDataValue != null && liveData2Value != null) {
                result.setValue(transform(liveDataValue, b, liveData2Value))
            }
        }
    }
    if (liveData2 != null) {
        result.addSource(liveData2) { c ->
            val liveDataValue = this@combineNonNull.value
            val liveData1Value = liveData1?.value
            if (c != null && liveDataValue != null && liveData1Value != null) {
                result.setValue(transform(liveDataValue, liveData1Value, c))
            }
        }
    }
    return result
}

/**
 * Combine with multi LiveData changed, map the data by transform
 */
@MainThread
inline fun <A, B, C, D, R> LiveData<A>.combineNonNull(
    liveData1: LiveData<B>?,
    liveData2: LiveData<C>?,
    liveData3: LiveData<D>?,
    crossinline transform: (A, B, C, D) -> R
): LiveData<R> {
    val result = MediatorLiveData<R>()
    result.addSource(this) { a ->
        val liveData1Value = liveData1?.value
        val liveData2Value = liveData2?.value
        val liveData3Value = liveData3?.value
        if (a != null && liveData1Value != null && liveData2Value != null && liveData3Value != null) {
            result.setValue(transform(a, liveData1Value, liveData2Value, liveData3Value))
        }
    }
    if (liveData1 != null) {
        result.addSource(liveData1) { b ->
            val liveDataValue = this@combineNonNull.value
            val liveData2Value = liveData2?.value
            val liveData3Value = liveData3?.value
            if (b != null && liveDataValue != null && liveData2Value != null && liveData3Value != null) {
                result.setValue(transform(liveDataValue, b, liveData2Value, liveData3Value))
            }
        }
    }
    if (liveData2 != null) {
        result.addSource(liveData2) { c ->
            val liveDataValue = this@combineNonNull.value
            val liveData1Value = liveData1?.value
            val liveData3Value = liveData3?.value
            if (c != null && liveDataValue != null && liveData1Value != null && liveData3Value != null) {
                result.setValue(transform(liveDataValue, liveData1Value, c, liveData3Value))
            }
        }
    }
    if (liveData3 != null) {
        result.addSource(liveData3) { d ->
            val liveDataValue = this@combineNonNull.value
            val liveData1Value = liveData1?.value
            val liveData2Value = liveData2?.value
            if (d != null && liveDataValue != null && liveData1Value != null && liveData2Value != null) {
                result.setValue(transform(liveDataValue, liveData1Value, liveData2Value, d))
            }
        }
    }
    return result
}

/**
 * Combine with multi LiveData changed, map the data by transform
 */
@MainThread
inline fun <A, B, C, D, E, R> LiveData<A>.combineNonNull(
    liveData1: LiveData<B>?,
    liveData2: LiveData<C>?,
    liveData3: LiveData<D>?,
    liveData4: LiveData<E>?,
    crossinline transform: (A, B, C, D, E) -> R
): LiveData<R> {
    val result = MediatorLiveData<R>()
    result.addSource(this) { a ->
        val liveData1Value = liveData1?.value
        val liveData2Value = liveData2?.value
        val liveData3Value = liveData3?.value
        val liveData4Value = liveData4?.value
        if (a != null && liveData1Value != null && liveData2Value != null && liveData3Value != null && liveData4Value != null) {
            result.setValue(
                transform(
                    a,
                    liveData1Value,
                    liveData2Value,
                    liveData3Value,
                    liveData4Value
                )
            )
        }
    }
    if (liveData1 != null) {
        result.addSource(liveData1) { b ->
            val liveDataValue = this@combineNonNull.value
            val liveData2Value = liveData2?.value
            val liveData3Value = liveData3?.value
            val liveData4Value = liveData4?.value
            if (b != null && liveDataValue != null && liveData2Value != null && liveData3Value != null && liveData4Value != null) {
                result.setValue(
                    transform(
                        liveDataValue,
                        b,
                        liveData2Value,
                        liveData3Value,
                        liveData4Value
                    )
                )
            }
        }
    }
    if (liveData2 != null) {
        result.addSource(liveData2) { c ->
            val liveDataValue = this@combineNonNull.value
            val liveData1Value = liveData1?.value
            val liveData3Value = liveData3?.value
            val liveData4Value = liveData4?.value
            if (c != null && liveDataValue != null && liveData1Value != null && liveData3Value != null && liveData4Value != null) {
                result.setValue(
                    transform(
                        liveDataValue,
                        liveData1Value,
                        c,
                        liveData3Value,
                        liveData4Value
                    )
                )
            }
        }
    }
    if (liveData3 != null) {
        result.addSource(liveData3) { d ->
            val liveDataValue = this@combineNonNull.value
            val liveData1Value = liveData1?.value
            val liveData2Value = liveData2?.value
            val liveData4Value = liveData4?.value
            if (d != null && liveDataValue != null && liveData1Value != null && liveData2Value != null && liveData4Value != null) {
                result.setValue(
                    transform(
                        liveDataValue,
                        liveData1Value,
                        liveData2Value,
                        d,
                        liveData4Value
                    )
                )
            }
        }
    }
    if (liveData4 != null) {
        result.addSource(liveData4) { e ->
            val liveDataValue = this@combineNonNull.value
            val liveData1Value = liveData1?.value
            val liveData2Value = liveData2?.value
            val liveData3Value = liveData3?.value
            if (e != null && liveDataValue != null && liveData1Value != null && liveData2Value != null && liveData3Value != null) {
                result.setValue(
                    transform(
                        liveDataValue,
                        liveData1Value,
                        liveData2Value,
                        liveData3Value,
                        e
                    )
                )
            }
        }
    }
    return result
}


/**
 * Combine multi LiveDatas, map the data by transform
 */
@JvmName("combineNonNullAll")
@MainThread
inline fun <A, B, R> combineNonNull(
    liveData1: LiveData<A>?,
    liveData2: LiveData<B>?,
    crossinline transform: (A, B) -> R
): LiveData<R> {
    val result = MediatorLiveData<R>()
    if (liveData1 != null) {
        result.addSource(liveData1) { a ->
            val liveData2Value = liveData2?.value
            if (a != null && liveData2Value != null) {
                result.setValue(transform(a, liveData2Value))
            }
        }
    }
    if (liveData2 != null) {
        result.addSource(liveData2) { b ->
            val liveData1Value = liveData1?.value
            if (b != null && liveData1Value != null) {
                result.setValue(transform(liveData1Value, b))
            }
        }
    }
    return result
}

/**
 * Combine multi LiveDatas, map the data by transform
 */
@JvmName("combineNonNullAll")
@MainThread
inline fun <A, B, C, R> combineNonNull(
    liveData1: LiveData<A>?,
    liveData2: LiveData<B>?,
    liveData3: LiveData<C>?,
    crossinline transform: (A, B, C) -> R
): LiveData<R> {
    val result = MediatorLiveData<R>()
    if (liveData1 != null) {
        result.addSource(liveData1) { a ->
            val liveData2Value = liveData2?.value
            val liveData3Value = liveData3?.value
            if (a != null && liveData2Value != null && liveData3Value != null) {
                result.setValue(transform(a, liveData2Value, liveData3Value))
            }
        }
    }
    if (liveData2 != null) {
        result.addSource(liveData2) { b ->
            val liveData1Value = liveData1?.value
            val liveData3Value = liveData3?.value
            if (b != null && liveData1Value != null && liveData3Value != null) {
                result.setValue(transform(liveData1Value, b, liveData3Value))
            }
        }
    }
    if (liveData3 != null) {
        result.addSource(liveData3) { c ->
            val liveData1Value = liveData1?.value
            val liveData2Value = liveData2?.value
            if (c != null && liveData1Value != null && liveData2Value != null) {
                result.setValue(transform(liveData1Value, liveData2Value, c))
            }
        }
    }
    return result
}

/**
 * Combine multi LiveDatas, map the data by transform
 */
@JvmName("combineNonNullAll")
@MainThread
inline fun <A, B, C, D, R> combineNonNull(
    liveData1: LiveData<A>?,
    liveData2: LiveData<B>?,
    liveData3: LiveData<C>?,
    liveData4: LiveData<D>?,
    crossinline transform: (A, B, C, D) -> R
): LiveData<R> {
    val result = MediatorLiveData<R>()
    if (liveData1 != null) {
        result.addSource(liveData1) { a ->
            val liveData2Value = liveData2?.value
            val liveData3Value = liveData3?.value
            val liveData4Value = liveData4?.value
            if (a != null && liveData2Value != null && liveData3Value != null && liveData4Value != null) {
                result.setValue(transform(a, liveData2Value, liveData3Value, liveData4Value))
            }
        }
    }
    if (liveData2 != null) {
        result.addSource(liveData2) { b ->
            val liveData1Value = liveData1?.value
            val liveData3Value = liveData3?.value
            val liveData4Value = liveData4?.value
            if (b != null && liveData1Value != null && liveData3Value != null && liveData4Value != null) {
                result.setValue(transform(liveData1Value, b, liveData3Value, liveData4Value))
            }
        }
    }
    if (liveData3 != null) {
        result.addSource(liveData3) { c ->
            val liveData1Value = liveData1?.value
            val liveData2Value = liveData2?.value
            val liveData4Value = liveData4?.value
            if (c != null && liveData1Value != null && liveData2Value != null && liveData4Value != null) {
                result.setValue(transform(liveData1Value, liveData2Value, c, liveData4Value))
            }
        }
    }
    if (liveData4 != null) {
        result.addSource(liveData4) { d ->
            val liveData1Value = liveData1?.value
            val liveData2Value = liveData2?.value
            val liveData3Value = liveData3?.value
            if (d != null && liveData1Value != null && liveData2Value != null && liveData3Value != null) {
                result.setValue(transform(liveData1Value, liveData2Value, liveData3Value, d))
            }
        }
    }
    return result
}

/**
 * Combine multi LiveDatas, map the data by transform
 */
@JvmName("combineNonNullAll")
@MainThread
inline fun <A, B, C, D, E, R> combineNonNull(
    liveData1: LiveData<A>?,
    liveData2: LiveData<B>?,
    liveData3: LiveData<C>?,
    liveData4: LiveData<D>?,
    liveData5: LiveData<E>?,
    crossinline transform: (A, B, C, D, E) -> R
): LiveData<R> {
    val result = MediatorLiveData<R>()
    if (liveData1 != null) {
        result.addSource(liveData1) { a ->
            val liveData2Value = liveData2?.value
            val liveData3Value = liveData3?.value
            val liveData4Value = liveData4?.value
            val liveData5Value = liveData5?.value
            if (a != null && liveData2Value != null && liveData3Value != null && liveData4Value != null && liveData5Value != null) {
                result.setValue(
                    transform(
                        a,
                        liveData2Value,
                        liveData3Value,
                        liveData4Value,
                        liveData5Value
                    )
                )
            }
        }
    }
    if (liveData2 != null) {
        result.addSource(liveData2) { b ->
            val liveData1Value = liveData1?.value
            val liveData3Value = liveData3?.value
            val liveData4Value = liveData4?.value
            val liveData5Value = liveData5?.value
            if (b != null && liveData1Value != null && liveData3Value != null && liveData4Value != null && liveData5Value != null) {
                result.setValue(
                    transform(
                        liveData1Value,
                        b,
                        liveData3Value,
                        liveData4Value,
                        liveData5Value
                    )
                )
            }
        }
    }
    if (liveData3 != null) {
        result.addSource(liveData3) { c ->
            val liveData1Value = liveData1?.value
            val liveData2Value = liveData2?.value
            val liveData4Value = liveData4?.value
            val liveData5Value = liveData5?.value
            if (c != null && liveData1Value != null && liveData2Value != null && liveData4Value != null && liveData5Value != null) {
                result.setValue(
                    transform(
                        liveData1Value,
                        liveData2Value,
                        c,
                        liveData4Value,
                        liveData5Value
                    )
                )
            }
        }
    }
    if (liveData4 != null) {
        result.addSource(liveData4) { d ->
            val liveData1Value = liveData1?.value
            val liveData2Value = liveData2?.value
            val liveData3Value = liveData3?.value
            val liveData5Value = liveData5?.value
            if (d != null && liveData1Value != null && liveData2Value != null && liveData3Value != null && liveData5Value != null) {
                result.setValue(
                    transform(
                        liveData1Value,
                        liveData2Value,
                        liveData3Value,
                        d,
                        liveData5Value
                    )
                )
            }
        }
    }
    if (liveData5 != null) {
        result.addSource(liveData5) { e ->
            val liveData1Value = liveData1?.value
            val liveData2Value = liveData2?.value
            val liveData3Value = liveData3?.value
            val liveData4Value = liveData4?.value
            if (e != null && liveData1Value != null && liveData2Value != null && liveData3Value != null && liveData4Value != null) {
                result.setValue(
                    transform(
                        liveData1Value,
                        liveData2Value,
                        liveData3Value,
                        liveData4Value,
                        e
                    )
                )
            }
        }
    }
    return result
}

/**
 * Start With a default value
 */
@MainThread
inline fun <T> LiveData<T>.startWith(default: T): LiveData<T> {
    val defaultLiveData = MutableLiveData(default)
    return defaultLiveData.merge(this)
}

/**
 * React on LiveData changed, map the data by transform
 */
@MainThread
inline fun <X, Y> LiveData<X>.map(crossinline transform: (X?) -> Y): LiveData<Y> =
    Transformations.map(this) { transform(it) }

/**
 * React on LiveData changed, return a liveData by transform, which can trigger result change
 */
@MainThread
inline fun <X, Y> LiveData<X>.switchMap(
    crossinline transform: (X?) -> LiveData<Y>
): LiveData<Y> = Transformations.switchMap(this) { transform(it) }


/**
 * Filter some value on LiveData changed
 */
@MainThread
inline fun <X> LiveData<X>.filter(crossinline predicate: (X?) -> Boolean): LiveData<X> {
    val result = MediatorLiveData<X>()
    result.addSource(this) {
        if (predicate(it)) {
            result.setValue(it)
        }
    }
    return result
}

/**
 * Filter non null value on LiveData changed
 */
@MainThread
inline fun <X> LiveData<X>.filterNonNull(): LiveData<X> {
    val result = MediatorLiveData<X>()
    result.addSource(this) {
        if (it != null) {
            result.setValue(it)
        }
    }
    return result
}

@MainThread
inline fun <X> LiveData<X>.distinctUntilChanged(): LiveData<X> =
    Transformations.distinctUntilChanged(this)

@MainThread
inline fun <X> LiveData<X>.distinct(): LiveData<X> {
    val result = MediatorLiveData<X>()
    result.addSource(this, object : Observer<X> {
        val alreadyTriggerSet = mutableSetOf<X>()
        override fun onChanged(t: X) {
            if (t != null && !alreadyTriggerSet.contains(t)) {
                result.setValue(t)
                alreadyTriggerSet.add(t)
            }
        }
    })
    return result
}

inline fun <X> LiveData<X>.toMutable(): MutableLiveData<X> {
    if (this is MutableLiveData) {
        return this
    } else {
        val result = MediatorLiveData<X>()
        result.addSource(this) { x -> result.postValue(x) }
        return result
    }
}

@MainThread
inline fun <X> LiveData<X>.log(crossinline printer: (X?) -> Unit): LiveData<X> {
    val result = MediatorLiveData<X>()
    result.addSource(this) { x ->
        printer(x)
        result.setValue(x)
    }
    return result
}

@MainThread
inline fun LiveData<List<Boolean?>>.isAllTrue(): LiveData<Boolean> {
    val result = MediatorLiveData<Boolean>()
    result.addSource(this) { list ->
        if (list != null) {
            val itemFalse = list.find { item -> item == false }
            if (itemFalse != null) {
                result.setValue(false)
            } else {
                result.setValue(true)
            }
        } else {
            result.setValue(false)
        }
    }
    return result
}

@MainThread
inline fun <T> LiveData<T>.doBefore(crossinline block: () -> Unit): LiveData<T> {
    val result = MediatorLiveData<T>()
    result.addSource(this) {
        block()
        result.setValue(it)
    }
    return result
}

@MainThread
inline fun <T> LiveData<T>.doAfter(crossinline block: () -> Unit): LiveData<T> {
    val result = MediatorLiveData<T>()
    result.addSource(this) {
        result.setValue(it)
        block()
    }
    return result
}

@MainThread
inline fun <T> LiveData<T>.defaultIfNull(value: T): LiveData<T> {
    val result = MediatorLiveData<T>()
    result.addSource(this) {
        if (it == null) {
            result.setValue(value)
        } else {
            result.setValue(it)
        }
    }
    return result
}


inline fun <T> List<T?>.isItemContainsNull(): Boolean {
    var isItemNull = false
    this.forEach {
        if (it == null) {
            isItemNull = true
            return@forEach
        }
    }
    return isItemNull
}

inline fun <T> List<T?>.isItemNonNull(): Boolean = !this.isItemContainsNull()


//
//// 延迟发射, 注意LiveData的特点，如果lifecycle的生命周期没走到START，那是不会发射的
//fun <X> LiveData<X>.delay(milliseconds: Long): LiveData<X> {
//    val result = MediatorLiveData<X>()
//    result.addSource(this, object : Observer<X> {
//        override fun onChanged(x: X) {
//            Handler(Looper.getMainLooper())
//                .postDelayed(
//                    { result.postValue(x) },
//                    milliseconds
//                )
//        }
//    })
//    return result
//}
//
//// 延迟发射, 注意LiveData的特点，如果lifecycle的生命周期没走到START，那是不会发射的
//// 另外，这个是MutableLiveData, 会使用原LiveData进行发射
//fun <X> MutableLiveData<X>.delay(milliseconds: Long): MutableLiveData<Pair<Boolean, X?>> {
//    val result = MediatorLiveData<Pair<Boolean, X?>>()
//    Handler(Looper.getMainLooper())
//        .postDelayed({
//            result.postValue(Pair(true, this.value))
//        }, milliseconds)
//    result.postValue(Pair(false, this.value))
//    return result
//}


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
