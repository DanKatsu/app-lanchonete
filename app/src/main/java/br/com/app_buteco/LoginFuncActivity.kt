package br.com.app_buteco

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.app_buteco.databinding.ActivityLoginFuncBinding

class LoginFuncActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginFuncBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginFuncBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.tvMudarLogin.setOnClickListener {

            val intent = Intent(this, LoginClienteActivity::class.java)

            startActivity(intent)
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)

        }

    }

    override fun finish() {
        super.finish()
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
    }
}