package com.example.projetofinal.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "produto_tb")
class Produto(

    @ColumnInfo(name = "nome_cl")
    var nome: String = "",

    @ColumnInfo(name = "marca_cl")
    var marca: String = "",

    @ColumnInfo(name = "modelo_cl")
    var modelo: String = "",

    @ColumnInfo(name = "preco_cl")
    var preco: String = "",

    @ColumnInfo(name = "status_cl")
    var status: String = ""
    ): Serializable{
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}
