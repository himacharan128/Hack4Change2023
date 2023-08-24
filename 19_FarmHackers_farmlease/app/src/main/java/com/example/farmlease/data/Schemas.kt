package com.example.farmlease.schemas

import androidx.annotation.DrawableRes
import kotlin.random.Random

data class LeaseItem (
    var id: Int = Random.nextInt(),
    var itemName: String,
    var price: Int,
    var address: String,
    val owner: Owner,
    val type: LeaseItemType,
    var desc: String? = null,
    @DrawableRes var img: Int? = null,
    var landArea: Int? = null,
)

enum class LeaseItemType {
    LAND, EQUIPMENT, LABOUR, STORAGE, TRANSPORT
}

enum class ApplicationStatus {
    PENDING, APPROVED, REJECTED
}
open class Owner (
    var name: String,
    var contact: String,
)

