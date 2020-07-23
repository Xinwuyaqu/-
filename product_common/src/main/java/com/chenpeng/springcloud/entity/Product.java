package com.chenpeng.springcloud.entity;



public class Product {
    private Long id;
    private String productName;
    private String productDesc;
    private int    number;

    public String getProductDesc() {
        return productDesc;
    }
    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public Long getProductId() {return id;}
    public void setProductId(Long productId) {
        this.id = productId;
    }
    public int  getProductNum() {return this.number; }
    public void updatePropertory(int num) { this.number = num; }

    @Override
    public String toString() {
        return "Product{" +
                "id=" +             this.getProductId() +
                ", productName='" + this.getProductName() + '\'' +
                ", productDesc='" + this.getProductDesc()+ '\'' +
                ", productNum='" +  this.getProductNum() + '\'' +
                '}';
    }
}
