package com.itheamc.java_web_project.product.service

import com.itheamc.java_web_project.product.model.Product
import com.itheamc.java_web_project.product.repository.ProductRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class ProductServiceImpl(
    @Autowired
    private val productRepository: ProductRepository
): ProductService  {
    /**
     * To Save the product
     */
    override fun insert(product: Product): Product {
        return productRepository.save(product);
    }

    /**
     * To get the product
     */
    override fun single(id: Long): Product {
        return productRepository.getById(id);
    }


    /**
     * To get the all product
     */
    override fun list(): List<Product> {
        return productRepository.findAll();
    }


    /**
     * To update the product
     */
    @Transactional
    override fun update(product: Product): Product {
        val savedProduct = product.id.let {
            productRepository.findById(it).orElseThrow {
                IllegalStateException("Product with given id is not found")
            }
        }

        savedProduct?.let {
            if (product.name != null && product.name != it.name) it.name = product.name
            if (product.price != null && product.price != savedProduct.price) it.price = product.price
            if (product.quantity != null && product.quantity != savedProduct.quantity) it.quantity = product.quantity
        }

        return savedProduct!!
    }

    /**
     * To delete the product
     */
    override fun delete(id: Long): String {
        productRepository.deleteById(id);
        return "Deleted"
    }
}