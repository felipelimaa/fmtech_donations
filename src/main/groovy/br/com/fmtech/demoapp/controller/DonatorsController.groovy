package br.com.fmtech.demoapp.controller

import br.com.fmtech.demoapp.domain.Donators
import br.com.fmtech.demoapp.service.DonatorsService
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
@RequestMapping("/donators")
class DonatorsController {

    @Autowired
    DonatorsService donatorsService

    @GetMapping
    ResponseEntity<Donators> findAll() {
        List<Donators> donators = donatorsService.findAll()
        return ResponseEntity.ok(donators)
    }

    @GetMapping("/{id}")
    ResponseEntity<Donators> findOne(@PathVariable("id") Long id) {
        Donators donator = donatorsService.get(id)
        return ResponseEntity.ok(donator)
    }

    @PostMapping
    ResponseEntity<Donators> create(@RequestBody Donators donators){
        Donators donatorAdded = donatorsService.create(donators)
        return ResponseEntity.status(HttpStatus.CREATED).body(donatorAdded)
    }
}
