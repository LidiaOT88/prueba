package com.lidorttol.pruebamercadona.data.lifecycle

import kotlinx.coroutines.CoroutineDispatcher

class AppDispatchers(
    val main: CoroutineDispatcher,
    val default: CoroutineDispatcher,
    val io: CoroutineDispatcher
)
