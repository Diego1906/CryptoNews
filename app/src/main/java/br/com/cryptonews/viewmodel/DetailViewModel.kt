package br.com.cryptonews.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.com.cryptonews.model.ArticleObject

class DetailViewModel(article: ArticleObject, application: Application) :
    AndroidViewModel(application) {

    private val _article = MutableLiveData<ArticleObject>()
    val article: LiveData<ArticleObject>
        get() = _article

    init {
        _article.value = article
    }
}