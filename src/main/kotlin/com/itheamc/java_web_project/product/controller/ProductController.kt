package com.itheamc.java_web_project.product.controller

import com.itheamc.java_web_project.product.model.Product
import com.itheamc.java_web_project.product.service.ProductService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(
    value = ["/api/v1/product"]
)
class ProductController(
    @Autowired
    private val productService: ProductService
) {

    @GetMapping(path = ["/list"])
    fun list(): List<Product> {
        return productService.list()
    }

    @GetMapping(path = ["/{id}"])
    fun product(@PathVariable("id") id: Long): Product {
        return productService.single(id)
    }

    @PostMapping(path = ["/insert"])
    fun insert(@RequestBody product: Product): Product {
        return productService.insert(product)
    }

    @PutMapping(path = ["/update"])
    fun update(@RequestBody product: Product) : Product {
        return productService.update(product)
    }

}