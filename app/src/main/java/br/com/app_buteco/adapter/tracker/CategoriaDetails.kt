package br.com.app_buteco.adapter.tracker

import android.view.MotionEvent
import androidx.recyclerview.selection.ItemDetailsLookup
import br.com.app_buteco.domain.Categoria

class CategoriaDetails(

    var categoria: Categoria? = null,
    var adapterPosition: Int = -1

): ItemDetailsLookup.ItemDetails<Long>() {

    override fun getPosition() = adapterPosition

    override fun getSelectionKey() = categoria!!.idCategoria.toLong()

    override fun inSelectionHotspot(e: MotionEvent) = true


}