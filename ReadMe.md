LiveDataExtensions - Android LiveData Extensions for Kotlin, use like RxJava operators
--------------------------------------------------------------------------------------
[![Build Status](https://travis-ci.com/GunNan/LiveDataExtensions.svg?branch=master)](https://travis-ci.com/github/GunNan/LiveDataExtensions) [![Latest Version](https://img.shields.io/github/v/release/GunNan/LiveDataExtensions?include_prereleases)](https://github.com/GunNan/LiveDataExtensions)

LiveDataExtensions提供一些类似于RxJava操作符的kotlin扩展方法

## API说明

**Combine**

 - `combine`  多个不同类型的liveData合并，产生一个新的liveData
```
    val name = MutableLiveData<String>()
    val age = MutableLiveData<Int>()
    val title = name.combine(age) { name, age -> "$name, $age" }
    name.value = "glensun"  // title 将会触发glensun, null
    age.value = 18          // title 将会触发glen, 18
```

 - `merge`  多个相同类型的liveData合并，产生一个新的liveData
```
    val nameA = MutableLiveData<String>()
    val nameB = MutableLiveData<String>()
    val lastName = merge(nameA, nameB)
    nameA.value = "glen"    // lastName 将会触发glen
    nameB.value = "sun"     // lastName 将会触发sun
    nameA.value = "music"   // lastName 将会触发music
```


例子：

2. map映射变化
```
data class SongData(val songName:String,val singer:String)

val networkData = LiveData<SongData>()

val songTitle:LiveData<String> = networkData.map{it.singer + "演唱：" +it.songName}
```

3. filterNullMap
```
val networkData = LiveData<String>()

val networkDataNonNull = networkData.filterNullMap()
```

4. MainActivity里的综合应用
```
fetchBtn
    .switchMap {
        repository.fetchSongInfo()
        repository.observeSongInfo()
    }
    .filterNullMap()
    .log { Log.d(TAG, "songInfoRemote: $it") }
    .map { "${it.singer} : ${it.songName}" }
    .toMutable()
    .emitter { "正在加载..." }
```

