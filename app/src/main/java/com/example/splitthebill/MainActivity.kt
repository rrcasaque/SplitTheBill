package com.example.splitthebill

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnCadastrarPagamento = findViewById<Button>(R.id.btnCadastrarPagamento)
        val btnListaPagamentos = findViewById<Button>(R.id.btnListaPagamentos)

        btnCadastrarPagamento.setOnClickListener {
            val intent = Intent(this, RegisterPaymentActivity::class.java)
            startActivity(intent)
        }
    }
}
