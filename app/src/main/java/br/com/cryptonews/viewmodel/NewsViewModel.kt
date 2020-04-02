package br.com.cryptonews.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import br.com.cryptonews.model.NewsObject
import br.com.cryptonews.repository.IRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class NewsViewModel(val repository: IRepository, application: Application) :
    AndroidViewModel(application) {

    private val _news = MutableLiveData<NewsObject>()
    val news: LiveData<NewsObject>
        get() = _news

    private val _toast = MutableLiveData<String>()
    val toast: LiveData<String>
        get() = _toast

    private val _progressBar = MutableLiveData<Boolean>()
    val progressBar: LiveData<Boolean>
        get() = _progressBar

    private fun onGetRemoteList(qInTitle: String, dateFrom: String, dateTo: String) {
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
                    onShowToast("Falha ao buscar os dados: ${ex.message}")
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

    fun onShowToast(value: String?) {
        _toast.postValue(value)
    }
}