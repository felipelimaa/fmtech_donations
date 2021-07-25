package br.com.fmtech.demoapp.repository

import br.com.fmtech.demoapp.domain.Donators
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.stereotype.Repository

@Repository
interface DonatorsRepository extends PagingAndSortingRepository<Donators, Long>{

}