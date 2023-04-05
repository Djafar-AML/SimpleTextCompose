package com.example.simpletextcompose

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private val _userNameState = MutableLiveData("")
    val userNameState: LiveData<String> = _userNameState

    fun changeUserName(userInput: String) {
        _userNameState.value = userInput
    }

}