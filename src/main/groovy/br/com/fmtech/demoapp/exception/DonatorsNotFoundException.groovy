package br.com.fmtech.demoapp.exception

import org.springframework.http.HttpStatus
import org.springframework.web.server.ResponseStatusException

class DonatorsNotFoundException extends ResponseStatusException {
    DonatorsNotFoundException() {
        super(HttpStatus.NOT_FOUND, "Donator Not Found")
    }
}
