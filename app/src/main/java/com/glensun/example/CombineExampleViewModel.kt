package com.glensun.example

import android.util.Log
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.glensun.livedataextension.combineWith
import com.glensun.livedataextension.log
import com.glensun.livedataextension.map
import com.glensun.livedataextension.merge

private const val TAG = "CombineExampleViewModel"

class CombineExampleViewModel : ViewModel(), LifecycleObserver {
    // repository
    private val repository = CombineExampleRepository()

    // show data
    val singerSong: LiveData<String> = repository.localSinger
        .combineWith(
            repository.localSong,
            repository.remoteSinger,
            repository.remoteSong
        ) { localSinger, localSong, remoteSinger, remoteSong ->
            if (remoteSinger != null && remoteSong != null) {
                remoteSinger.singer + ": " + remoteSong.song
            } else {
                localSinger?.singer + ": " + localSong?.song
            }
        }.log { Log.d(TAG, "singerSong $it") }


//    val mergeString: LiveData<String> =
//        merge(
//            repository.remoteSinger.map { it?.singer },
//            repository.localSong.map { it?.song })
//            .map {
//                "${it?.joinToString()}"
//            }

    fun onFetchLocalClick() {
        repository.fetchLocalData()
    }

    fun onFetchRemoteSingerClick() {
        repository.fetchRemoteSingerData()
    }

    fun onFetchRemoteSongClick() {
        repository.fetchRemoteSongData()
    }
}