package br.com.app_buteco.fragments

import android.app.AlertDialog
import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.recyclerview.selection.SelectionTracker
import androidx.recyclerview.selection.StorageStrategy
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.app_buteco.R
import br.com.app_buteco.adapter.AdapterCategoria
import br.com.app_buteco.adapter.AdapterProduto
import br.com.app_buteco.adapter.tracker.CategoriaKeyProvider
import br.com.app_buteco.adapter.tracker.CategoriaLockup
import br.com.app_buteco.adapter.tracker.CategoriaPredicate
import br.com.app_buteco.databinding.FragmentCardapioBinding
import br.com.app_buteco.domain.BaseCategorias
import br.com.app_buteco.domain.BaseProdutos
import br.com.app_buteco.domain.ListProduto
import br.com.app_buteco.domain.Produto
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class CardapioFragment : Fragment() {

    private lateinit var binding: FragmentCardapioBinding
    private lateinit var selectionTracker: SelectionTracker<Long>

    private lateinit var rvProduto: RecyclerView
    private lateinit var rvCategoria: RecyclerView

    private lateinit var adapterProduto: AdapterProduto
    private lateinit var adapterCategoria: AdapterCategoria

    private lateinit var baseProdutos: BaseProdutos
    private lateinit var baseCategorias: BaseCategorias

    private var produtosCarrinho = mutableListOf<Produto>()
    private val gson = Gson()

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

        setProdutosCarrinho()

        Log.i("PRODUTOS CARRINHO", produtosCarrinho.toString())

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

        adapterProduto = AdapterProduto(activity?.baseContext!!){

            produto -> moverProdutoCarrinho(produto)

        }

        adapterCategoria = AdapterCategoria(activity?.baseContext!!, baseCategorias.getAll()
        ) {

                id -> setarProdutoByCategoria(id)

        }

        rvProduto.adapter = adapterProduto
        rvCategoria.adapter = adapterCategoria

        configSelectionTracker(savedInstanceState)

        adapterProduto.setData(baseProdutos.getAll())

        binding.ivCarrinho.setOnClickListener {

            mudarFragment()

        }

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

    private fun setarProdutoByCategoria(idCategoria: Int){

        if(idCategoria == -1)
            adapterProduto.setData(baseProdutos.getAll())
        else
            adapterProduto.setData(baseProdutos.getProdutoByCategoria(idCategoria))

    }

    private fun moverProdutoCarrinho(produto: Produto){

        var addCarrinho = true

        for (prod in produtosCarrinho){

            if(prod.idProduto == produto.idProduto){
                prod.quantidade++
                addCarrinho = false
            }
        }

        if (addCarrinho)
            produtosCarrinho.add(produto)

        val alerta = AlertDialog.Builder(context)

        alerta.setTitle(R.string.adapter_produto_alert)

        alerta.setMessage(R.string.adapter_produto_alert)

        alerta.create().show()


    }

    private fun mudarFragment(){

        setSharedPreferences()

        val fragmentManager = activity?.supportFragmentManager

        val transaction = fragmentManager!!.beginTransaction()

        transaction.addToBackStack("cardapioFragment")

        transaction.replace(R.id.fragments_container, CarrinhoFragment())

        transaction.commit()

    }

    private fun setSharedPreferences(){

        val produtosCarrinhoGson = gson.toJson(produtosCarrinho)

        val preferences = requireActivity().getSharedPreferences(
            "produtos_carrinho",
            Context.MODE_PRIVATE
        )

        val editor = preferences.edit()

        editor.putString("keyProdutosCarrinho", produtosCarrinhoGson)

        editor.apply()

    }

    private fun setProdutosCarrinho(){

        val preferences = requireActivity().getSharedPreferences(
            "produtos_carrinho",
            Context.MODE_PRIVATE
        )
        val produtosCarrinhoGson = preferences.getString("keyProdutosCarrinho", "")

        val type = object : TypeToken<MutableList<Produto>>() {}.type

        produtosCarrinho = if(produtosCarrinhoGson.isNullOrEmpty()) {

            mutableListOf()

        }else {

            gson.fromJson(produtosCarrinhoGson, type)

        }
    }

}