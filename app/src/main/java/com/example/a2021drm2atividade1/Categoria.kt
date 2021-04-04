package com.example.a2021drm2atividade1

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Categoria(val nome: String,
                     @PrimaryKey(autoGenerate = true)
                     val codigo: Int = 0) {

}