package com.example.livedataextension

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.*
import com.example.livedataextension.databinding.ActivityMainBinding
import kotlin.concurrent.thread

private const val TAG = "MainActivity"

/**
 * Activity
 */
class MainActivity : AppCompatActivity() {
    // ViewModel
    private lateinit var viewModel: MainViewModel

    // DataBinding
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // view model
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        // data binding
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this
        binding.viewmodel = viewModel
    }
}

/**
 * ViewModel
 */
class MainViewModel : ViewModel() {
    val repository = MainRepository()
    val fetchBtn: MutableLiveData<Boolean> = MutableLiveData()
    val songTitle: LiveData<String> =
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

    fun onBtnClick() {
        fetchBtn.postValue(true)
    }
}

/**
 * Repository
 */
class MainRepository {

    private val songData = MutableLiveData<SongData>()

    fun observeSongInfo() = songData

    fun fetchSongInfo() {
        fetchSongInfoRemote()
        fetchSongInfoLocal()
    }

    private fun fetchSongInfoRemote() {
        thread {
            Thread.sleep(2000)
            songData.postValue(SongData("七里香", "周杰伦"))
        }
    }

    fun fetchSongInfoLocal() {
        thread {
            Thread.sleep(500)
            songData.postValue(SongData("泡沫", "邓紫棋"))
        }
    }
}

/**
 * Data Bean
 */
data class SongData(val songName: String, val singer: String)