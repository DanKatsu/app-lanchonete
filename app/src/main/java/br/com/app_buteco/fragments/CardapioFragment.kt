package br.com.app_buteco.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.selection.SelectionTracker
import androidx.recyclerview.selection.StorageStrategy
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.app_buteco.adapter.AdapterCategoria
import br.com.app_buteco.adapter.AdapterProduto
import br.com.app_buteco.adapter.tracker.CategoriaKeyProvider
import br.com.app_buteco.adapter.tracker.CategoriaLockup
import br.com.app_buteco.adapter.tracker.CategoriaPredicate
import br.com.app_buteco.databinding.FragmentCardapioBinding
import br.com.app_buteco.domain.BaseCategorias
import br.com.app_buteco.domain.BaseProdutos

class CardapioFragment : Fragment() {

    private lateinit var binding: FragmentCardapioBinding
    private lateinit var selectionTracker: SelectionTracker<Long>

    private lateinit var rvProduto: RecyclerView
    private lateinit var rvCategoria: RecyclerView

    private lateinit var adapterProduto: AdapterProduto
    private lateinit var adapterCategoria: AdapterCategoria

    private lateinit var baseProdutos: BaseProdutos
    private lateinit var baseCategorias: BaseCategorias

    companion object {

        const val SELECTION_TACKER_KEY = "selection-tracker-categoria"

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentCardapioBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        baseProdutos = BaseProdutos()

        baseCategorias = BaseCategorias()

        rvProduto = binding.rvCardapio
        rvCategoria = binding.rvCategorias

        rvProduto.setHasFixedSize(true)
        rvCategoria.setHasFixedSize(true)

        rvProduto.layoutManager = GridLayoutManager(activity,
            2, GridLayoutManager.VERTICAL, false)

        rvCategoria.layoutManager = GridLayoutManager(activity, 1,
            GridLayoutManager.HORIZONTAL, false)

        adapterProduto = AdapterProduto(activity?.baseContext!!)
        adapterCategoria = AdapterCategoria(activity?.baseContext!!, baseCategorias.getAll()
        ) {

                id -> setarProdutoByCategoria(id)

        }

        rvProduto.adapter = adapterProduto
        rvCategoria.adapter = adapterCategoria

        configSelectionTracker(savedInstanceState)

        adapterProduto.setData(baseProdutos.getAll())

    }

    private fun configSelectionTracker(savedInstanceState: Bundle?) {

        selectionTracker = SelectionTracker.Builder(

            SELECTION_TACKER_KEY,
            rvCategoria,
            CategoriaKeyProvider(baseCategorias.getAll()),
            CategoriaLockup(rvCategoria),
            StorageStrategy.createLongStorage()

        ).withSelectionPredicate(CategoriaPredicate()).build()

        (rvCategoria.adapter as AdapterCategoria).selectionTracker = selectionTracker

        if (savedInstanceState != null) {

            selectionTracker.onRestoreInstanceState(savedInstanceState)

        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        selectionTracker.onSaveInstanceState(outState)
    }

    fun setarProdutoByCategoria(idCategoria: Int){

        if(idCategoria == -1)
            adapterProduto.setData(baseProdutos.getAll())
        else
            adapterProduto.setData(baseProdutos.getProdutoByCategoria(idCategoria))

    }

}