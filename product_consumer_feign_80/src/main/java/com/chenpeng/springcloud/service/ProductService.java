package com.chenpeng.springcloud.service;

import com.chenpeng.springcloud.entity.Product;
import com.chenpeng.springcloud.service.impl.ProductFeignServiceCallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/*
 * 申明需要调用的微服务
 * @ProductService
 *  name:微服务名称
 */

@FeignClient(name = "PRODUCT-PROVIDER", fallback = ProductFeignServiceCallBack.class)
public interface ProductService {
    /*
     *配置调用微服务的接口
     */
    @RequestMapping(value = "/product/get/{id}", method = RequestMethod.GET)
    public Product getProduct(@PathVariable("id") long id);

    @RequestMapping(value = "/product/list", method = RequestMethod.GET)
    public List<Product> listProduct();

    @RequestMapping(value = "/product/add", method = RequestMethod.POST)
    public Boolean addProduct(Product product);

}
