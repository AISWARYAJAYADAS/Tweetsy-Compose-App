package com.example.tweetsy.api

import com.example.tweetsy.models.Tweet
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface TweetsyAPI {

    @GET("/v3/b/65fd4a10266cfc3fde9c1aa9?meta=false")
    suspend fun getTweets(@Header("X-JSON-Path") category: String): Response<List<Tweet>>

    @GET("/v3/b/65fd4a10266cfc3fde9c1aa9?meta=false")
    @Headers("X-JSON-Path:tweets..category")
    suspend fun getCategory(): Response<List<String>>
}