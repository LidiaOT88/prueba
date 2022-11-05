package com.lidorttol.pruebamercadona.data.remote.api

import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
    private val apiService: ApiService
) : RemoteDataSource {

}