package com.lidorttol.pruebamercadona.data.repository

import com.lidorttol.pruebamercadona.data.bo.FilmBo
import com.lidorttol.pruebamercadona.data.response.RepositoryResponse

interface Repository {

    suspend fun getFilms(resetDatabase: Boolean): RepositoryResponse<List<FilmBo>>

    suspend fun deleteFilm(filmId: String): RepositoryResponse<Unit>

    suspend fun getFilmDetail(filmId: String): RepositoryResponse<FilmBo>

}