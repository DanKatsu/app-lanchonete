package br.com.app_buteco.adapter.tracker

import androidx.recyclerview.selection.ItemKeyProvider
import br.com.app_buteco.domain.Categoria

class CategoriaKeyProvider(val categoria: List<Categoria> ):
    ItemKeyProvider<Long>( ItemKeyProvider.SCOPE_MAPPED ) {

    override fun getKey(position: Int) = categoria[position].idCategoria.toLong()

    override fun getPosition(key: Long) = categoria.indexOf(

        categoria.filter { c -> c.idCategoria.toLong() == key }.single()

    )

}