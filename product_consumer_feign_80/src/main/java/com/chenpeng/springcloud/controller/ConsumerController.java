package com.chenpeng.springcloud.controller;

import com.chenpeng.springcloud.entity.Product;
import com.chenpeng.springcloud.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/consumer")
public class ConsumerController {
    @Autowired
    private ProductService productService;

    @RequestMapping("/product/get/{id}")
    public Object getProduct(@PathVariable("id") long id) {
        Product product = productService.getProduct(id);
        return product;
    }

    @RequestMapping("/product/list")
    public Object listProduct() {
        List<Product> list = productService.listProduct();
        return list;
    }

    @RequestMapping("/product/add")
    public Object addPorduct(Product product) {
        Boolean result = productService.addProduct(product);
        return result;
    }
}
