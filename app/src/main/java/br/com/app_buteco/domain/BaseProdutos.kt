package br.com.app_buteco.domain

import br.com.app_buteco.R

class BaseProdutos {

    private val produto1 = Produto(0, "Anéis de cebola", "R$ 24.90",
        R.drawable.aneis_cebola, 0)

    private val produto2 = Produto(1, "Banana Chips", "R$ 18.00",
        R.drawable.banana_chips, 0)

    private val produto3 = Produto(2, "Batata frita", "R$ 24,90",
        R.drawable.batata_frita, 0)

    private val produto4 = Produto(3, "Batata frita especial", "R$ 29,90",
        R.drawable.batata_frita_especial, 0)

    private val produto5 = Produto(4, "Bolinho de bacalhau", "R$ 20,90",
        R.drawable.bolinho_bacalhau, 0)

    private val produto6 = Produto(5, "Bolinho de mandioca", "R$ 27,90",
        R.drawable.bolinho_mandioca, 0)

    private val produto7 = Produto(6, "Bolinho de queijo", "R$ 22,90",
        R.drawable.bolinho_queijo, 0)

    private val produto8 = Produto(7, "Camarão alho e óleo", "R$ 54,90",
        R.drawable.camarao_alho, 0)

    private val produto9 = Produto(8, "Frango a passarinho", "R$ 27,90",
        R.drawable.frango_passarinho, 0)

    private val produto10 = Produto(9, "Mandioca frita", "R$ 19,90",
        R.drawable.mandioca_frita, 0)

    private val produto11 = Produto(10, "Mini pastéis (queijo e carne)",
        "R$ 29,90",
        R.drawable.mini_pasteis, 0)

    private val produto12 = Produto(11, "Salame  com queijo, presunto e azeitonas",
        "R$ 54,90",
        R.drawable.salame_queijo_azeitona,0)

    private val produtos = mutableListOf(produto1, produto2, produto3, produto4, produto5, produto6,
        produto7, produto8, produto9, produto10, produto11, produto12)

    fun  getAll(): MutableList<Produto>{

        return produtos

    }

    fun getProdutoByCategoria(idCategoria: Int): MutableList<Produto>{

        val produtosCategoria = produtos.filter { it.idCategoria == idCategoria }

        return produtosCategoria.toMutableList()
    }

}