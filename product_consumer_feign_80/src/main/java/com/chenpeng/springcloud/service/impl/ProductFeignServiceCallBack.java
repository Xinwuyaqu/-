package com.chenpeng.springcloud.service.impl;

import com.chenpeng.springcloud.entity.Product;
import com.chenpeng.springcloud.service.ProductService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductFeignServiceCallBack implements ProductService {

    public List<Product> listProduct() {
        Product product = new Product();
        product.setProductId(-1L);
        product.setProductName("服务熔断的降级操作");
        product.setProductDesc("不好意思啊 现在用不了 先打一把游侠放松下待会再来哦");
        List<Product> list = new ArrayList<Product>();
        list.add(product);
        return list;
    }

    public Boolean addProduct(Product product) {
        Product product_a = new Product();
        product_a.setProductId(-1L);
        product_a.setProductName("服务熔断的降级操作");
        product_a.setProductDesc("不好意思啊 现在用不了 先打一把游侠放松下待会再来哦");
        return false;
    }

    public Product getProduct(long id){
        Product product = new Product();
        product.setProductId(-1L);
        product.setProductName("服务熔断的降级操作");
        product.setProductDesc("不好意思啊 现在用不了 先打一把游侠放松下待会再来哦");
        return product;
    }
}
