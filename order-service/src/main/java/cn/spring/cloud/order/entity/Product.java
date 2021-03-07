package cn.spring.cloud.order.entity;

import java.util.Date;

public class Product {
    private Long id;
    private Date time;

    public void setTime(Date time) {
        this.time = time;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Date getTime() {
        return time;
    }

    public Product(Long id) {
        this.id = id;
        this.time = new Date();
    }

    public Product() {
    }
}
