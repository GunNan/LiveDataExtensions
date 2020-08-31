LiveData的一些扩展方法，例如

1. combineWith
```
val firstName = LiveData<String>()
val secondName = LiveData<String>()

val fullName = firstName.combineWith(secondName){firstName,secondName-> "$firstName, $secondName"}
```

2. filterNullMap
```
val networkData = LiveData<String>()

val networkDataNonNull = networkData.filterNullMap()
```

3. 综合应用
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

