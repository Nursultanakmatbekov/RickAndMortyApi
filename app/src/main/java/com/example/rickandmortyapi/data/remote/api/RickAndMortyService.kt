package com.example.rickandmortyapi.data.remote.api

import com.example.rickandmortyapi.data.models.RickAndMortyResponse
import retrofit2.Call
import retrofit2.http.GET

interface RickAndMortyService {

    @GET("character")
    fun getCherepters(): Call <RickAndMortyResponse>
}