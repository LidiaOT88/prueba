package com.lidorttol.pruebamercadona.data

fun String.getEntityId() = this.split("/").last()