package br.com.app_buteco.adapter.tracker

import android.view.MotionEvent
import androidx.recyclerview.selection.ItemDetailsLookup
import androidx.recyclerview.widget.RecyclerView
import br.com.app_buteco.adapter.AdapterCategoria

class CategoriaLockup( val rvCategoria: RecyclerView ): ItemDetailsLookup<Long>() {

    override fun getItemDetails(e: MotionEvent): ItemDetails<Long>? {

        val view = rvCategoria.findChildViewUnder( e.x, e.y )

        if( view != null ){

            val holder = rvCategoria.getChildViewHolder( view )

            return (holder as AdapterCategoria.CategoriaViewHolder).categoriaDetails

        }

        return null

    }


}