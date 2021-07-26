package br.com.fmtech.demoapp.service

import br.com.fmtech.demoapp.domain.Donators
import br.com.fmtech.demoapp.exception.DonatorsNotFoundException
import br.com.fmtech.demoapp.repository.DonatorsRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
class DonatorsService {

    @Autowired
    DonatorsRepository donatorsRepository

    List<Donators> findAll() {
        return donatorsRepository.findAll()
    }

    Donators get(Long id) {
        Donators donator = donatorsRepository.findById(id).orElseThrow(() -> new DonatorsNotFoundException())

        return donator
    }

    Donators create(Donators donator) {
        return donatorsRepository.save(donator)
    }
}
