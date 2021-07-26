package br.com.fmtech.demoapp.dto

import com.fasterxml.jackson.annotation.JsonProperty

class DonationsDTO {

    @JsonProperty("donation_id")
    Long id

    @JsonProperty(value = "donator_id", required = true)
    Long donatorId

    @JsonProperty(value = "amount", required = true)
    BigDecimal amount

}
