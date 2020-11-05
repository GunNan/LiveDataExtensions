LiveDataExtensions - Android LiveData Extensions for Kotlin, use like RxJava operators
--------------------------------------------------------------------------------------
[![Build Status](https://travis-ci.com/GunNan/LiveDataExtensions.svg?branch=master)](https://travis-ci.com/github/GunNan/LiveDataExtensions) [![Latest Version](https://img.shields.io/github/v/release/GunNan/LiveDataExtensions?include_prereleases)](https://github.com/GunNan/LiveDataExtensions)

LiveDataExtensions提供一些类似于RxJava操作符的kotlin扩展方法

## Use

**添加jcenter**

```
    buildscript {
       repositories {
            ...
            jcenter()
        }
    }
```

**添加依赖Dependencies**

- AndroidX
```
    implementation "com.glensun:livedataext:1.0.0"
```

- Android Support
```
    implementation "com.glensun:livedataext-nonx:1.0.0"
```

**添加Import**

```
    import com.glensun.livedataextension.*
```



## API说明

**Combining**

 - `merge`, `LiveData.merge`  多个相同类型的liveData合并，产生一个新的liveData
```
    ---------[1]------------------------[5]-----------[4]------------->

    --------------------[7]------------------------------------------->

                                    merge

    ---------[1]--------[7]-------------[5]-----------[4]------------->
```

 - `startWith`  在LiveData发射数据之前，插入数据
 
```
    ---------[1]------------------------[5]-----------[4]------------->

                                  startWith(7)

    ---[7]---[1]------------------------[5]-----------[4]------------->
```

 - `combine`, `LiveData.combine`  多个不同类型的liveData合并，产生一个新的liveData
 
```
    -----------------[1]----------------[5]----[4]-------------------->

    --------[A]---------------[B]--------------------------[C]-------->

                                   combine

    -----[null,A]---[1,A]----[1,B]-----[5,B]---[4,B]------[4,C]------->
```

 - `combineNonNull`, `LiveData.combineNonNull`  多个不同类型的liveData合并，产生一个新的liveData，所有被观察的对象都要有数据才会触发
```
    ---------[1]------------------------[5]--------------------------->

    --------------------------[A]-------------------------------[B]--->

    -----------------[X]------------------------------[Y]------------->

                                 combineNonNull

    -------------------------[1,A,X]---[5,A,X]-------[5,A,Y]---[5,B,Y]->
```

 - `zip`, `LiveData.zip`, `LiveData<List>.zip`  多个相同类型的liveData合并，产生一个新的liveData<List>
```
    ---------[1]------------------------[5]----[4]-------------------->

    --------------------[7]------------------------------------------->

                                   combine

    -------------------[1,7]----------[5,7]----[4,7]------------------>
```

**Transforming**

 - `map` 响应livedata的变化，并发生转化

```
    ---------[1]------------------------[5]-----------[4]------------->

                                  map { it + 2 }

    ---------[3]------------------------[7]-----------[6]------------->
```

 - `switchMap` 响应livedata的变化，生成一个临时LiveData, 当临时liveData变化时，会触发结果liveData变化

```
    ---------[1]------------------------[5]-----------[4]------------->

                        switchMap { repository.fetch(it) }

    ------------------[3]------------------------[7]-----------[6]---->
```

 - `toMutable` 将LiveData转变为MutableLiveData
 - `isAllTrue` LiveData<List<Boolean>> 全为true
 - `isAnyTrue` LiveData<List<Boolean>> 任一为true
 - `log` 打log,不会影响触发值
 - `doBefore` 在LiveData触发之前触发
 - `doAfter` 在LiveData触发之后触发
 - `defaultIfNull` 当值为null的默认值
 - `trigger` 手动触发
 
**Filtering**

 - `filter` 只有当过滤条件满足时才会触发

```
    ---------[1]------------------------[5]-----------[4]------------->

                            filter { it > 3 }

    ------------------------------------[5]-----------[4]------------->
```

 - `filterNonNull` 

```
    ---------[1]------------[null]-------------------------[4]-------->

                                filterNull

    ---------[1]-------------------------------------------[4]-------->
```

 - `distinctUntilChanged`

```
    ---------[1]------------[1]--------[2]--------[1]-------[4]------->

                            distinctUntilChanged

    ---------[1]-----------------------[2]--------[1]-------[4]------->
```

 - `distinct` 

```
    ---------[1]------------[1]--------[2]--------[1]-------[4]------->

                                    distinct

    ---------[1]-----------------------[2]------------------[4]------->
```

