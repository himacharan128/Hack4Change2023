package com.example.farmlease.viewmodel

data class User(
    val userId: String = "",
    val name: String = "",
    val phone: String = "",
    val image: String = "",
    val ownedProducts: List<String> = emptyList(),
    val borrowedProducts: List<String> = emptyList()
)