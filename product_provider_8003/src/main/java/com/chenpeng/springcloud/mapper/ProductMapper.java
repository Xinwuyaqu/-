package com.chenpeng.springcloud.mapper;

import com.chenpeng.springcloud.entity.Product;

import java.util.List;

/**
 * @author chenpeng
 */
public interface ProductMapper {
    boolean create(Product product);
    public Product findById(Long id);
    public List<Product> findAll();
}
