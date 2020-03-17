package br.com.cryptonews.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.com.cryptonews.entities.Article

class DetailViewModel(article: Article, application: Application) : AndroidViewModel(application) {

    private val _article = MutableLiveData<Article>()
    val article: LiveData<Article>
        get() = _article

    init {
        _article.value = article
    }
}