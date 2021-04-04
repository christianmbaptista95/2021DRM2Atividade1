package com.example.a2021drm2atividade1

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Categoria::class],version = 1)
abstract class CategoriaDataBase : RoomDatabase() {


    abstract fun categoriaDao(): CategoriaDAO

    companion object {

        private var database: CategoriaDataBase? = null

        private val DATABASE = "CategoriaDB"

        fun getInstance(context: Context): CategoriaDataBase? {
            if (database == null)
                return criaBanco(context)
            else
                return database
        }

        private fun criaBanco(context: Context): CategoriaDataBase {
            return Room.databaseBuilder(context, CategoriaDataBase::class.java, DATABASE)
                .allowMainThreadQueries()
                .build()
        }
    }
}