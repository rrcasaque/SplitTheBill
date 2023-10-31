package com.example.splitthebill.domain.models

class Payment(
    var name: String,
    var amountPaidFirstItem: Double,
    var whatWasBoughtFirstItem: String,
    var amountPaidSecondItem: Double,
    var whatWasBoughtSecondItem: String,
    var amountPaidThirdItem: Double,
    var whatWasBoughtThirdItem: String


) {
    override fun toString(): String {

        var itemsList: MutableList<String> = mutableListOf()

        if(whatWasBoughtFirstItem.isNotEmpty())
            itemsList.add(whatWasBoughtFirstItem)

        if(whatWasBoughtSecondItem.isNotEmpty())
            itemsList.add(whatWasBoughtSecondItem)

        if(whatWasBoughtThirdItem.isNotEmpty())
            itemsList.add(whatWasBoughtThirdItem)

        return "Nome: $name\n" +
                "Valor total: R$ ${amountPaidFirstItem+amountPaidSecondItem+amountPaidThirdItem}\n" +
                "Itens comprados: ${itemsList.toString().replace("[","").replace("]","")} "
    }
}
