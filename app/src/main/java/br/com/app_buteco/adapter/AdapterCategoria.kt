package br.com.app_buteco.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.selection.SelectionTracker
import androidx.recyclerview.widget.RecyclerView
import br.com.app_buteco.R
import br.com.app_buteco.adapter.tracker.CategoriaDetails
import br.com.app_buteco.domain.Categoria

class AdapterCategoria(

    private val context: Context,
    private val categorias: MutableList<Categoria>,
    val onclick: (idProduto: Int) -> Unit

): RecyclerView.Adapter<AdapterCategoria.CategoriaViewHolder>(){

    lateinit var selectionTracker: SelectionTracker<Long>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriaViewHolder {

        val itemLista = LayoutInflater.from(context)
            .inflate(R.layout.fragment_cardapio_simple_item_categoria, parent, false)

        return CategoriaViewHolder(itemLista)

    }

    override fun onBindViewHolder(holder: CategoriaViewHolder, position: Int) {

        holder.setCategoia(categorias[position], position)

    }

    override fun getItemCount() = categorias.size

    inner class CategoriaViewHolder(

        itemView: View

    ) : RecyclerView.ViewHolder(itemView) {

        var categoriaDetails = CategoriaDetails()
        private var btnCategoria = itemView.findViewById<TextView>(R.id.tv_categoria)

        fun setCategoia(categoria: Categoria, position: Int) {

            btnCategoria.text = categoria.nomeCategoria

            categoriaDetails.categoria = categoria
            categoriaDetails.adapterPosition = position

            if (selectionTracker.isSelected(categoriaDetails.selectionKey)) {

                btnCategoria.setBackgroundColor(ContextCompat.getColor(itemView.context,
                    R.color.chocolate))
                btnCategoria.setTextColor(ContextCompat.getColor(itemView.context, R.color.white))
                itemView.isActivated = true

                onclick.invoke(categoriaDetails.categoria!!.idCategoria)

            } else {

                btnCategoria.setBackgroundResource(R.drawable.border_tv_categoria_cardapio_simple_item)

                btnCategoria.setTextColor(ContextCompat.getColor(itemView.context,
                    R.color.chocolate))

                itemView.isActivated = false

                if (selectionTracker.selection.size() == 0) {

                    setCategoriaTodas()
                    onclick.invoke(-1)
                }
            }
        }
    }

    fun setCategoriaTodas(){

        val idTodas = -1

        selectionTracker.select(idTodas.toLong())

    }

}