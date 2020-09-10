LiveDataExtensions - Android LiveData Extensions for Kotlin, use like RxJava operators
--------------------------------------------------------------------------------------
[![Build Status](https://travis-ci.com/GunNan/LiveDataExtensions.svg?branch=master)](https://travis-ci.com/github/GunNan/LiveDataExtensions) [![Latest Version](https://img.shields.io/github/v/release/GunNan/LiveDataExtensions?include_prereleases)](https://github.com/GunNan/LiveDataExtensions)

LiveDataExtensions提供一些类似于RxJava操作符的kotlin扩展方法

## API说明

 - `combineWith`  多个liveData合并产生一个新的liveData
```
    val firstName = MutableLiveData<String>()
    val secondName = MutableLiveData<String>()
    val fullName = firstName.combineWith(secondName){
                        firstName,secondName-> "$firstName, $secondName"
                   }
    firstName.value = "glen"  // fullName 将会触发glen
    secondName.value = "sun"  // fullName 将会触发glen, sun
```

例子：

1. combineWith，几个LiveData联合触发
```
// 名字拼接
val firstName = LiveData<String>()
val secondName = LiveData<String>()

val fullName = firstName.combineWith(secondName){firstName,secondName-> "$firstName, $secondName"}
```

```
// 远程数据和本地数据联合触发
val localData = LiveData<String>()
val remoteData = LiveData<String>()

val showData = localData.combineWith(remoteData){localData,remoteData->
    if(!remoteData.isNullOrEmpty()){
        // 如果有网络数据，使用网络回包数据
        remoteData
    }else{
        localData
    }
}
```

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

