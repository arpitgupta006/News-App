package com.arpit.newsapp

import com.arpit.newsapp.responseheadline.TopHeadlineResponse
import retrofit2.Response
import retrofit2.http.GET

interface getService {

    @GET("top-headlines?country=in&apiKey=87549592e55f41b986f248237a219d90#")
    suspend fun getHeadline(): Response<TopHeadlineResponse>
}