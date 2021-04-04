package com.example.functionalprogrammig.session6

import com.example.functionalprogrammig.session5.compose
import com.example.functionalprogrammig.session6.models.*
import java.util.*


fun main() {
    val order = OrderModel(2000.0, Calendar.getInstance())
    val invoicePath = InvoicePath()
    val availabilityPath = AvailabilityPath()
    val costOfOrder = adjustCost(order, invoicePath, availabilityPath)
    println("LastCost: $costOfOrder")

}

fun getConfiguration(): ProcessConfiguration {
    return ProcessConfiguration(
        invoiceChoice = InvoiceChoice.INV1,
        shippingChoice = ShippingChoice.SH2,
        freightChoice = FreightChoice.FR3,
        availabilityChoice = AvailabilityChoice.AV2,
        shippingDateChoice = ShippingDateChoice.SD1
    )
}

fun adjustCost(
    order: OrderModel,
    invoicePath: InvoicePath,
    availabilityPath: AvailabilityPath
): Double {
    val processConfiguration = getConfiguration()
    val invoicePathCalcFunction = invoicePathCalcFunction(processConfiguration, invoicePath)
    val availabilityPathCalcFunction = invoiceAvailabilityCalcFunction(processConfiguration, availabilityPath)
    val freight = invoicePathCalcFunction(order)
    val shippingDate = availabilityPathCalcFunction(order)
    return if (shippingDate.calendar.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY) freight.cost + 1000 else freight.cost + 500
}

/**
 * compose invoice path functions
 * */
fun invoicePathCalcFunction(
    processConfiguration: ProcessConfiguration,
    invoicePath: InvoicePath
): (OrderModel) -> FreightModel {
    val requiredInvoiceFunc =
        invoicePath.invoiceFunctions.first { it.first == processConfiguration.invoiceChoice }.second
    val requiredShippingFunc =
        invoicePath.shippingFunctions.first { it.first == processConfiguration.shippingChoice }.second
    val requiredFreightFunc =
        invoicePath.freightFunctions.first { it.first == processConfiguration.freightChoice }.second

    /**
     * compose required functions
     * */
    val orderToShipping = requiredInvoiceFunc.compose(requiredShippingFunc)
    val shippingToFreight = orderToShipping.compose(requiredFreightFunc)
    return {
        shippingToFreight(it)
    }
}

/**
 * compose availability path functions
 * */
fun invoiceAvailabilityCalcFunction(
    processConfiguration: ProcessConfiguration,
    availabilityPath: AvailabilityPath
): (OrderModel) -> ShippingDateModel {
    val requiredAvailabilityFunc =
        availabilityPath.availabilityFunctions.first { it.first == processConfiguration.availabilityChoice }.second
    val requiredShippingDateFunc =
        availabilityPath.shippingDateFunctions.first { it.first == processConfiguration.shippingDateChoice }.second

    /**
     * compose required functions
     * */
    val availabilityToShippingDate = requiredAvailabilityFunc.compose(requiredShippingDateFunc)
    return {
        availabilityToShippingDate(it)
    }
}


data class InvoicePath(
    val invoiceFunctions: MutableList<Pair<InvoiceChoice, (order: OrderModel) -> InvoiceModel>> = MocksSession6.mockCalcInvoiceList(),
    val shippingFunctions: MutableList<Pair<ShippingChoice, (invoice: InvoiceModel) -> ShippingModel>> = MocksSession6.mockCalcShippingList(),
    val freightFunctions: MutableList<Pair<FreightChoice, (shipping: ShippingModel) -> FreightModel>> = MocksSession6.mockCalcFreightList()
)

data class AvailabilityPath(
    val availabilityFunctions: MutableList<Pair<AvailabilityChoice, (order: OrderModel) -> AvailabilityModel>> = MocksSession6.mockCalcAvailabilityList(),
    val shippingDateFunctions: MutableList<Pair<ShippingDateChoice, (availabilityModel: AvailabilityModel) -> ShippingDateModel>> = MocksSession6.mockCalcShippingDateList()
)