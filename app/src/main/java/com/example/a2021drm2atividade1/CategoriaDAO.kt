package com.example.a2021drm2atividade1

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface CategoriaDAO {

    @Insert
    fun salvar(c: Categoria)


    @Query("SELECT * FROM categoria")
    fun listarComProduto(): List<ProdutoCategoria>

    @Query("SELECT * FROM categoria")
    fun listar(): List<Categoria>





}