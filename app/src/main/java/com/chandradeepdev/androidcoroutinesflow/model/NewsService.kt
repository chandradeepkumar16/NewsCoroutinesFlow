package com.chandradeepdev.androidcoroutinesflow.model

import com.chandradeepdev.androidcoroutinesretrofit.model.NewsArticle
import retrofit2.http.GET

interface NewsService {

    @GET("news.json")
    suspend fun getNews():List<NewsArticle>
}