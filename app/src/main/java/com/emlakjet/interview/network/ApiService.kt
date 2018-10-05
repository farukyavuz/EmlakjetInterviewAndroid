package com.emlakjet.interview.network

import com.emlakjet.interview.common.TEST_URL
import com.emlakjet.interview.model.response.NoticesResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


/**
 * Created by farukyavuz on 5.10.2018.
 * Copyright (c) 2018 Hürriyet to present
 * All rights reserved.
 */
interface ApiService {
    @GET(TEST_URL)
    fun getNotices(): Call<NoticesResponse>


    companion object {
            fun factory(): ApiService {
                val retrofit = Retrofit.Builder()
                        .addConverterFactory(GsonConverterFactory.create())
                        .baseUrl("https://api.emlakjet.com")
                        .build()

                return retrofit.create<ApiService>(ApiService::class.java)
            }

    }

}