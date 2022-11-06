package com.lidorttol.pruebamercadona.data.repository

import com.lidorttol.pruebamercadona.data.bo.FilmBo
import com.lidorttol.pruebamercadona.data.local.LocalDatasource
import com.lidorttol.pruebamercadona.data.remote.api.RemoteDataSource
import com.lidorttol.pruebamercadona.data.response.CacheableRemoteResponse
import com.lidorttol.pruebamercadona.data.response.LocalResponse
import com.lidorttol.pruebamercadona.data.response.RepositoryResponse
import dagger.hilt.android.scopes.ActivityRetainedScoped
import javax.inject.Inject

@ActivityRetainedScoped
class RepositoryImpl @Inject constructor(
    private val localDatasource: LocalDatasource,
    private val remoteDataSource: RemoteDataSource,
) : Repository {

    override suspend fun getFilms(resetDatabase: Boolean): RepositoryResponse<List<FilmBo>> {
        return object : CacheableRemoteResponse<List<FilmBo>>() {
            override suspend fun loadFromLocal(): List<FilmBo> {
                if (resetDatabase) {
                    localDatasource.cleanDataBase()
                }
                return localDatasource.getFilms()
            }

            override fun shouldRequestFromRemote(localResponse: List<FilmBo>): Boolean {
                return localResponse.isNullOrEmpty()
            }

            override suspend fun requestRemoteCall(): List<FilmBo> {
                return remoteDataSource.getFilms()
            }

            override suspend fun saveRemoteResponse(remoteResponse: List<FilmBo>) {
                localDatasource.saveShortFilms(remoteResponse)
            }
        }.build()
    }

    override suspend fun getFilmDetail(filmId: String): RepositoryResponse<FilmBo> {
        return object : CacheableRemoteResponse<FilmBo>() {
            override suspend fun loadFromLocal(): FilmBo {
                return localDatasource.getFilmById(filmId)
            }

            override fun shouldRequestFromRemote(localResponse: FilmBo): Boolean {
                return localResponse.isValid()
            }

            override suspend fun requestRemoteCall(): FilmBo {
                return remoteDataSource.getFilmById(filmId)
            }

            override suspend fun saveRemoteResponse(remoteResponse: FilmBo) {
                localDatasource.saveShortFilm(remoteResponse)
            }
        }.build()
    }

    override suspend fun deleteFilm(filmId: String): RepositoryResponse<Unit> {
        return object : LocalResponse<Unit>() {
            override suspend fun loadFromLocal(): Unit {
                return localDatasource.deleteFilmById(filmId)
            }
        }.build()
    }

}