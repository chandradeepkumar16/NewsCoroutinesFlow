package com.chandradeepdev.androidcoroutinesflow.model

import com.chandradeepdev.androidcoroutinesretrofit.model.NewsArticle
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NewsRepo {
    companion object{
        private const val Base_Url="https://raw.githubusercontent.com/DevTides/NewsApi/master/"
        private const val News_Delay=3000L
    }
    private val newsService=Retrofit.Builder()
        .baseUrl(Base_Url)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(NewsService::class.java)

    fun getnewsArticles():Flow<NewsArticle>{
        return flow {
            var newsSource=newsService.getNews()
            newsSource.forEach {
                emit(it)
                delay(News_Delay)
            }
        }
    }
}