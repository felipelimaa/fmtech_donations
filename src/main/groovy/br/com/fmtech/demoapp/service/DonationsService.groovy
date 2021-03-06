package br.com.fmtech.demoapp.service

import br.com.fmtech.demoapp.domain.Donations
import br.com.fmtech.demoapp.dto.DonationsDTO
import br.com.fmtech.demoapp.exception.AmountDonationsUnderZero
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
        return donationsRepository.findById(id).orElseThrow(() -> new DonationsNotFoundException())
    }

    List<Donations> findByDonator(Long donatorsId){
        return donationsRepository.findByDonatorsId(donatorsId)
    }

    Object totalAmount() {
        return donationsRepository.totalAmount()
    }

    Object totalAmountByDonators(Long donatorsId) {
        return donationsRepository.totalAmountByDonators(donatorsId)
    }

    @Transactional
    DonationsDTO create(DonationsDTO donationsDTO){
        if(donationsDTO.amount == null && donationsDTO.donatorId == null){
            throw new DonationsEmptyValuesException()
        }
        if(donationsDTO.amount <= 0){
            throw new AmountDonationsUnderZero()
        }

        def donators = donatorsService.get(donationsDTO.donatorId)

        def donations = new Donations(donators: donators)

        donations.amount = donationsDTO.amount

        donationsRepository.save(donations)

        donationsDTO.id = donations.id

        return donationsDTO
    }

}
