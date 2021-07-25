package br.com.fmtech.demoapp.domain

import com.fasterxml.jackson.annotation.JsonProperty

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table
class Donators {

    @Id
    @Column(name = "donator_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("donator_id")
    Long id

    @Column(name = "donator_name", nullable = false)
    @JsonProperty(value = "donator_name", required = true)
    String name
}
