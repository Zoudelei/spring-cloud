package cn.spring.cloud.order.controller;

import cn.spring.cloud.order.entity.Product;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController {
    @Autowired
    private EurekaClient eurekaClient;
    @Autowired
    private RestTemplate restTemplate; //spring 提供了一个接口模板对象
    @GetMapping("order/{id}")
    public Product getUser(@PathVariable Long id){
        InstanceInfo info = eurekaClient.getNextServerFromEureka("PRODUCT-SERVICE", false);
        String homePageUrl = info.getHomePageUrl();
        Product product = restTemplate.getForObject(homePageUrl+"/user/" + id, Product.class);
        return product;
    }
}
