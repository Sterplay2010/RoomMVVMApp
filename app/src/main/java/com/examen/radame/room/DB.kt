package com.examen.radame.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [CarEntity::class],
    version = 1
)
abstract class DB:RoomDatabase() {
    abstract fun getCarDAO():CarDAO
}