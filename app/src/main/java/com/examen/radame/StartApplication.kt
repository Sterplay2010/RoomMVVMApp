package com.examen.radame

import android.app.Application
import androidx.room.Room
import com.examen.radame.room.DB

class StartApplication:Application() {
    companion object{
        lateinit var room:DB
    }

    override fun onCreate() {
        super.onCreate()
        room = Room.databaseBuilder(applicationContext,DB::class.java,"examen").build()
    }
}