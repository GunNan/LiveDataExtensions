LiveDataExtensions - Android LiveData Extensions for Kotlin, use like RxJava operators
--------------------------------------------------------------------------------------
[![Build Status](https://travis-ci.com/GunNan/LiveDataExtensions.svg?branch=master)](https://travis-ci.com/github/GunNan/LiveDataExtensions) [![Latest Version](https://img.shields.io/github/v/release/GunNan/LiveDataExtensions?include_prereleases)](https://github.com/GunNan/LiveDataExtensions)

LiveDataExtensions提供一些类似于RxJava操作符的kotlin扩展方法

## API说明

**Combining**

 - `merge`  多个相同类型的liveData合并，产生一个新的liveData
```
    ---------[1]------------[5]----[4]------------->

    --------------[7]------------------------------>

                        merge

    ---------[1]--[7]-------[5]----[4]------------->
```

 - `startWith`  在LiveData发射数据之前，插入数据
```
    ---------[1]------------[5]----[4]------------->

                        startWith(7)

    ---[7]---[1]------------[5]----[4]------------->
```

 - `combine`  多个不同类型的liveData合并，产生一个新的liveData
```

    ---------[1]------------------------[5]----[4]-------------------->

    --------------------------[A]--------------------------[B]-------->

                                  combine

    -------[1,null]----------[1,A]-----[5,A]----[4,A]------[4,B]------>
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

