package com.mas.semana10_servicios.data.model

data class User (
    val id: Int,
    val name: String,
    val username: String,
    val email: String,
    val address: Address,
    val phone: String
)

data class Address(
    val city: String
)