package com.example.efinal.data.network

import com.example.efinal.model.Digimon
import retrofit2.Response
import retrofit2.http.GET

interface WebService {
    @GET("digimon")
    suspend fun obtenerDigimons():Response<List<Digimon>>
}