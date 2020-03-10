package br.com.cryptonews.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.com.cryptonews.entities.News
import br.com.cryptonews.repository.IRepository
import kotlinx.coroutines.*

class NewsViewModel(val repository: IRepository, application: Application) :
    AndroidViewModel(application) {

    val viewModelJob = Job()
    val uiScope by lazy {
        CoroutineScope(Dispatchers.Main + viewModelJob)
    }

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

    fun getRemoteListCryptoNews(
        qInTitle: String, dateFrom: String, dateTo: String, apiKey: String
    ) {
        uiScope.launch {
            withContext(Dispatchers.IO) {
                try {
                    _news.postValue(
                        repository.getRemoteListCryptoNews(
                            qInTitle,
                            dateFrom,
                            dateTo,
                            apiKey
                        )
                    )
                } catch (ex: Exception) {
                    _toast.postValue("Falha ao buscar os dados: ${ex.message}")
                }
            }
        }
    }
}