package com.example.a2021drm2atividade1

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ProdutoDAO {

    @Insert
    fun salvar(p: Produto)

    @Query("SELECT * FROM produto")
    fun listarComCategoria(): List<ProdutoCategoria>

    @Query("SELECT * FROM produto")
    fun listar(): List<Produto>


}