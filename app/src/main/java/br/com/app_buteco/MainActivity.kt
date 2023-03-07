    package br.com.app_buteco

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import br.com.app_buteco.databinding.ActivityMainBinding
import br.com.app_buteco.domain.Produto
import br.com.app_buteco.fragments.CardapioFragment

    class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        setFragment(CardapioFragment())

    }

    private fun setFragment(fragment: Fragment){

        val fragmentTransaction = supportFragmentManager.beginTransaction()

        fragmentTransaction.replace(binding.fragmentsContainer.id, fragment)

        fragmentTransaction.commit()

    }

}