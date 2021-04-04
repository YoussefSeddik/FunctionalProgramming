package com.example.functionalprogrammig.session6

import com.example.functionalprogrammig.session6.models.*
import java.util.*

object MocksSession6 {
    fun mockCalcInvoiceList() = mutableListOf(
        Pair(InvoiceChoice.INV1, calcInvoice1()),
        Pair(InvoiceChoice.INV2, calcInvoice2()),
        Pair(InvoiceChoice.INV3, calcInvoice3())
    )

    fun mockCalcShippingList() = mutableListOf(
        Pair(ShippingChoice.SH1, calcShipping1()),
        Pair(ShippingChoice.SH2, calcShipping2()),
        Pair(ShippingChoice.SH3, calcShipping3()),
        Pair(ShippingChoice.SH4, calcShipping4()),
        Pair(ShippingChoice.SH5, calcShipping5())
    )

    fun mockCalcFreightList() = mutableListOf(
        Pair(FreightChoice.FR1, calcFreight1()),
        Pair(FreightChoice.FR2, calcFreight2()),
        Pair(FreightChoice.FR3, calcFreight3())
    )

    fun mockCalcAvailabilityList() = mutableListOf(
        Pair(AvailabilityChoice.AV1, calcAvailability1()),
        Pair(AvailabilityChoice.AV2, calcAvailability2())
    )

    fun mockCalcShippingDateList() = mutableListOf(
        Pair(ShippingDateChoice.SD1, calcShippingDate1()),
        Pair(ShippingDateChoice.SD2, calcShippingDate2()),
        Pair(ShippingDateChoice.SD3, calcShippingDate3()),
        Pair(ShippingDateChoice.SD4, calcShippingDate4())
    )

}

/**
 * CalcInvoices
 * */
////////////////////////////////////////////////////////////////////////////////////////////////////
fun calcInvoice1(): (order: OrderModel) -> InvoiceModel {
    return {
        InvoiceModel(it.productSCosts * 1.2)
    }
}

fun calcInvoice2(): (order: OrderModel) -> InvoiceModel {
    return {
        InvoiceModel(it.productSCosts * .5)
    }
}

fun calcInvoice3(): (order: OrderModel) -> InvoiceModel {
    return {
        InvoiceModel(it.productSCosts * .2)
    }
}
////////////////////////////////////////////////////////////////////////////////////////////////////
/**
 * CalcShippings
 * */
////////////////////////////////////////////////////////////////////////////////////////////////////
fun calcShipping1(): (invoice: InvoiceModel) -> ShippingModel {
    return {
        ShippingModel(1, it.cost + 1)
    }
}

fun calcShipping2(): (invoice: InvoiceModel) -> ShippingModel {
    return {
        ShippingModel(2, it.cost + 2)
    }
}

fun calcShipping3(): (invoice: InvoiceModel) -> ShippingModel {
    return {
        ShippingModel(3, it.cost + 3)
    }
}

fun calcShipping4(): (invoice: InvoiceModel) -> ShippingModel {
    return {
        ShippingModel(4, it.cost + 4)
    }
}

fun calcShipping5(): (invoice: InvoiceModel) -> ShippingModel {
    return {
        ShippingModel(5, it.cost + 5)
    }
}
////////////////////////////////////////////////////////////////////////////////////////////////////
/**
 * CalcFreightCost
 * */
////////////////////////////////////////////////////////////////////////////////////////////////////
fun calcFreight1(): (shipping: ShippingModel) -> FreightModel {
    return {
        FreightModel(it.cost)
    }
}

fun calcFreight2(): (shipping: ShippingModel) -> FreightModel {
    return {
        FreightModel(it.cost + 3)
    }
}

fun calcFreight3(): (shipping: ShippingModel) -> FreightModel {
    return {
        FreightModel(it.cost + 5)
    }
}
////////////////////////////////////////////////////////////////////////////////////////////////////
/**
 * CalcAvailability
 * */
////////////////////////////////////////////////////////////////////////////////////////////////////
fun calcAvailability1(): (order: OrderModel) -> AvailabilityModel {
    return {
        AvailabilityModel(Calendar.getInstance().apply { add(Calendar.MONTH, 1) })
    }
}

fun calcAvailability2(): (order: OrderModel) -> AvailabilityModel {
    return {
        AvailabilityModel(Calendar.getInstance().apply { add(Calendar.DAY_OF_MONTH, 15) })
    }
}
////////////////////////////////////////////////////////////////////////////////////////////////////
/**
 * CalcShippingDate
 * */
////////////////////////////////////////////////////////////////////////////////////////////////////
fun calcShippingDate1(): (availability: AvailabilityModel) -> ShippingDateModel {
    return {
        ShippingDateModel(it.calendar.apply { add(Calendar.DAY_OF_MONTH, 1) })
    }
}

fun calcShippingDate2(): (availability: AvailabilityModel) -> ShippingDateModel {
    return {
        ShippingDateModel(it.calendar.apply { add(Calendar.DAY_OF_MONTH, 2) })
    }
}

fun calcShippingDate3(): (availability: AvailabilityModel) -> ShippingDateModel {
    return {
        ShippingDateModel(it.calendar.apply { add(Calendar.DAY_OF_MONTH, 3) })
    }
}

fun calcShippingDate4(): (availability: AvailabilityModel) -> ShippingDateModel {
    return {
        ShippingDateModel(it.calendar.apply { add(Calendar.DAY_OF_MONTH, 4) })
    }
}

//composer
////////////////////////////////////////////////////////////////////////////////////////////////////
fun <T1, T2, T3> ((T1) -> T2).compose(t2: (T2) -> T3): (T1) -> T3 {
    return {
        t2(this(it))
    }
}
