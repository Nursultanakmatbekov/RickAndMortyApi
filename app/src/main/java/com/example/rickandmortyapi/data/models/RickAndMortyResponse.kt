package com.example.rickandmortyapi.data.models

import com.google.gson.annotations.SerializedName

data class RickAndMortyResponse(@SerializedName("results")
                                val results: List<ChereptersItem>?,
                                @SerializedName("info")
                                val info: Info)