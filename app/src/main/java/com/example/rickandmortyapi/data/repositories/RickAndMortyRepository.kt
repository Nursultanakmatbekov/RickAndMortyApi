package com.example.rickandmortyapi.data.repositories

import com.example.rickandmortyapi.data.models.ChereptersItem
import com.example.rickandmortyapi.data.models.RickAndMortyResponse
import com.example.rickandmortyapi.data.remote.api.RickAndMortyService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RickAndMortyRepository(private val rickAndMortyApiService: RickAndMortyService) {

    fun getCharacters(
        onSuccess: (CharacterList: List<ChereptersItem>) -> Unit,
        onFailure: (message: String) -> Unit,
    ) {
        rickAndMortyApiService.getCherepters().enqueue(object : Callback<RickAndMortyResponse> {
            override fun onResponse(
                call: Call<RickAndMortyResponse>,
                response: Response<RickAndMortyResponse>
            ) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        onSuccess(it.results!!)
                    }
                }
            }

            override fun onFailure(call: Call<RickAndMortyResponse>, t: Throwable) {
                t.localizedMessage?.let {
                    onFailure(it)
                }
            }
        })
    }
}