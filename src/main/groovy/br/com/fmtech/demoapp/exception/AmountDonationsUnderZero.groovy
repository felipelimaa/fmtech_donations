package br.com.fmtech.demoapp.exception

import org.springframework.http.HttpStatus
import org.springframework.web.server.ResponseStatusException

class AmountDonationsUnderZero extends ResponseStatusException {
    AmountDonationsUnderZero() {
        super(HttpStatus.BAD_REQUEST, "Invalid Donation: Amount under zero")
    }
}
