package com.example.nexusreality.repository

import com.example.nexusreality.api.RetrofitClient
import com.example.nexusreality.models.ImageModelItem
import retrofit2.Call

class MediaCoverageRepository {

    fun getMediaCoverages(page: Int): Call<List<ImageModelItem>> {
        return RetrofitClient.instance.getMediaCoverages()
    }
}
