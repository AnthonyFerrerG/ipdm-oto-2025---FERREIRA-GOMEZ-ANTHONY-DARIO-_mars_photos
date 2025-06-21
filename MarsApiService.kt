package com.example.marsgallery.network

import com.example.marsgallery.model.MarsPhoto
import retrofit2.http.GET
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

interface MarsApiService {
    @GET("mars-photos/api/v1/rovers/curiosity/photos?sol=1000&api_key=DEMO_KEY")
    suspend fun getPhotos(): List<MarsPhoto>
}

object MarsApi {
    private const val BASE_URL = "https://api.nasa.gov/"

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()

    val retrofitService: MarsApiService by lazy {
        retrofit.create(MarsApiService::class.java)
    }
}
