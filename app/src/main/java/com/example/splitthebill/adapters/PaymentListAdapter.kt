package com.example.splitthebill.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.TextView
import com.example.splitthebill.R
import com.example.splitthebill.UpdatePaymentActivity
import com.example.splitthebill.domain.models.Payment
import com.example.splitthebill.domain.services.PaymentService
import com.example.splitthebill.repositories.DataManager

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
        val valorPagoTextView2 = listItemView?.findViewById<TextView>(R.id.valorTextView2)
        val oQueComprouTextView2 = listItemView?.findViewById<TextView>(R.id.oQueComprouTextView2)
        val valorPagoTextView3 = listItemView?.findViewById<TextView>(R.id.valorTextView3)
        val oQueComprouTextView3 = listItemView?.findViewById<TextView>(R.id.oQueComprouTextView3)
        val excluirButton = listItemView?.findViewById<Button>(R.id.excluirButton)
        val editarButton = listItemView?.findViewById<Button>(R.id.editarButton)

        nomeTextView?.text = payment?.name
        valorPagoTextView?.text = payment?.amountPaidFirstItem.toString()
        oQueComprouTextView?.text = payment?.whatWasBoughtFirstItem
        valorPagoTextView2?.text = payment?.amountPaidSecondItem.toString()
        oQueComprouTextView2?.text = payment?.whatWasBoughtSecondItem
        valorPagoTextView3?.text = payment?.amountPaidThirdItem.toString()
        oQueComprouTextView3?.text = payment?.whatWasBoughtThirdItem

        excluirButton?.setOnClickListener {
            if (payment != null) {
                PaymentService.removePaymentByName(payment.name)
            }
            notifyDataSetChanged()
        }

        editarButton?.setOnClickListener {
            if (payment != null) {
                val intent = Intent(context, UpdatePaymentActivity::class.java)
                intent.putExtra("name", payment.name)
                intent.putExtra("amountPaid", payment.amountPaidFirstItem)
                intent.putExtra("whatWasBought", payment.whatWasBoughtFirstItem)
                intent.putExtra("amountPaid2", payment.amountPaidSecondItem)
                intent.putExtra("whatWasBought2", payment.whatWasBoughtSecondItem)
                intent.putExtra("amountPaid3", payment.amountPaidThirdItem)
                intent.putExtra("whatWasBought3", payment.whatWasBoughtThirdItem)
                context.startActivity(intent)
            }
        }



        return listItemView!!
    }
}

