package br.com.fmtech.demoapp.exception

import org.springframework.http.HttpStatus
import org.springframework.web.server.ResponseStatusException

class DonationsNotFoundException extends ResponseStatusException{
    DonationsNotFoundException() {
        super(HttpStatus.NOT_FOUND, "Donation Not Found")
    }
}
