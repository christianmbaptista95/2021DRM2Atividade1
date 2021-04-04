package com.example.a2021drm2atividade1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_listagem_categorias.*
import kotlinx.android.synthetic.main.activity_listagem_categorias.btnAdd
import kotlinx.android.synthetic.main.activity_listagem_produtos.*

class ListagemProdutos : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listagem_produtos)


        btnAdd.setOnClickListener {
            startActivity(Intent(this, CadastroProduto::class.java))
        }
    }

    override fun onResume() {
        super.onResume()

        CarregarLista("")


    }


    private fun CarregarLista(ordem: String) {
        val ProdutoDAO = ProdutoDataBase.getInstance(this)?.ProdutoDao()
        val listaProdutos: List<Produto>

        listaProdutos= ProdutoDAO!!.listar()


        val adp =
            ArrayAdapter<Produto>(this, android.R.layout.simple_selectable_list_item, listaProdutos)

        lstProduto.adapter = adp
    }

}