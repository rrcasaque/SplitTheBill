package com.example.splitthebill.domain.models

class Payment(
    var name: String,
    var amountPaid: Double,
    var whatWasBought: String
) {
    // Getters and Setters
    fun getName(): String {
        return name
    }

    fun setName(name: String) {
        this.name = name
    }

    fun getAmountPaid(): Double {
        return amountPaid
    }

    fun setAmountPaid(amountPaid: Double) {
        this.amountPaid = amountPaid
    }

    fun getWhatWasBought(): String {
        return whatWasBought
    }

    fun setWhatWasBought(whatWasBought: String) {
        this.whatWasBought = whatWasBought
    }
}
