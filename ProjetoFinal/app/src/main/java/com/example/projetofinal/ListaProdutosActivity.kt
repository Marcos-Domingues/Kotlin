package com.example.projetofinal

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.projetofinal.MainActivity.Companion.EXTRA_REPLY
import com.example.projetofinal.db.Produto
import kotlinx.android.synthetic.main.activity_lista_produtos.*
import java.lang.Exception
import androidx.lifecycle.Observer

class ListaProdutosActivity : AppCompatActivity () {

    val REQUEST_CODE = 12

    private lateinit var produtoViewModel: ProdutoViewModel

    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_produtos)

        recyclerView = recycler_produtos

        montaLista(recyclerView)

        btnAdd.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivityForResult(intent, REQUEST_CODE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == REQUEST_CODE &&
            resultCode == Activity.RESULT_OK){
            data?.let { resultado ->
                try{

                    val produto: Produto = resultado.extras?.
                        get(EXTRA_REPLY) as Produto

                    produto.let {
                        produtoViewModel.insert(produto)
                    }
                } catch (e: Exception){
                    Log.d("TAG: ", e.message)
                }
            }
        }

    }

    private fun montaLista(recyclerView: RecyclerView){

        val adapter = ListaProdutoAdapter(this)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)


        produtoViewModel = ViewModelProviders.of(this).
            get(ProdutoViewModel::class.java)


        produtoViewModel.produtos.observe(this,
            Observer { produtoLista ->
                produtoLista?.let { lista ->
                    adapter.setProdutoLista(lista)
                }
            })
    }

    override fun onRestart() {
        super.onRestart()

        montaLista(recyclerView)

    }
}
