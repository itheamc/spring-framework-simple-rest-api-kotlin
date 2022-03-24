package com.itheamc.java_web_project.product.service

import com.itheamc.java_web_project.product.model.Product
import javax.transaction.Transactional


interface ProductService {
    /**
     * To Save the product
     */
    fun insert(product: Product): Product;

    /**
     * To get the product
     */
    fun single(id: Long): Product;


    /**
     * To get the all product
     */
    fun list(): List<Product>;

    /**
     * To update the product
     */
    @Transactional
    fun update(product: Product): Product;
    /**
     * To delete the product
     */
    fun delete(id: Long): String;
}