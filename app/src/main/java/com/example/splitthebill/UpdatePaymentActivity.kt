package com.example.splitthebill

import android.annotation.SuppressLint
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
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_payment)


        val editNome = findViewById<EditText>(R.id.editNome)
        val editValorPago = findViewById<EditText>(R.id.editValorPago)
        val editOQueComprou = findViewById<EditText>(R.id.editOQueComprou)
        val editValorPago2 = findViewById<EditText>(R.id.editValorPago2)
        val editOQueComprou2 = findViewById<EditText>(R.id.editOQueComprou2)
        val editValorPago3 = findViewById<EditText>(R.id.editValorPago3)
        val editOQueComprou3 = findViewById<EditText>(R.id.editOQueComprou3)

        val name = intent.getStringExtra("name")
        val amountPaid = intent.getDoubleExtra("amountPaid", 0.0) // 0.0 é um valor padrão caso não haja valor extra
        val whatWasBought = intent.getStringExtra("whatWasBought")
        val amountPaid2 = intent.getDoubleExtra("amountPaid2", 0.0) // 0.0 é um valor padrão caso não haja valor extra
        val whatWasBought2 = intent.getStringExtra("whatWasBought2")
        val amountPaid3 = intent.getDoubleExtra("amountPaid3", 0.0) // 0.0 é um valor padrão caso não haja valor extra
        val whatWasBought3 = intent.getStringExtra("whatWasBought3")

        editNome.setText(name)
        editValorPago.setText(amountPaid.toString())
        editOQueComprou.setText(whatWasBought)
        editValorPago2.setText(amountPaid2.toString())
        editOQueComprou2.setText(whatWasBought2)
        editValorPago3.setText(amountPaid3.toString())
        editOQueComprou3.setText(whatWasBought3)

        val btnEditar = findViewById<Button>(R.id.btnEditar)
        btnEditar.setOnClickListener {

            val updatedName = editNome.text.toString()
            val updatedAmountPaid = editValorPago.text.toString().toDouble()
            val updatedWhatWasBought = editOQueComprou.text.toString()
            val updatedAmountPaid2 = editValorPago2.text.toString().toDouble()
            val updatedWhatWasBought2 = editOQueComprou2.text.toString()
            val updatedAmountPaid3 = editValorPago3.text.toString().toDouble()
            val updatedWhatWasBought3 = editOQueComprou3.text.toString()

            val updatedPayment = Payment(updatedName, updatedAmountPaid, updatedWhatWasBought, updatedAmountPaid2, updatedWhatWasBought2, updatedAmountPaid3, updatedWhatWasBought3)

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
