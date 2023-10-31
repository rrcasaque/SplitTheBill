package com.example.splitthebill

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import com.example.splitthebill.adapters.PaymentListAdapter
import com.example.splitthebill.repositories.DataManager

class PaymentListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment_list)

        val paymentList = DataManager.getPaymentList()

        if (paymentList != null) {
            val listView = findViewById<ListView>(R.id.listView)

            val adapter = PaymentListAdapter(this, paymentList)

            listView.adapter = adapter
        }
    }

}
