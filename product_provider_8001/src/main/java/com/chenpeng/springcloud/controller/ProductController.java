package com.chenpeng.springcloud.controller;

import com.chenpeng.springcloud.entity.Product;
import com.chenpeng.springcloud.service.ProductService;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author chenpeng
 */
@RestController
@RequestMapping("/product")
public class ProductController {
    @Resource
    private ProductService productService;

    @Resource
    private DiscoveryClient discoveryClient;

    @RequestMapping(value = "/get/{id}")
    public Object get(@PathVariable("id") long id) {
        return this.productService.get(id) ;
    }
    @RequestMapping(value="/add")
    public Object add(@RequestBody Product product) {
        return this.productService.add(product) ;
    }
    @RequestMapping(value="/list")
    public Object list() {
        return this.productService.list() ;
    }
    @RequestMapping(value="/getRepertory/{id}")
    public Object getRepertory(@PathVariable("id")long id){
        return this.productService.getRepertory(id);
    }
    @RequestMapping(value = "/update/{id}")
    public Object updateRepertory(@PathVariable("id")long id){
        return this.productService.updateRepertory(id);
    }

    @RequestMapping(value = "/discovery")
    public Object discovery(){
        return this.discoveryClient;
    }

}
