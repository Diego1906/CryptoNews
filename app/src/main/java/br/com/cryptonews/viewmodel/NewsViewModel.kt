package br.com.cryptonews.viewmodel

import android.app.Application
import android.view.View
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import br.com.cryptonews.R
import br.com.cryptonews.domain.NewsModel
import br.com.cryptonews.repository.IRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class NewsViewModel(val repository: IRepository, application: Application) :
    AndroidViewModel(application) {

    private val _news = MutableLiveData<NewsModel>()
    val news: LiveData<NewsModel>
        get() = _news

    private val _toast = MutableLiveData<String>()
    val toast: LiveData<String>
        get() = _toast

    private val _progressBar = MutableLiveData(View.GONE)
    val progressBar: LiveData<Int>
        get() = _progressBar

    private val _imageNoInternetConnected = MutableLiveData(View.GONE)
    val imageNoInternetConnected: LiveData<Int>
        get() = _imageNoInternetConnected

    private val _swipeIsRefreshing = MutableLiveData<Boolean>()
    val swipeIsRefreshing: LiveData<Boolean>
        get() = _swipeIsRefreshing

    override fun onCleared() {
        super.onCleared()
        viewModelScope.cancel()
    }

    fun onShowData(title: String, dateFrom: String, dateTo: String) {
        viewModelScope.launch {
            onShowProgressBar(true)
            onCallRepository(title, dateFrom, dateTo)
            onShowProgressBar(false)
        }
    }

    private suspend fun onCallRepository(title: String, dateFrom: String, dateTo: String) {
        withContext(Dispatchers.IO) {
            try {
                _news.postValue(
                    repository.getListNews(title, dateFrom, dateTo)
                )
            } catch (ex: Throwable) {
                onShowToast(
                    getApplication<Application>().getString(
                        R.string.searching_data_fail, ex.message
                    )
                )
            }
        }
    }

    fun onShowToast(value: String?) {
        _toast.postValue(value)
    }

    private fun onShowProgressBar(value: Boolean) {
        _progressBar.postValue(onShow(value))
    }

    fun onShowImageNetwork(value: Boolean) {
        _imageNoInternetConnected.value = onShow(value)
    }

    private fun onShow(value: Boolean) = when (value) {
        true -> View.VISIBLE
        else -> View.GONE
    }

    fun onHideSwipeRefresh() {
        _swipeIsRefreshing.value = false
    }
}