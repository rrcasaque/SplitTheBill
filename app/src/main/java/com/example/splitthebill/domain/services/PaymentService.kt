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
}
