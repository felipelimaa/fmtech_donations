package br.com.fmtech.demoapp.controller

import br.com.fmtech.demoapp.domain.Donations
import br.com.fmtech.demoapp.domain.Donators
import br.com.fmtech.demoapp.dto.DonationsDTO
import br.com.fmtech.demoapp.service.DonationsService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/donations")
class DonationsController {

    @Autowired
    DonationsService donationsService

    @GetMapping
    ResponseEntity<Donations> findAll() {
        List<Donations> donations = donationsService.findAll()
        return ResponseEntity.ok(donations)
    }

    @GetMapping("/{id}")
    ResponseEntity<Donations> get(@PathVariable("id") Long id){
        Donations donation = donationsService.get(id)
        return ResponseEntity.ok(donation)
    }

    @PostMapping
    ResponseEntity<DonationsDTO> create(@RequestBody DonationsDTO donationsDTO){
        DonationsDTO donationsAdded = donationsService.create(donationsDTO)
        return ResponseEntity.status(HttpStatus.CREATED).body(donationsAdded)
    }

}
