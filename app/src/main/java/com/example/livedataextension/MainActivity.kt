package com.example.livedataextension

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.*
import com.example.livedataextension.databinding.ActivityMainBinding
import kotlin.concurrent.thread

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
            .switchMap { repository.fetchSongInfo() }
            .filterNullMap()
            .combineWith(repository.fetchMVInfo()) { songData1, mvData -> Pair(songData1, mvData) }
            .map { "${it.first?.singer}: ${it?.first?.songName} : ${it?.second?.name}" }
            .delay(1000)

    fun onBtnClick() {
        fetchBtn.postValue(true)
    }
}

/**
 * Repository
 */
class MainRepository() {
    fun fetchSongInfo(): LiveData<SongData> {
        val result = MutableLiveData<SongData>()
        thread {
            Thread.sleep(1000)
            result.postValue(SongData("七里香", "周杰伦"))
        }
        return result
    }

    fun fetchMVInfo(): LiveData<MVData> {
        val result = MutableLiveData<MVData>()
        thread {
            Thread.sleep(1000)
            result.postValue(MVData("Mojito", "周杰伦"))
        }
        return result
    }
}

/**
 * Data Bean
 */
data class SongData(val songName: String, val singer: String)
data class MVData(val name: String, val singer: String)