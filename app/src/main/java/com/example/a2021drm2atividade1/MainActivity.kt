package com.example.a2021drm2atividade1

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSalvarCategoria.setOnClickListener {

            CategoriaProdutoDB.getInstance(this)!!.CategoriaDao().salvar(Categoria(edtNomeCategoria.text.toString()))


        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.cadastrarProduto){
            val i = Intent(this,CadastroProduto::class.java)
            startActivity(i)
        }
        if(item.itemId == R.id.listarCategoria){
            val i = Intent(this,ListagemCategorias::class.java)
            startActivity(i)
        }
        if(item.itemId == R.id.sair){
            finish();
            System.exit(0);
        }

        return super.onOptionsItemSelected(item)
    }




}