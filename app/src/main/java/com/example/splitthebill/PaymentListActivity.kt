package com.example.splitthebill

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ListView
import com.example.splitthebill.adapters.PaymentListAdapter
import com.example.splitthebill.domain.models.Payment
import com.example.splitthebill.repositories.DataManager

class PaymentListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment_list)

        // Recuperar a lista de pagamentos da Intent
        val paymentList = DataManager.getPaymentList()

        if (paymentList != null) {
            // Configurar um ListView (certifique-se de tê-lo definido no layout XML)
            val listView = findViewById<ListView>(R.id.listView)

            // Criar um adaptador personalizado para a lista de pagamentos
            val adapter = PaymentListAdapter(this, paymentList)

            // Definir o adaptador no ListView
            listView.adapter = adapter
        } else {
            // Trate o caso em que a lista de pagamentos é nula
            Log.e("PaymentListActivity", "A lista de pagamentos é nula.")
            // Você pode mostrar uma mensagem de erro ou realizar outra ação apropriada aqui.
        }
    }

}
