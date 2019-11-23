package com.example.projetofinal

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.projetofinal.db.Produto
import com.example.projetofinal.db.ProdutoDAO
import com.example.projetofinal.db.HelperDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class ProdutoViewModel(application: Application):
    AndroidViewModel(application){

    private val repository: ProdutoRepository

    val produtos: LiveData<List<Produto>>


    private val parentJob = Job()
    private val corountineContext: CoroutineContext
        get() = parentJob + Dispatchers.Main
    private val scope = CoroutineScope(corountineContext)

    init {
        val produtoDAO = HelperDatabase.getDatabase(application).produtoDao()
        repository = ProdutoRepository(produtoDAO)

        produtos = repository.produtos
    }

    fun insert(produto: Produto) = scope.launch(Dispatchers.IO){
        repository.insert(produto)
    }
    fun update(produto: Produto) = scope.launch(Dispatchers.IO){
        repository.update(produto)
    }

    fun delete(produto: Produto) = scope.launch(Dispatchers.IO){
        repository.delete(produto)
    }
}
