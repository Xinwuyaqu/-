package com.chenpeng.springcloud;

import com.chenpeng.springcloud.entity.Product;
import com.chenpeng.springcloud.service.impl.ProductServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ProductServiceTest {
    @Resource
    private ProductServiceImpl productServiceImpl;

    @Test
    public void testGet(){
        System.out.println(productServiceImpl.get(1));
    }

    @Test
    public void TestAdd(){
        Product product = new Product();
        product.setProductId(10L);
        product.setProductName("iphone" + System.currentTimeMillis());
        System.out.println(productServiceImpl.add(product));

    }

    @Test
    public void TestList(){
        System.out.println(productServiceImpl.list());
    }
}
