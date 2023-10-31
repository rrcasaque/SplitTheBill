package com.example.splitthebill.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import android.widget.Button
import com.example.splitthebill.R
import com.example.splitthebill.domain.models.Payment
import com.example.splitthebill.domain.services.PaymentService

class DividePaymentListAdapter(
    private val context: Context,
    private var paymentList: List<Payment>
) : BaseAdapter() {

    override fun getCount(): Int {
        return paymentList.size
    }

    override fun getItem(position: Int): Any {
        return paymentList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.payment_list_divide, null)

        val payment = paymentList[position]

        val nomeTextView = view.findViewById<TextView>(R.id.nomeTextView)
        val oQueComprouTextView = view.findViewById<TextView>(R.id.oQueComprouTextView)
        val valorTextView = view.findViewById<TextView>(R.id.valorTextView)
        val excluirButton = view.findViewById<Button>(R.id.excluirButton)

        nomeTextView.text = payment.name
        oQueComprouTextView.text = payment.whatWasBought

        val formattedAmountPaid = if (payment.amountPaid >= 0) {
            "Receberá R$ ${payment.amountPaid}"
        } else {
            "Deverá pagar R$ ${-payment.amountPaid}"
        }

        valorTextView.text = formattedAmountPaid

        excluirButton.setOnClickListener {
            PaymentService.removePaymentByName(payment.name)
            paymentList = paymentList.filter { it.name != payment.name }
            notifyDataSetChanged()
        }

        return view
    }
}
