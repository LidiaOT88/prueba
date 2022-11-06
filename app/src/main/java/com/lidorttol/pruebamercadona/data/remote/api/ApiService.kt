package com.lidorttol.pruebamercadona.data.remote.api

import com.lidorttol.pruebamercadona.data.remote.dto.*
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("films")
    suspend fun getFilms() : List<FilmDto>

    @GET("locations")
    suspend fun getLocations() : List<LocationDto>

    @GET("people")
    suspend fun getPerson() : List<PersonDto>

    @GET("species")
    suspend fun getSpecies() : List<SpecieDto>

    @GET("vehicles")
    suspend fun getVehicles() : List<VehicleDto>

    @GET("films/{id}")
    suspend fun getFilm(@Path("id") id: String) : FilmDto

    @GET("locations/{id}")
    suspend fun getLocation(@Path("id") id: String) : LocationDto

    @GET("people/{id}")
    suspend fun getPerson(@Path("id") id: String) : PersonDto

    @GET("species/{id}")
    suspend fun getSpecie(@Path("id") id: String) : SpecieDto

    @GET("vehicles/{id}")
    suspend fun getVehicle(@Path("id") id: String) : VehicleDto

}