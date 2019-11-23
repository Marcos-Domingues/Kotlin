package com.example.projetofinal

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.projetofinal.db.Produto
import kotlinx.android.synthetic.main.item_lista.view.*

class ListaProdutoAdapter
internal constructor(context: Context) :
    RecyclerView.Adapter<ListaProdutoAdapter.ViewHolder>() {

        private val inflater: LayoutInflater = LayoutInflater.from(context)

        private var itens = emptyList<Produto>()

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = inflater.inflate(
                R.layout.item_lista,
                parent,
                false
            )
            return ViewHolder(view)

        }

        override fun getItemCount(): Int = itens.count()

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val item = itens[position]
            holder.itemNome.text = item.nome
            holder.itemMarca.text = item.marca
            holder.itemModelo.text = item.modelo
            holder.itemPreco.text = item.preco
            holder.itemStatus.text = item.status

        }

        inner class ViewHolder(itemView: View) :
            RecyclerView.ViewHolder(itemView) {

            val itemNome: TextView = itemView.itemNome
            val itemMarca: TextView = itemView.itemMarca
            val itemModelo: TextView = itemView.itemModelo
            val itemPreco: TextView = itemView.itemPreco
            val itemStatus: TextView = itemView.itemStatus
        }

        fun setProdutoLista(produtos: List<Produto>) {
            this.itens = produtos
            notifyDataSetChanged()
        }
}
