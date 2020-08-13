package com.venkat.mastermindgame
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel()
{
    val resultData = MutableLiveData<MutableMap<Int,Color>>()

    fun performOperation(secret: String,input : String)
    {
        resultData.value = evaluateSecret(secret,input)
    }
}