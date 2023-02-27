package br.com.app_buteco
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import br.com.app_buteco.databinding.ActivityLoginClienteBinding


class LoginClienteActivity : AppCompatActivity() {

private lateinit var binding: ActivityLoginClienteBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding = ActivityLoginClienteBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.tvMudarLogin.setOnClickListener {

            val intent = Intent(this, LoginFuncActivity::class.java)

            startActivity(intent)
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)

        }

        binding.btnLogar.setOnClickListener{

            val intent = Intent(this, MainActivity::class.java)

            val inputEmail = binding.tiInputEmail
            val inputSenha = binding.tiInputPass

            val res = validarCampos( inputEmail.text, inputSenha.text)

            when(res){

                0 -> inputEmail.error = getString(R.string.logins_campo_obrigatorio)
                1 -> inputSenha.error = getString(R.string.logins_campo_obrigatorio)
                2 -> binding.tvMsgErro.setText(R.string.login_clie_erro_email_senha)
                else -> startActivity(intent)

            }

        }
    }

    private fun validarCampos(campoEmail: Editable? ,campoSenha: Editable?): Int{

        if(campoEmail.isNullOrEmpty())
            return 0

        if(campoSenha.isNullOrEmpty())
            return 1

        if(campoEmail.toString() != "duda@gmail.com.br" && campoSenha.toString() != "1234")
            return 2

        return 3

    }

}