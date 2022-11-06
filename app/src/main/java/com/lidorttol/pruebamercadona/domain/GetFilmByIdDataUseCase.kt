package com.lidorttol.pruebamercadona.domain

import com.lidorttol.pruebamercadona.data.bo.FilmBo
import com.lidorttol.pruebamercadona.data.lifecycle.AsyncResult
import com.lidorttol.pruebamercadona.data.lifecycle.Event
import com.lidorttol.pruebamercadona.data.repository.Repository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

interface GetFilmByIdDataUseCase {
    suspend operator fun invoke(filmId: String): Flow<Event<AsyncResult<FilmBo>>>
}

class GetFilmByIdDataUseCaseImpl @Inject constructor(private val repository: Repository) : GetFilmByIdDataUseCase {

    override suspend fun invoke(filmId: String): Flow<Event<AsyncResult<FilmBo>>> {
        return flow {
            emit(AsyncResult.Loading(null))

            val getFilmResponse = repository.getFilmDetail(filmId).valueAsync().await()

            if (getFilmResponse is AsyncResult.Success) {
                if (getFilmResponse.data == null || getFilmResponse.data?.isValid() == true) {
                    emit(AsyncResult.Error("Error, no hay resultado.", null))

                } else {
                    emit(AsyncResult.Success(getFilmResponse.data))
                }

            } else {
                emit(AsyncResult.Error("Error al obtener la película", null))
            }
        }.map { Event(it) }
    }

}