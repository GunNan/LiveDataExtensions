package com.glensun.example

import androidx.lifecycle.MutableLiveData
import kotlin.concurrent.thread

class CombineExampleRepository {

    val localSinger = MutableLiveData<Singer>()

    val localSong = MutableLiveData<Song>()

    val remoteSinger = MutableLiveData<Singer>()

    val remoteSong = MutableLiveData<Song>()

    fun fetchLocalData() {
        thread {
            Thread.sleep(1000)
            localSinger.postValue(Singer("邓紫棋", "123"))
            localSong.postValue(Song("泡沫", 123))
        }
    }

    fun fetchRemoteSingerData() {
        thread {
            Thread.sleep(2000)
            remoteSinger.postValue(Singer("周杰伦", "456"))
        }
    }

    fun fetchRemoteSongData() {
        thread {
            Thread.sleep(2000)
            remoteSong.postValue(Song("七里香", 456))
        }
    }
}

data class Singer(val singer: String, val id: String)

data class Song(val song: String, val id: Int)