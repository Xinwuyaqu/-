package com.chenpeng.springcloud.service;

import com.chenpeng.springcloud.entity.Product;

import java.util.List;

public interface ProductService {
    Product get(long id);
    boolean add(Product product);
    List<Product> list();
}