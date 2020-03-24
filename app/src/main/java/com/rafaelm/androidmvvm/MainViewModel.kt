package com.rafaelm.androidmvvm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private val user : MutableLiveData<User> = MutableLiveData()

    fun getUser(): MutableLiveData<User> {
        setUser()
        return user
    }

    private fun setUser() {
        val user = User()
        user.name = "ooi"
        user.email = "teste"

        this.user.value = user
    }
}

