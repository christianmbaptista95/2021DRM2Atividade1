package com.example.a2021drm2atividade1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_listagem_categorias.*

class ListagemCategorias : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listagem_categorias)


        btnAdd.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }




    }

    override fun onResume() {
        super.onResume()

        CarregarLista("")


    }




    private fun CarregarLista(ordem: String) {
        val categoriaDAO = CategoriaProdutoDB.getInstance(this)?.CategoriaDao()
        val listaCategorias: List<Categoria>

        listaCategorias = categoriaDAO!!.listar()


     val adp =
         ArrayAdapter<Categoria>(this, android.R.layout.simple_selectable_list_item, listaCategorias)

        lstCategoria.adapter = adp
    }


}