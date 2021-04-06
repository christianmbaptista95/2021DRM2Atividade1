package com.example.a2021drm2atividade1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
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
        CarregarLista("")
        super.onResume()
    }


    private fun CarregarLista(ordem: String) {

        val produtos = CategoriaProdutoDB.getInstance(this)!!.ProdutoDao().listarComCategoria()
        val adp = ArrayAdapter(this,android.R.layout.simple_list_item_1,produtos)
        lstProduto.adapter = adp

    }

}