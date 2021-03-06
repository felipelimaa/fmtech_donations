package br.com.fmtech.demoapp.repository

import br.com.fmtech.demoapp.domain.Donators
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface DonatorsRepository extends JpaRepository<Donators, Long> {

}