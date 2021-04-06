package com.example.a2021drm2atividade1

import androidx.room.Embedded
import androidx.room.Relation

data class ProdutoCategoria (@Embedded val categoria: Categoria,
                             @Relation(
                                 parentColumn = "codigoCategoria",
                                 entityColumn = "codigoProduto"
                             ) val produtos: List<Produto>) {
}