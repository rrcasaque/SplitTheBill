package com.example.splitthebill.repositories

import com.example.splitthebill.domain.models.Payment

object DataManager {
    private var paymentList: List<Payment>? = null

    fun setPaymentList(list: List<Payment>) {
        paymentList = list
    }

    fun getPaymentList(): List<Payment>? {
        return paymentList
    }
}
