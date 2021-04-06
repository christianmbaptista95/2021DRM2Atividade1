package com.example.a2021drm2atividade1

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Produto (val nome: String,
                    val descricao: String,
                    val preco: Float,
                    @PrimaryKey(autoGenerate = true)
                    val codigoProduto: Int = 0) {

    override fun toString(): String {
        return "Produto (Nome: " + nome + "  Descrição: " + descricao + " Preço:  " + preco + " Código:  " + codigoProduto
    }
}