package com.example.splitthebill.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.TextView
import com.example.splitthebill.R
import com.example.splitthebill.domain.models.Payment
import com.example.splitthebill.domain.services.PaymentService

class PaymentListAdapter(context: Context, paymentList: List<Payment>) :
    ArrayAdapter<Payment>(context, 0, paymentList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var listItemView = convertView

        if (listItemView == null) {
            listItemView = LayoutInflater.from(context).inflate(
                R.layout.payment_list_item, parent, false
            )
        }

        val payment = getItem(position)

        val nomeTextView = listItemView?.findViewById<TextView>(R.id.nomeTextView)
        val valorPagoTextView = listItemView?.findViewById<TextView>(R.id.valorTextView)
        val oQueComprouTextView = listItemView?.findViewById<TextView>(R.id.oQueComprouTextView)
        val excluirButton = listItemView?.findViewById<Button>(R.id.excluirButton)

        nomeTextView?.text = payment?.name
        valorPagoTextView?.text = payment?.amountPaid.toString()
        oQueComprouTextView?.text = payment?.whatWasBought

        excluirButton?.setOnClickListener {
            if (payment != null) {
                PaymentService.removePaymentByName(payment.name)
            }
            notifyDataSetChanged()
        }

        return listItemView!!
    }
}

