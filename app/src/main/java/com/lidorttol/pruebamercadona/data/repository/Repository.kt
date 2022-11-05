package com.lidorttol.pruebamercadona.data.repository

import com.lidorttol.pruebamercadona.data.remote.api.RemoteDataSource
import javax.inject.Inject

class Repository @Inject constructor(
    private val remoteDataSource: RemoteDataSource
) {

}