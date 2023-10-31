package com.example.splitthebill

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.splitthebill.domain.models.Payment
import com.example.splitthebill.domain.services.PaymentService
import com.example.splitthebill.repositories.DataManager
import java.io.Serializable

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnCadastrarPagamento = findViewById<Button>(R.id.btnCadastrarPagamento)
        val btnListaPagamentos = findViewById<Button>(R.id.btnListaPagamentos)
        val btnFazerRacha = findViewById<Button>(R.id.btnFazerRacha)

        btnCadastrarPagamento.setOnClickListener {
            val intent = Intent(this, RegisterPaymentActivity::class.java)
            startActivity(intent)
        }

        btnListaPagamentos.setOnClickListener {
            val payments = PaymentService.getAllPayments()
            if (payments.isNotEmpty()) {
                DataManager.setPaymentList(payments)
                val intent = Intent(this, PaymentListActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "A lista de pagamentos está vazia.", Toast.LENGTH_SHORT).show()
            }
        }

        btnFazerRacha.setOnClickListener {
            val payments = PaymentService.getAllPayments()
            if (payments.isNotEmpty()) {
                DataManager.setPaymentList(PaymentService.splitPayments()!!)
                val intent = Intent(this, DividePaymentActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "A lista de pagamentos está vazia.", Toast.LENGTH_SHORT).show()
            }
        }



    }
}