package com.chenpng.springcloud.controller;

import com.chenpeng.springcloud.entity.Product;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/consumer")
public class ProductController {
    /*
     *private static final String REST_URL_PREFIX = "http://localhost:8004";
     * */

    @Resource
    private RestTemplate restTemplate;

    private static final String REST_URL_PREFIX = "http://PRODUCT-PROVIDER";
    @Resource
    private HttpHeaders httpHeaders;

    @HystrixCommand(fallbackMethod = "fallGetProduct")
    @RequestMapping("/product/get/{id}")
    public Object getProduct(@PathVariable("id") long id) {
        if(id == 1){
            throw new RuntimeException("我太难了");
        }
        Product product = restTemplate.exchange(REST_URL_PREFIX +"/product/get/" + id, HttpMethod.GET, new HttpEntity<Object>(httpHeaders), Product.class).getBody();
//        Product product = restTemplate.getForObject(REST_URL_PREFIX + "/product/get/" + id, Product.class);
        return product;
    }

    public Product fallGetProduct(long id){
        Product product = new Product();
        product.setProductId(-1L);
        product.setProductName("服务熔断的降级操作");
        product.setProductDesc("不好意思啊 现在用不了 先打一把游侠放松下待会再来哦");
        return product;
    }

    @HystrixCommand(fallbackMethod = "fallListProduct")
    @RequestMapping("/product/list")
    public Object listProduct() {
//        List<Product> list = restTemplate.getForObject(REST_URL_PREFIX + "/product/list/", List.class);
        List<Product> list = restTemplate.exchange(REST_URL_PREFIX + "/product/list/" , HttpMethod.GET, new HttpEntity<Object>(httpHeaders), List.class).getBody();
        return list;
    }

    public List<Product> fallListProduct() {
        Product product = new Product();
        product.setProductId(-1L);
        product.setProductName("服务熔断的降级操作");
        product.setProductDesc("不好意思啊 现在用不了 先打一把游侠放松下待会再来哦");
        List<Product> list = new ArrayList<Product>();
        list.add(product);
        return list;
    }

    @HystrixCommand(fallbackMethod = "fallAddProduct")
    @RequestMapping("/product/add")
    public Object addPorduct(Product product) {
//        Boolean result = restTemplate.postForObject(REST_URL_PREFIX + "/product/add/", product, boolean.class);
        Boolean result = restTemplate.exchange(REST_URL_PREFIX + "/product/add/",HttpMethod.POST, new HttpEntity<Object>(product, httpHeaders), Boolean.class).getBody();
        return result;
    }

    public Boolean fallAddProduct(Product product) {
        Product product_a = new Product();
        product_a.setProductId(-1L);
        product_a.setProductName("服务熔断的降级操作");
        product_a.setProductDesc("不好意思啊 现在用不了 先打一把游侠放松下待会再来哦");
        return false;
    }

//    @RequestMapping("/test/")
//    public Object CircuitTest(){
//        throw new RuntimeException("我太难了");
//    }
}
