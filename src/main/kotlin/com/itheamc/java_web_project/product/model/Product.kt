package com.itheamc.java_web_project.product.model

import javax.persistence.*

@Entity
@Table(name = "product")
class Product(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    val id: Long,

    var name: String?,
    var price: Double?,
    var quantity: Int?
) {

    fun copy(name: String?, price: Double?, quantity: Int?): Product {
        return Product(
            id = this.id,
            name = name ?: this.name,
            price = price ?: this.price,
            quantity = quantity ?: this.quantity
        )
    }

}