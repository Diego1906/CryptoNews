package br.com.cryptonews.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import br.com.cryptonews.entities.News
import br.com.cryptonews.repository.IRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class NewsViewModel(val repository: IRepository, application: Application) :
    AndroidViewModel(application) {

    private val _title = MutableLiveData<String>()
    val title: LiveData<String>
        get() = _title

    private val _urlToImage = MutableLiveData<String>()
    val urlToImage: LiveData<String>
        get() = _urlToImage

    private val _publishedAt = MutableLiveData<String>()
    val publishedAt: LiveData<String>
        get() = _publishedAt

    private val _news = MutableLiveData<News>()
    val news: LiveData<News>
        get() = _news

    private val _toast = MutableLiveData<String>()
    val toast: LiveData<String>
        get() = _toast

    private val _progressBar = MutableLiveData<Boolean>()
    val progressBar: LiveData<Boolean>
        get() = _progressBar

    fun onGetRemoteList(
        qInTitle: String, dateFrom: String, dateTo: String
    ) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                try {
                    _news.postValue(
                        repository.getRemoteListCryptoNews(
                            qInTitle,
                            dateFrom,
                            dateTo
                        )
                    )
                } catch (ex: Throwable) {
                    _toast.postValue("Falha ao buscar os dados: ${ex.message}")
                }
            }
            onShowProgressBar(false)
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelScope.cancel()
    }

    fun onUpdateFilter(qInTitle: String, dateFrom: String, dateTo: String) {
        onGetRemoteList(qInTitle, dateFrom, dateTo)
    }

    fun onShowProgressBar(value: Boolean) {
        _progressBar.postValue(value)
    }
}