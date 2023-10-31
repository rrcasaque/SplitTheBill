package com.example.splitthebill

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.splitthebill.domain.models.Payment
import com.example.splitthebill.domain.services.PaymentService

class RegisterPaymentActivity : AppCompatActivity() {
    private lateinit var editNome: EditText
    private lateinit var editValorPago: EditText
    private lateinit var editOQueComprou: EditText
    private lateinit var btnCadastrar: Button

    private val paymentService = PaymentService()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_payment)

        // Referenciar os elementos de entrada e o botão
        editNome = findViewById(R.id.editNome)
        editValorPago = findViewById(R.id.editValorPago)
        editOQueComprou = findViewById(R.id.editOQueComprou)
        btnCadastrar = findViewById(R.id.btnCadastrar)

        // Configurar o clique no botão de cadastro
        btnCadastrar.setOnClickListener {
            // Capturar os valores inseridos nos campos de entrada
            val nome = editNome.text.toString()
            val valorPago = editValorPago.text.toString().toDoubleOrNull() ?: 0.0
            val oQueComprou = editOQueComprou.text.toString()

            // Criar um objeto Payment com os valores capturados
            val payment = Payment(nome, valorPago, oQueComprou)

            // Adicionar o objeto Payment à lista usando o PaymentService
            paymentService.addPayment(payment)

            // Limpar os campos de entrada
            editNome.text.clear()
            editValorPago.text.clear()
            editOQueComprou.text.clear()
        }
    }
}
