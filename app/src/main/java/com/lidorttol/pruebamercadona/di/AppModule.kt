package com.lidorttol.pruebamercadona.di

import android.content.Context
import androidx.room.Room
import com.facebook.stetho.okhttp3.StethoInterceptor
import com.lidorttol.pruebamercadona.BuildConfig
import com.lidorttol.pruebamercadona.data.DATABASE_NAME
import com.lidorttol.pruebamercadona.data.local.LocalDatasource
import com.lidorttol.pruebamercadona.data.local.LocalDatasourceImpl
import com.lidorttol.pruebamercadona.data.local.dao.*
import com.lidorttol.pruebamercadona.data.local.database.AppDatabase
import com.lidorttol.pruebamercadona.data.remote.api.ApiService
import com.lidorttol.pruebamercadona.data.remote.api.RemoteDataSource
import com.lidorttol.pruebamercadona.data.remote.api.RemoteDataSourceImpl
import com.lidorttol.pruebamercadona.data.repository.Repository
import com.lidorttol.pruebamercadona.data.repository.RepositoryImpl
import com.lidorttol.pruebamercadona.domain.GetFilmByIdDataUseCase
import com.lidorttol.pruebamercadona.domain.GetFilmByIdDataUseCaseImpl
import com.lidorttol.pruebamercadona.domain.GetFilmsDataUseCase
import com.lidorttol.pruebamercadona.domain.GetFilmsDataUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    lateinit var database: AppDatabase

    @Provides
    fun provideBaseUrl() = "https://ghibliapi.herokuapp.com/"

    @Singleton
    @Provides
    fun provideOkHttpClient() = if (BuildConfig.DEBUG) {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .addNetworkInterceptor(StethoInterceptor())
            .build()
    } else {
        OkHttpClient
            .Builder()
            .build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient, BASE_URL: String): Retrofit =
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .build()

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)

    @Provides
    @Singleton
    fun provideApiHelper(remoteDataSource: RemoteDataSourceImpl): RemoteDataSource =
        remoteDataSource

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext: Context): AppDatabase {
        database = Room.databaseBuilder(
            appContext,
            AppDatabase::class.java,
            DATABASE_NAME
        ).build()
        return database
    }

    @Provides
    @Singleton
    fun provideFilmDao(database: AppDatabase): FilmDao {
        return database.filmDao()
    }

    @Provides
    @Singleton
    fun provideLocationDao(database: AppDatabase): LocationDao {
        return database.locationDao()
    }

    @Provides
    @Singleton
    fun providePersonDao(database: AppDatabase): PersonDao {
        return database.personDao()
    }

    @Provides
    @Singleton
    fun provideSpecieDao(database: AppDatabase): SpecieDao {
        return database.specieDao()
    }

    @Provides
    @Singleton
    fun provideVehicleDao(database: AppDatabase): VehicleDao {
        return database.vehicleDao()
    }

    @Provides
    @Singleton
    fun proviceLocalDatasource(
        filmDao: FilmDao,
        locationDao: LocationDao,
        personDao: PersonDao,
        specieDao: SpecieDao,
        vehicleDao: VehicleDao,
    ): LocalDatasource =
        LocalDatasourceImpl(
            filmDao,
            locationDao,
            personDao,
            specieDao,
            vehicleDao,
        )

    @Singleton
    @Provides
    fun provideRepository(
        localDataSource: LocalDatasource,
        remoteDataSource: RemoteDataSource,
    ) =
        RepositoryImpl(localDataSource, remoteDataSource) as Repository

    @Singleton
    @Provides
    fun provideGetFilmByIdDataUseCase(repository: Repository) = GetFilmByIdDataUseCaseImpl(repository) as GetFilmByIdDataUseCase

    @Singleton
    @Provides
    fun provideGetFilmsDataUseCase(repository: Repository) = GetFilmsDataUseCaseImpl(repository) as GetFilmsDataUseCase

}