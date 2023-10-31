package com.example.splitthebill.domain.models

class Payment(
    var name: String,
    var amountPaidFirstItem: Double,
    var whatWasBoughtFirstItem: String,
    var amountPaidSecondItem: Double,
    var whatWasBoughtSecondItem: String,
    var amountPaidThirdItem: Double,
    var whatWasBoughtThirdItem: String
)

