package com.example.a2021drm2atividade1

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Produto::class],version = 1)

abstract class ProdutoDataBase : RoomDatabase() {

    abstract fun ProdutoDao(): ProdutoDAO

    companion object{

        private var database: ProdutoDataBase? = null

        private val DATABASE = "ProdutoDB"

        fun getInstance(context: Context): ProdutoDataBase? {
            if (database == null)
                return criaBanco(context)
            else
                return database
        }

        private fun criaBanco(context: Context): ProdutoDataBase {
            return Room.databaseBuilder(context, ProdutoDataBase::class.java, DATABASE)
                .allowMainThreadQueries()
                .build()
        }
    }
}