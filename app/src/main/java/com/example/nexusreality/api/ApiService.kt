package com.example.nexusreality.api

import com.example.nexusreality.models.ImageModelItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("media-coverages?limit=100")
    fun getMediaCoverages(): Call<List<ImageModelItem>>
}
