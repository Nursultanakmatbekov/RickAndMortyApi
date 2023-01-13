package com.example.rickandmortyapi

import android.app.Application
import com.example.rickandmortyapi.data.remote.RetrofitClient
import com.example.rickandmortyapi.data.remote.api.RickAndMortyService

class App : Application() {

    companion object {
        val retrofitClient = RetrofitClient()
    }

    override fun onCreate() {
        super.onCreate()
    }
}