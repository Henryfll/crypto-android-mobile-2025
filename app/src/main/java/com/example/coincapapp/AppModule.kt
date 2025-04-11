package com.example.coincapapp

import com.example.coincapapp.services.CoinCapApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import javax.inject.Singleton
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

@Module
@InstallIn(SingletonComponent::class)
object AppModule{

    @Provides
    @Singleton
    fun ktorClient(): HttpClient{
        return HttpClient(CIO) {
            install(ContentNegotiation) {
                json(Json {
                    prettyPrint = true
                    isLenient = true
                    ignoreUnknownKeys = true
                })
            }
        }
    }

    @Provides
    @Singleton
    fun coinCapService(client: HttpClient): CoinCapApiService{
        return CoinCapApiService(client)
    }

}