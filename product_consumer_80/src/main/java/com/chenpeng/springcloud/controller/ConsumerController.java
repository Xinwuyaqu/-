package com.chenpeng.springcloud.controller;

import com.chenpeng.springcloud.entity.Product;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author chenpeng
 */
@RestController
@RequestMapping("/consumer")
public class ConsumerController {
    /*
     * private static final String REST_URL_PREFIX = "http://localhost:8001";
     */

    @Resource
    private RestTemplate restTemplate;

    private static final String REST_URL_PREFIX = "http://PRODUCT-PROVIDER";
    @Resource
    private HttpHeaders httpHeaders;

    @RequestMapping("/product/get/{id}")
    public Object getProduct(@PathVariable("id") long id) {
        Product product = restTemplate.exchange(REST_URL_PREFIX +"/product/get/" + id, HttpMethod.GET, new HttpEntity<Object>(httpHeaders), Product.class).getBody();
        return product;
    }

    @RequestMapping("/product/getRepertory/{id}")
    public Object getRepertory(@PathVariable("id") long id) {
        int number= restTemplate.exchange(REST_URL_PREFIX +"/product/getRepertory/" + id, HttpMethod.GET, new HttpEntity<Object>(httpHeaders), int.class).getBody();
        return number;
    }



    @RequestMapping("/product/list")
    public Object listProduct() {
        List<Product> list = restTemplate.exchange(REST_URL_PREFIX + "/product/list/" , HttpMethod.GET, new HttpEntity<Object>(httpHeaders), List.class).getBody();
//        List<Product> list = restTemplate.exchange("http:localhost:8004/product/list/" , HttpMethod.GET, new HttpEntity<Object>(httpHeaders), List.class).getBody();
        return list;
    }

    @RequestMapping("/product/add")
    public Object addPorduct(Product product) {
        Boolean result = restTemplate.exchange(REST_URL_PREFIX + "/product/add/", HttpMethod.POST, new HttpEntity<Object>(product, httpHeaders), Boolean.class).getBody();
        return result;
    }
}
