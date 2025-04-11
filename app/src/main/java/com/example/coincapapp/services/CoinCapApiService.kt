package com.example.coincapapp.services

import com.example.coincapapp.models.Asset
import com.example.coincapapp.models.AssetsResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import javax.inject.Inject

class CoinCapApiService @Inject constructor(
    private val client : HttpClient
){
    suspend fun getAssets(): AssetsResponse{
        val response: HttpResponse = client.get(urlString = "https://c8dc6bef-802f-4ebc-b955-7b693182aa53.mock.pstmn.io/v3/assets?apiKey=d5d5e048dd835a78d3cf1cb408fb715468d60ab8c7bd4e99b6bfd2ab816015f5")
        return  response.body()
    }
}