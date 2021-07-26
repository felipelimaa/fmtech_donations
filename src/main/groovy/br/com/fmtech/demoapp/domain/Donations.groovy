package br.com.fmtech.demoapp.domain

import com.fasterxml.jackson.annotation.JsonProperty
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table
@ToString(includePackage = false, includeNames = true)
@EqualsAndHashCode
class Donations {

    @Id
    @Column(name = "donation_id")
    @JsonProperty("donation_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id

    @Column(name = "amount", nullable = false)
    @JsonProperty("amount")
    BigDecimal amount

    @ManyToOne
    @JoinColumn(name = "donator_id", nullable = false)
    Donators donators


}
