package com.examen.radame.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface CarDAO {
    @Insert
    suspend fun insert(carEntity: CarEntity):Long
    @Query("SELECT * FROM carro")
    suspend fun getAllData():List<CarEntity>
    @Update
    suspend fun update(carEntity: CarEntity)
    @Delete
    suspend fun delete(carEntity: CarEntity)
    @Query("SELECT * FROM carro WHERE id = :id")
    suspend fun getById(id:Int):CarEntity
}