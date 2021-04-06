package com.example.a2021drm2atividade1

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Categoria::class, Produto::class], version = 1)
abstract class CategoriaProdutoDB: RoomDatabase() {

    abstract fun CategoriaDao(): CategoriaDAO
    abstract fun ProdutoDao(): ProdutoDAO


    companion object{

        private var database: CategoriaProdutoDB? = null

        private val DATABASE = "CategoriaProdutoDB"

        fun getInstance(context: Context): CategoriaProdutoDB? {

            if(database == null)
                return criaBanco(context)
            else
                return database

        }

        private fun criaBanco(context: Context): CategoriaProdutoDB {
            return Room.databaseBuilder(context, CategoriaProdutoDB::class.java, DATABASE)
                .allowMainThreadQueries()
                .build()
        }
    }
}