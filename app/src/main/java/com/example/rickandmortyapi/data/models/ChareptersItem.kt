package com.example.rickandmortyapi.data.models

import com.google.gson.annotations.SerializedName

data class ChareptersItem(
    @SerializedName("image")
    val image: String = "",
    @SerializedName("gender")
    val gender: String = "",
    @SerializedName("species")
    val species: String = "",
    @SerializedName("created")
    val created: String = "",
    @SerializedName("name")
    val name: String = "",
    @SerializedName("episode")
    val episode: List<String>?,
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("type")
    val type: String = "",
    @SerializedName("url")
    val url: String = "",
    @SerializedName("status")
    val status: String = ""
)