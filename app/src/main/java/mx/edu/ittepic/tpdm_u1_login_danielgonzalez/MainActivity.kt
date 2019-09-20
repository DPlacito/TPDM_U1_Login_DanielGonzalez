package mx.edu.ittepic.tpdm_u1_login_danielgonzalez

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import java.util.*

class MainActivity : AppCompatActivity() {

    var imagen : ImageView?= null
    var usuario : EditText ?= null
    var password : EditText ?= null
    var botonLogin : Button ?= null
    var vector_Usuarios = Vector<String>()
    var vector_Passwords = Vector<String>()
    var intentos = 0

    fun vectores (usuario : String, password : String){
        vector_Usuarios.add(usuario)
        vector_Passwords.add(password)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imagen = findViewById(R.id.icono_login)
        usuario = findViewById(R.id.usuario_EditText)
        password = findViewById(R.id.password_EditText)
        botonLogin = findViewById(R.id.boton_login)

        vectores("sergio","pasale1")
        vectores("daniel","pasale2")
        vectores("arturo","pasale3")
        vectores("samy","pasale4")
        vectores("antonio","pasale5")

        //Colocar Imagen Negro
        imagen?.setBackgroundResource(R.drawable.negro)

        botonLogin?.setOnClickListener {
            var login = false
            var campoUsuario = usuario?.text.toString()
            var passwordIngresado = password?.text.toString()
            (0..(vector_Usuarios.size-1)).forEach {
                var usuarioCorrecto = vector_Usuarios.get(it)
                var passwordCorrecto = vector_Passwords.get(it)
                if (campoUsuario.equals(usuarioCorrecto) && passwordIngresado.equals(passwordCorrecto)){
                    val alerta = AlertDialog.Builder(this)
                    alerta.setTitle("ATENCION").setMessage("ACCESO CORRECTO")
                        .setPositiveButton("ACEPTAR"){dialogInterface, i ->  }
                        .show()
                    login = true
                    when (it){
                        0 -> imagen?.setBackgroundResource(R.drawable.azul)
                        1 -> imagen?.setBackgroundResource(R.drawable.usuario2)
                        2 -> imagen?.setBackgroundResource(R.drawable.usuario3)
                        3 -> imagen?.setBackgroundResource(R.drawable.usuario4)
                        4 -> imagen?.setBackgroundResource(R.drawable.usuario5)
                    }
                }
            }
            if (!login){
                imagen?.setBackgroundResource(R.drawable.negro)
                intentos++
                val alerta = AlertDialog.Builder(this)
                alerta.setTitle("ATENCION").setMessage("ERROR AL ENTRAR \n \n" + "Numero De Intentos: "+ intentos +"\n \n NOTA: 3 Intentos ADIOS!!!")
                    .setPositiveButton("ACEPTAR"){dialogInterface, i ->  }
                    .show()
                if (intentos == 3){
                    finish()
                }
            }
            login = false
        }
    }
}
