package br.com.fmtech.demoapp.service

import br.com.fmtech.demoapp.domain.Donations
import br.com.fmtech.demoapp.dto.DonationsDTO
import br.com.fmtech.demoapp.exception.DonationsEmptyValuesException
import br.com.fmtech.demoapp.exception.DonationsNotFoundException
import br.com.fmtech.demoapp.repository.DonationsRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.transaction.Transactional

@Service
class DonationsService {

    @Autowired
    DonationsRepository donationsRepository

    @Autowired
    DonatorsService donatorsService

    List<Donations> findAll() {
        return donationsRepository.findAll()
    }

    Donations get(Long id) {
        Donations donation = donationsRepository.findById(id).orElseThrow(() -> new DonationsNotFoundException())
        return donation
    }

    @Transactional
    DonationsDTO create(DonationsDTO donationsDTO){
        if(donationsDTO.amount == null && donationsDTO.donatorId == null){
            throw new DonationsEmptyValuesException()
        }
        // criar exception e validação do valor de doação quando <= 0

        def donators = donatorsService.get(donationsDTO.donatorId)

        def donations = new Donations(donators: donators)

        donations.amount = donationsDTO.amount

        donationsRepository.save(donations)

        donationsDTO.id = donations.id

        return donationsDTO
    }

}
