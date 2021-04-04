package com.example.a2021drm2atividade1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_cadastro_produto.*
import kotlinx.android.synthetic.main.activity_listagem_categorias.*
import kotlinx.android.synthetic.main.activity_main.*
import java.util.ArrayList

class CadastroProduto : AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_produto)





        btnSalvarProduto.setOnClickListener {

            val produtoDAO = ProdutoDataBase.getInstance(this)?.ProdutoDao()

            val nome: String = edtNomeProduto.text.toString()

            val  descricao: String = edtDescricao.text.toString()

            val preco: Float = edtPreco.text.toString().toFloat()




            val p = Produto(nome,descricao,preco)

            produtoDAO?.salvar(p)

            Toast.makeText(this,"Produto Inserido!", Toast.LENGTH_SHORT).show()


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