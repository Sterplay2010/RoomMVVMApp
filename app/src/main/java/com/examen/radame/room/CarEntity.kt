package com.examen.radame.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "carro")
data class CarEntity(
    @PrimaryKey(autoGenerate = true)
    var id:Int?,
    var model:String?,
    var subModel:String?,
    var year:String?
)