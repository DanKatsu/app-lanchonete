package br.com.app_buteco.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.app_buteco.R
import br.com.app_buteco.domain.Produto

class AdapterProduto(

    private val context: Context

) : RecyclerView.Adapter<AdapterProduto.ProdutoViewHolder>(){

    private var produtos: MutableList<Produto> = mutableListOf()

    @SuppressLint("NotifyDataSetChanged")
    fun setData(list: List<Produto>) {
        produtos.clear()
        produtos.addAll(list)
        notifyDataSetChanged()
    }

    inner class ProdutoViewHolder(

        itemView: View

    ): RecyclerView.ViewHolder(itemView){

        var nomeProduto = itemView.findViewById<TextView>(R.id.tv_name_produto)!!
        var categoriaProduto = itemView.findViewById<TextView>(R.id.tv_categoria)
        var precoProduto = itemView.findViewById<TextView>(R.id.tv_preco_produto)!!
        var imgProduto = itemView.findViewById<ImageView>(R.id.iv_img_produto)!!

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProdutoViewHolder {

        val itemList = LayoutInflater.from(context)
            .inflate(R.layout.fragment_cardapio_simple_item, parent, false)

        return ProdutoViewHolder(itemList)

    }

    override fun onBindViewHolder(holder: ProdutoViewHolder, position: Int) {

        holder.nomeProduto.text = produtos[position].nomeProduto

        when(produtos[position].idCategoria){

            0 -> holder.categoriaProduto.setText(R.string.categoria_id_0_porcoes)
            1 -> holder.categoriaProduto.setText(R.string.categoria_id_1_espetos)
            2 -> holder.categoriaProduto.setText(R.string.categoria_id_2_doses)
            3 -> holder.categoriaProduto.setText(R.string.categoria_id_3_vinhos)
            4 -> holder.categoriaProduto.setText(R.string.categoria_id_4_sucos)
            5 -> holder.categoriaProduto.setText(R.string.categoria_id_5_latas)
            6 -> holder.categoriaProduto.setText(R.string.categoria_id_6_coqueteis)

        }

        holder.precoProduto.text = produtos[position].precoProduto
        holder.imgProduto.setImageResource(produtos[position].srcImgProduto)

    }

    override fun getItemCount(): Int = produtos.size

}