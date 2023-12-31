package com.example.splitthebill

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.splitthebill.domain.models.Payment
import com.example.splitthebill.domain.services.PaymentService
import android.widget.Toast

class RegisterPaymentActivity : AppCompatActivity() {
    private lateinit var editNome: EditText
    private lateinit var editValorPago: EditText
    private lateinit var editOQueComprou: EditText
    private lateinit var editValorPago2: EditText
    private lateinit var editOQueComprou2: EditText
    private lateinit var editValorPago3: EditText
    private lateinit var editOQueComprou3: EditText
    private lateinit var btnCadastrar: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_payment)

        // Referenciar os elementos de entrada e o botão
        editNome = findViewById(R.id.editNome)
        editValorPago = findViewById(R.id.editValorPago)
        editOQueComprou = findViewById(R.id.editOQueComprou)
        editValorPago2 = findViewById(R.id.editValorPago2)
        editOQueComprou2 = findViewById(R.id.editOQueComprou2)
        editValorPago3 = findViewById(R.id.editValorPago3)
        editOQueComprou3 = findViewById(R.id.editOQueComprou3)
        btnCadastrar = findViewById(R.id.btnCadastrar)

        // Configurar o clique no botão de cadastro
        btnCadastrar.setOnClickListener {
            // Capturar os valores inseridos nos campos de entrada
            val nome = editNome.text.toString()
            val valorPago = editValorPago.text.toString().toDoubleOrNull() ?: 0.0
            val oQueComprou = editOQueComprou.text.toString()
            val valorPago2 = editValorPago2.text.toString().toDoubleOrNull() ?: 0.0
            val oQueComprou2 = editOQueComprou2.text.toString()
            val valorPago3 = editValorPago3.text.toString().toDoubleOrNull() ?: 0.0
            val oQueComprou3 = editOQueComprou3.text.toString()

            // Criar um objeto Payment com os valores capturados
            val payment = Payment(nome, valorPago, oQueComprou, valorPago2, oQueComprou2, valorPago3, oQueComprou3)

            // Adicionar o objeto Payment à lista usando o PaymentService
            PaymentService.addPayment(payment)

            // Limpar os campos de entrada
            editNome.text.clear()
            editValorPago.text.clear()
            editOQueComprou.text.clear()

            // Criar um Intent para iniciar a MainActivity
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

            // Exibir um Toast informando o sucesso do cadastro
            Toast.makeText(this, "Pagamento cadastrado com sucesso", Toast.LENGTH_SHORT).show()
        }
    }
}
