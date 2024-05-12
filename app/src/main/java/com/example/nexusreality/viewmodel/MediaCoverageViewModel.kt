package com.example.nexusreality.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.nexusreality.api.RetrofitClient
import com.example.nexusreality.models.ImageModelItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MediaCoverageViewModel : ViewModel() {

    private val _mediaCoverages = MutableLiveData<List<ImageModelItem>>()
    val mediaCoverages: LiveData<List<ImageModelItem>> = _mediaCoverages

    init {
        fetchMediaCoverages()
    }

    fun fetchMediaCoverages() {
        RetrofitClient.instance.getMediaCoverages().enqueue(object : Callback<List<ImageModelItem>> {
            override fun onResponse(call: Call<List<ImageModelItem>>, response: Response<List<ImageModelItem>>) {
                if (response.isSuccessful) {
                    _mediaCoverages.value = response.body()
                } else {
                    Log.e("MediaCoverageViewModel", "Failed to fetch media coverages")
                }
            }

            override fun onFailure(call: Call<List<ImageModelItem>>, t: Throwable) {
                Log.e("MediaCoverageViewModel", "Failed to fetch media coverages", t)
            }
        })
    }
}
