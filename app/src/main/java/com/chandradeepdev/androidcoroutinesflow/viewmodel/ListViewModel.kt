package com.chandradeepdev.androidcoroutinesflow.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.chandradeepdev.androidcoroutinesflow.model.NewsRepo

class ListViewModel: ViewModel() {

    val newsArticles = NewsRepo().getnewsArticles().asLiveData()

}