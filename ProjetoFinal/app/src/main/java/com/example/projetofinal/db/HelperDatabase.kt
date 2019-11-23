package com.example.projetofinal.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
//exportSchema = false
@Database(entities = [Produto::class], version = 1, exportSchema = false )
abstract class HelperDatabase: RoomDatabase(){

    abstract fun produtoDao(): ProdutoDAO

    companion object{
        private var INSTANCE: HelperDatabase? = null

        fun getDatabase(context: Context): HelperDatabase {
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    HelperDatabase::class.java,
                    "produto_db"
                )   .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}