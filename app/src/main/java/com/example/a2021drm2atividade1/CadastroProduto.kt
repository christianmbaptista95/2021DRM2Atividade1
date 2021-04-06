package com.example.a2021drm2atividade1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_cadastro_produto.*

class CadastroProduto : AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_produto)


        val categorias = CategoriaProdutoDB.getInstance(this)!!.CategoriaDao().listar()

        val adp = ArrayAdapter(this,android.R.layout.simple_spinner_item,categorias)

        spnCategoria.adapter = adp

        btnSalvarProduto.setOnClickListener {

            val produtoDAO = CategoriaProdutoDB.getInstance(this)?.ProdutoDao()

            val nome: String = edtNomeProduto.text.toString()

            val  descricao: String = edtDescricao.text.toString()

            val preco: Float = edtPreco.text.toString().toFloat()



           val codigoCategoria = spnCategoria.selectedItem.toString().toInt()

            val p = Produto(nome,descricao,preco,codigoCategoria)

            CategoriaProdutoDB.getInstance(this)!!.ProdutoDao().salvar(p)

        }



    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_produto,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.cadastrarCategoria){
            val i = Intent(this,MainActivity::class.java)
            startActivity(i)
        }
        if(item.itemId == R.id.listarProduto){
            val i = Intent(this,ListagemProdutos::class.java)
            startActivity(i)
        }
        if(item.itemId == R.id.listarHistorico) {
            val i = Intent(this, ListagemHistorico::class.java)
            startActivity(i)
        }
        return super.onOptionsItemSelected(item)
    }


}