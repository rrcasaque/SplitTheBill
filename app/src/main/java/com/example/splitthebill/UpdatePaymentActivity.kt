package com.example.splitthebill

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.splitthebill.domain.models.Payment
import com.example.splitthebill.domain.services.PaymentService

class UpdatePaymentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_payment)


        val editNome = findViewById<EditText>(R.id.editNome)
        val editValorPago = findViewById<EditText>(R.id.editValorPago)
        val editOQueComprou = findViewById<EditText>(R.id.editOQueComprou)

        val name = intent.getStringExtra("name")
        val amountPaid = intent.getDoubleExtra("amountPaid", 0.0) // 0.0 é um valor padrão caso não haja valor extra
        val whatWasBought = intent.getStringExtra("whatWasBought")

        editNome.setText(name)
        editValorPago.setText(amountPaid.toString())
        editOQueComprou.setText(whatWasBought)

        val btnEditar = findViewById<Button>(R.id.btnEditar)
        btnEditar.setOnClickListener {

            val updatedName = editNome.text.toString()
            val updatedAmountPaid = editValorPago.text.toString().toDouble()
            val updatedWhatWasBought = editOQueComprou.text.toString()

            val updatedPayment = Payment(updatedName, updatedAmountPaid, updatedWhatWasBought)

            val originalName = intent.getStringExtra("name")

            PaymentService.updatePaymentByName(updatedName, updatedPayment)

            editNome.text.clear()
            editValorPago.text.clear()
            editOQueComprou.text.clear()

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

            Toast.makeText(this, "Pagamento editado com sucesso", Toast.LENGTH_SHORT).show()
        }

    }
}
