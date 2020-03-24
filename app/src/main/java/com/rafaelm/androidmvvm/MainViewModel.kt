package com.rafaelm.androidmvvm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private val user = MutableLiveData<List<User>>()
    private lateinit var navigator : MainNavigator

    fun setNavigator(navigator: MainNavigator){
        this.navigator = navigator
    }

    fun getUser(): MutableLiveData<List<User>> {
        setUser()
        return user
    }

    private fun setUser() {

        val users: MutableList<User> = ArrayList()
        users.add(User("oi", "12122"))
        users.add(User("i", "121244"))
        users.add(User("3ewe", "125662"))
        users.add(User("tetetrdf", "1234642"))
        users.add(User("oretei", "1243536a2"))
        users.add(User("oretei", "1243536a2"))
        users.add(User("oretei", "1243536a2"))
        users.add(User("oretei", "1243536a2"))
        users.add(User("oretei", "1243536a2"))
        users.add(User("oretei", "1243536a2"))
        users.add(User("oretei", "1243536a2"))
        users.add(User("oretei", "1243536a2"))
        users.add(User("oretei", "1243536a2"))
        users.add(User("oretei", "1243536a2"))

        this.user.value = users
    }

    fun itemClick(user: User) {
        navigator.onItemClick(user)
    }

//      atualiza a tela sem precisar reiniciar
//    fun updateUser(){
//        val user = User()
//        user.name = "Update"
//        user.email = "Update"
//
//        this.user.value = user
//    }
}