package br.com.app_buteco.domain

import br.com.app_buteco.R

class BaseProdutos {

    //-------------------------------------------------------------------------------------------
    // PORCOES E PETISCOS
    //-------------------------------------------------------------------------------------------

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

    //-------------------------------------------------------------------------------------------
    // ESPETINHOS
    //-------------------------------------------------------------------------------------------

    private val produto13 = Produto(12, "Espetinho bovino",
        "R$ 8,90",
        R.drawable.espeto_bovino,1)

    private val produto14 = Produto(13, "Espetinho de coração de galinha",
        "R$ 7,50",
        R.drawable.espeto_coracao,1)

    private val produto15 = Produto(14, "Espetinho de frango",
        "R$ 7,00",
        R.drawable.espeto_frango,1)

    private val produto16 = Produto(15, "Espetinho de kafta",
        "R$ 8,90",
        R.drawable.espeto_kafta,1)

    private val produto17 = Produto(16, "Espetinho de linguiça",
        "R$ 8,90",
        R.drawable.espeto_linguica,1)

    private val produto18 = Produto(17, "Espetinho de queijo qualho",
        "R$ 7,90",
        R.drawable.espeto_queijo,1)

    private val produto19 = Produto(18, "Espetinho de tulipa de frango",
        "R$ 7,00",
        R.drawable.espeto_tulipa,1)

    //-------------------------------------------------------------------------------------------
    // BEBIDAS EM DOSE
    //-------------------------------------------------------------------------------------------

    private val produto20 = Produto(19, "Cabaré Ouro",
        "R$ 7,00",
        R.drawable.dose_cabare_ouro,2)

    private val produto21 = Produto(20, "Chopp",
        "R$ 11,00",
        R.drawable.dose_chopp,2)

    private val produto22 = Produto(21, "Chopp de vinho",
        "R$ 12,00",
        R.drawable.dose_chopp_vinho,2)

    private val produto23 = Produto(22, "Espírito de Minas",
        "R$ 10,00",
        R.drawable.espeto_tulipa,2)

    private val produto24 = Produto(23, "Gin Tanqueray",
        "R$ 30,00",
        R.drawable.dose_espirito_minas,2)

    private val produto25 = Produto(24, "Jurupinga",
        "R$ 8,00",
        R.drawable.dose_jurupinga,2)

    private val produto26 = Produto(25, "Martini Bianco",
        "R$ 8,50",
        R.drawable.dose_matini_bianco,2)

    private val produto27 = Produto(26, "Vodka Absolut",
        "R$ 15,00",
        R.drawable.dose_vodka_absolute,2)

    private val produto28 = Produto(27, "Vodka Smirnoff",
        "R$ 10,00",
        R.drawable.dose_vodka_smirnoff,2)

    private val produto29 = Produto(28, "Whisky White Horse",
        "R$ 15,00",
        R.drawable.dose_whisky_horse,2)

    //-------------------------------------------------------------------------------------------
    // VINHOS

    private val produto30 = Produto(29, "Paso Grande",
        "R$ 65,00",
        R.drawable.vinho_paso_grande,3)

    private val produto31 = Produto(30, "Periquita",
        "R$ 75,00",
        R.drawable.vinho_periquita,3)

    private val produtos = mutableListOf(produto1, produto2, produto3,
                                         produto4, produto5, produto6,
                                        produto7, produto8, produto9,
                                        produto10, produto11, produto12,
                                        produto13, produto14, produto15,
                                        produto16, produto17, produto18,
                                        produto19, produto20, produto21,
                                        produto22, produto23, produto24,
                                        produto25, produto26, produto27,
                                        produto28, produto29, produto30,
                                        produto31,)

    fun  getAll(): MutableList<Produto>{

        return produtos

    }

    fun getProdutoByCategoria(idCategoria: Int): MutableList<Produto>{

        val produtosCategoria = produtos.filter { it.idCategoria == idCategoria }

        return produtosCategoria.toMutableList()
    }

}