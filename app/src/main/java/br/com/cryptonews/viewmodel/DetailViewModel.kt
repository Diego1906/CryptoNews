package br.com.cryptonews.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.cryptonews.domain.ArticleModel

class DetailViewModel(article: ArticleModel) : ViewModel() {

    private val _article = MutableLiveData<ArticleModel>()
    val article: LiveData<ArticleModel>
        get() = _article

    init {
        _article.value = article
    }
}