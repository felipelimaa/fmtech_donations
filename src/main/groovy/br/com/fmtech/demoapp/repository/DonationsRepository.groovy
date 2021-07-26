package br.com.fmtech.demoapp.repository

import br.com.fmtech.demoapp.domain.Donations
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface DonationsRepository extends JpaRepository<Donations, Long> {

    List<Donations> findByDonatorsId(Long donators)

//    @Query("SELECT SUM(d.amount) FROM Donations d")
//    @Query("SELECT new map(SUM(d.amount), 'total' as total ) FROM Donations d")
//    @Query("SELECT new map(SUM(d.amount) as total ) FROM Donations d")
    @Query("SELECT new map(SUM(d.amount) as total, CURRENT_TIMESTAMP as consultation_date ) FROM Donations d")
    Object totalAmount()

}