package com.lidorttol.pruebamercadona.data.mapper

import com.lidorttol.pruebamercadona.data.bo.*
import com.lidorttol.pruebamercadona.data.getEntityId
import com.lidorttol.pruebamercadona.data.local.dbo.film.FilmDbo
import com.lidorttol.pruebamercadona.data.local.dbo.location.LocationDbo
import com.lidorttol.pruebamercadona.data.local.dbo.person.PersonDbo
import com.lidorttol.pruebamercadona.data.local.dbo.specie.SpecieDbo
import com.lidorttol.pruebamercadona.data.local.dbo.vehicle.VehicleDbo
import com.lidorttol.pruebamercadona.data.remote.dto.FilmDto

fun FilmBo.boToDbo() = FilmDbo(
    id,
    title,
    originalTitle,
    originalTitleRomanised,
    image,
    movieBanner,
    description,
    director,
    producer,
    releaseDate,
    runningTime,
    rtScore,
)

fun FilmDto.dtoToBo() = FilmBo(
    id,
    title,
    originalTitle,
    originalTitleRomanised,
    image,
    movieBanner,
    description,
    director,
    producer,
    releaseDate,
    runningTime,
    rtScore,
    people.map { PersonBo(it.getEntityId()) },
    species.map { SpecieBo(it.getEntityId()) },
    locations.map { LocationBo(it.getEntityId()) },
    vehicles.map { VehicleBo(it.getEntityId()) },
)

fun FilmDbo.dboToBo() = FilmBo(
    filmId,
    title,
    originalTitle,
    originalTitleRomanised,
    image,
    movieBanner,
    description,
    director,
    producer,
    releaseDate,
    runningTime,
    rtScore
)

fun buildFilmBo(
    film: FilmDbo,
    locations: List<LocationDbo>,
    people: List<PersonDbo>,
    species: List<SpecieDbo>,
    vehicles: List<VehicleDbo>,
): FilmBo = FilmBo(
    film.filmId,
    film.title,
    film.originalTitle,
    film.originalTitleRomanised,
    film.image,
    film.movieBanner,
    film.description,
    film.director,
    film.producer,
    film.releaseDate,
    film.runningTime,
    film.rtScore,
)