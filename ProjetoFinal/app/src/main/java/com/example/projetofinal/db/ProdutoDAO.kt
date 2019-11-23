package com.example.projetofinal.db

import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface ProdutoDAO {

    @Insert
    fun insert(produto: Produto)

    @Update
    fun update(produto: Produto)

    @Delete
    fun delete(produto: Produto)

    @Query("SELECT * FROM produto_tb ORDER BY nome_cl ASC")
    fun getAll(): LiveData<List<Produto>>

    @Query("SELECT * FROM produto_tb WHERE id = :id_")
    fun getByID(id_: Int): LiveData<Produto>

    @Query("DELETE FROM produto_tb")
    fun deleteAll()

}
