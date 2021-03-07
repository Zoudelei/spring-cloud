package cn.spring.cloud.product.controller;

import cn.spring.cloud.product.entity.Product;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    @Autowired
    private EurekaClient eurekaClient;

    @GetMapping("product/{id}")
    public Product getProduct(@PathVariable Long id){
        return new Product(id);
    }

    @GetMapping("test/info")
    public InstanceInfo getInfo(){
        InstanceInfo info = eurekaClient.getNextServerFromEureka("DF-USER", false);
        return info;
    }

    @GetMapping("/get-product")
    public Product getProduct(Product product){
        return product; // 返回一个复杂的user对象，检查是否能够返回到User 对象
    }

}
