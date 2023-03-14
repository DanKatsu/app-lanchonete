package br.com.app_buteco.domain

data class Produto (

    val idProduto: Int,
    val nomeProduto: String,
    val precoProduto: String,
    val srcImgProduto: Int,
    val idCategoria: Int,
    var quantidade: Int = 1

)

