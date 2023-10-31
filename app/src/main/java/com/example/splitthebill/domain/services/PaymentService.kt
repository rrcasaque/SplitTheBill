package com.example.splitthebill.domain.services

import com.example.splitthebill.domain.models.Payment
import java.io.Serializable

object PaymentService {
    private val paymentList = mutableListOf<Payment>()

    // Adicionar um pagamento à lista
    fun addPayment(payment: Payment) {
        paymentList.add(payment)
    }

    // Remover um pagamento pelo nome
    fun removePaymentByName(name: String) {
        paymentList.removeAll { it.name == name }
    }

    // Retornar a lista de pagamentos
    fun getAllPayments(): List<Payment> {
        return paymentList
    }

    fun splitPayments(): List<Payment>? {
        if (paymentList.isNotEmpty()) {
            val total = paymentList.map { it.amountPaidFirstItem + it.amountPaidSecondItem + it.amountPaidThirdItem }.sum()
            val avg = total / paymentList.size
            val paymentSplitList = paymentList.map { payment ->
                val newAmountPaid = payment.amountPaidFirstItem + payment.amountPaidSecondItem + payment.amountPaidThirdItem - avg
                Payment(payment.name, newAmountPaid, payment.whatWasBoughtFirstItem, 0.0, payment.whatWasBoughtSecondItem, 0.0, payment.whatWasBoughtThirdItem)
            }

            return paymentSplitList
        }
        return null
    }

    fun updatePaymentByName(name: String, updatedPayment: Payment) {
        val index = paymentList.indexOfFirst { it.name == name }
        if (index != -1) {
            paymentList[index] = updatedPayment
        }
    }
}
