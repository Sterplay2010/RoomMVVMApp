package com.examen.radame.provider

import com.examen.radame.StartApplication.Companion.room
import com.examen.radame.room.CarEntity

class RegisterProvider {
    companion object{
        suspend fun registerData(model:String,subModel:String,year:String):Long{
            return room.getCarDAO().insert(CarEntity(null,model,subModel, year))
        }
    }
}