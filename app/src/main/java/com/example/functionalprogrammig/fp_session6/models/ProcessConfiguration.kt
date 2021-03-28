package com.example.functionalprogrammig.fp_session6.models

data class ProcessConfiguration(
    val invoiceChoice: InvoiceChoice,
    val shippingChoice: ShippingChoice,
    val freightChoice: FreightChoice,
    val availabilityChoice: AvailabilityChoice,
    val shippingDateChoice: ShippingDateChoice
)

enum class InvoiceChoice {
    INV1,
    INV2,
    INV3
}

enum class ShippingChoice {
    SH1,
    SH2,
    SH3,
    SH4,
    SH5

}

enum class FreightChoice {
    FR1,
    FR2,
    FR3
}

enum class AvailabilityChoice {
    AV1,
    AV2
}

enum class ShippingDateChoice {
    SD1,
    SD2,
    SD3,
    SD4
}