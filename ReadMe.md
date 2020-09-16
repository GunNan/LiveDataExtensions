LiveDataExtensions - Android LiveData Extensions for Kotlin, use like RxJava operators
--------------------------------------------------------------------------------------
[![Build Status](https://travis-ci.com/GunNan/LiveDataExtensions.svg?branch=master)](https://travis-ci.com/github/GunNan/LiveDataExtensions) [![Latest Version](https://img.shields.io/github/v/release/GunNan/LiveDataExtensions?include_prereleases)](https://github.com/GunNan/LiveDataExtensions)

LiveDataExtensions提供一些类似于RxJava操作符的kotlin扩展方法

## API说明

**Combining**

 - `merge`  多个相同类型的liveData合并，产生一个新的liveData
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

 - `combine`  多个不同类型的liveData合并，产生一个新的liveData
```

    ---------[1]------------------------[5]----[4]-------------------->

    --------------------------[A]--------------------------[B]-------->

                                   combine

    -------[1,null]----------[1,A]-----[5,A]----[4,A]------[4,B]------>
```

 - `combineNonNull`  多个不同类型的liveData合并，产生一个新的liveData，所有被观察的对象都要有数据才会触发
```

    ---------[1]------------------------[5]--------------------------->

    --------------------------[A]-------------------------------[B]--->

    -----------------[X]------------------------------[Y]------------->

                                   combine

    -------------------------[1,A,X]---[5,A,X]-------[5,A,Y]---[5,B,Y]->
```

