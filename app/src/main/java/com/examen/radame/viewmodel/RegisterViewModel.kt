package com.examen.radame.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.examen.radame.provider.RegisterProvider

class RegisterViewModel:ViewModel() {
    var result:MutableLiveData<String> = MutableLiveData()
    var error:MutableLiveData<String> = MutableLiveData()

    suspend fun registerData(model:String,subModel:String,year:String){
        try {
            result.postValue("Registro exitoso con el ID ${RegisterProvider.registerData(model, subModel, year)}")
        }catch (e:Exception){
            error.postValue("Ocurrio un error en la aplicación")
        }
    }
}