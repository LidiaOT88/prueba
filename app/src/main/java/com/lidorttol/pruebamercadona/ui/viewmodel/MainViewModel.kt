package com.lidorttol.pruebamercadona.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.lidorttol.pruebamercadona.data.bo.FilmBo
import com.lidorttol.pruebamercadona.data.lifecycle.AsyncResult
import com.lidorttol.pruebamercadona.data.lifecycle.Event
import com.lidorttol.pruebamercadona.data.lifecycle.MutableSourceLiveData
import com.lidorttol.pruebamercadona.domain.GetFilmByIdDataUseCase
import com.lidorttol.pruebamercadona.domain.GetFilmsDataUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getFilmsDataUseCase: GetFilmsDataUseCase,
    private val getFilmByIdDataUseCase: GetFilmByIdDataUseCase,
    application: Application
) : AndroidViewModel(application) {

    private val getFilmsDataLiveData = MutableSourceLiveData<Event<AsyncResult<List<FilmBo>>>>()

    fun requestGetFilmsData(resetDatabase: Boolean = false) = viewModelScope.launch {
        viewModelScope.launch(Dispatchers.IO) {
            getFilmsDataLiveData.changeSource(
                getFilmsDataUseCase(resetDatabase).asLiveData(coroutineContext)
            )
        }
    }

    fun getFilmsData() = getFilmsDataLiveData.liveData()

    private val getFilmByIdDataLiveData = MutableSourceLiveData<Event<AsyncResult<FilmBo>>>()

    fun requestGetFilmByIdData(filmId: String) = viewModelScope.launch {
        viewModelScope.launch(Dispatchers.IO) {
            getFilmByIdDataLiveData.changeSource(
                getFilmByIdDataUseCase(filmId).asLiveData(coroutineContext)
            )
        }
    }

    fun getFilmByIdData() = getFilmByIdDataLiveData.liveData()

}