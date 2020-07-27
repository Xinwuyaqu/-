package com.chenpeng.springcloud.mapper;

import com.chenpeng.springcloud.entity.Product;

import java.util.List;

/**
 * @author chenpeng
 */
public interface ProductMapper {
    boolean create(Product product);
    Product findById(Long id);
    List<Product> findAll();
    boolean updateRepertory(Long id);
    int getRepertory(Long id);
}
