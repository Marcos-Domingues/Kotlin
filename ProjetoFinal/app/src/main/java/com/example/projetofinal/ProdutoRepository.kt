package com.example.projetofinal

import androidx.lifecycle.LiveData
import com.example.projetofinal.db.Produto
import com.example.projetofinal.db.ProdutoDAO

class ProdutoRepository(private val produtoDAO: ProdutoDAO){

    fun insert(produto: Produto){
        produtoDAO.insert(produto)
    }

    fun update(produto: Produto){
        produtoDAO.update(produto)
    }

    fun delete(produto: Produto) =
        produtoDAO.delete(produto)

    val produtos: LiveData<List<Produto>> = produtoDAO.getAll()
}
