package br.com.app_buteco.domain

class BaseCategorias {

    private val categoriaTodos = Categoria(-1, "Todas")
    private val categoria1 = Categoria(0, "Porções e petiscos")
    private val categoria2 = Categoria(1, "Espetinhos")
    private val categoria3 = Categoria(2, "Bebidas vendidas em dose")
    private val categoria4 = Categoria(3, "Vinhos")
    private val categoria5 = Categoria(4, "Sucos")
    private val categoria6 = Categoria(5, "Bebidas de lata ou garrafas individuais")
    private val categoria7 = Categoria(6, "Coquetéis")

    private val categorias = mutableListOf(categoriaTodos, categoria1, categoria2, categoria3, categoria4,
        categoria5, categoria6, categoria7)

    fun getAll(): MutableList<Categoria>{

        return categorias

    }

}