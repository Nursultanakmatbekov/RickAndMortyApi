package com.example.rickandmortyapi.ui.fragments.rickandmortyfragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rickandmortyapi.App
import com.example.rickandmortyapi.data.models.ChareptersItem
import com.example.rickandmortyapi.data.repositories.RickAndMortyRepository

class RickAndMortyViewModel: ViewModel (){

    private val repository = RickAndMortyRepository(App.retrofitClient.rickAndMortyApiService)

    private val _charactersLiveData = MutableLiveData<List<ChareptersItem>>()
    val charactersLiveData: LiveData<List<ChareptersItem>> = _charactersLiveData

    private val _errorLiveData = MutableLiveData<String>()
    val errorLiveData: LiveData<String> = _errorLiveData

    init {
        getChatacters()
    }

    private fun getChatacters() {
        repository.getCharacters(
            onSuccess = {
                _charactersLiveData.value = it
            },
            onFailure = {
                _errorLiveData.value = it
            }
        )
    }
}