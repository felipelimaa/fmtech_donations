package br.com.fmtech.demoapp.exception

import org.springframework.http.HttpStatus
import org.springframework.web.server.ResponseStatusException

class DonationsEmptyValuesException extends ResponseStatusException{
    DonationsEmptyValuesException(){
        super(HttpStatus.BAD_REQUEST, "Donations with required field is empty")
    }
}
