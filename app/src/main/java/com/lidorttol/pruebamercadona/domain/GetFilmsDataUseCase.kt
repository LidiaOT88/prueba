package com.lidorttol.pruebamercadona.domain

import com.lidorttol.pruebamercadona.data.lifecycle.AsyncResult
import com.lidorttol.pruebamercadona.data.lifecycle.Event
import com.lidorttol.pruebamercadona.data.bo.FilmBo
import com.lidorttol.pruebamercadona.data.repository.Repository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

interface GetFilmsDataUseCase {
    suspend operator fun invoke(resetDatabase: Boolean): Flow<Event<AsyncResult<List<FilmBo>>>>
}

class GetFilmsDataUseCaseImpl @Inject constructor(private val repository: Repository) : GetFilmsDataUseCase {

    override suspend fun invoke(resetDatabase: Boolean): Flow<Event<AsyncResult<List<FilmBo>>>> {
        return flow {
            emit(AsyncResult.Loading(null))

            val getFilmsResponse = repository.getFilms(resetDatabase).valueAsync().await()

            if (getFilmsResponse is AsyncResult.Success) {
                if (getFilmsResponse.data == null) {
                    emit(AsyncResult.Error("Error, no hay resultados.", null))

                } else {
                    emit(AsyncResult.Success(getFilmsResponse.data))
                }

            } else {
                emit(AsyncResult.Error("Error al obtener las películas", null))
            }
        }.map { Event(it) }
    }

}