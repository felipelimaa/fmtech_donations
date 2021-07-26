package br.com.fmtech.demoapp.repository

import br.com.fmtech.demoapp.domain.Donations
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface DonationsRepository extends JpaRepository<Donations, Long> {

}