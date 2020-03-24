package com.rafaelm.androidmvvm

import androidx.databinding.ObservableBoolean

class User (
    var name: String = "",
    var email: String = ""
){
    var isMark  = ObservableBoolean(false)
}