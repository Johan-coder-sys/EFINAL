package com.example.efinal.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doOnTextChanged
import com.example.efinal.databinding.ActivityLoginBinding
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()

        binding.btnlogin.setOnClickListener {
            val email = binding.tilEmail.editText?.text.toString()
            val password = binding.tilPassword.editText?.text.toString()
            signInWithEmailAndPassword(email, password)
        }

        binding.tilEmail.editText?.doOnTextChanged { text, _, _, _ ->
            val isValidEmail = text?.endsWith("@gmail.com") ?: false
            binding.tilEmail.error = if (isValidEmail) null else "Por favor utiliza un correo Gmail"
        }
        //user: stephanomarr42@gmail.com
        //pass: 123456789
    }

    private fun signInWithEmailAndPassword(email: String, password: String) {
        if (email.endsWith("@gmail.com")) {
            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        val user: FirebaseUser? = auth.currentUser
                        Snackbar.make(binding.root, "Inicio de sesión exitoso como ${user?.email}", Snackbar.LENGTH_SHORT).show()
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                        finish()
                    } else {
                        Snackbar.make(binding.root, "Inicio de sesión fallido. Verifica tus credenciales", Snackbar.LENGTH_SHORT).show()
                    }
                }
        } else {
            Snackbar.make(binding.root, "Por favor utiliza un correo Gmail", Snackbar.LENGTH_SHORT).show()
        }
    }
}
