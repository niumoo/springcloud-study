package com.wdbyte.order.controller;

import com.wdbyte.order.dataobject.ProductInfo;
import com.wdbyte.order.dto.CartDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wdbyte.order.client.ProductClient;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 *
 * @author niujinpeng
 * @Date 2020/3/12 22:32
 */
@RestController
@Slf4j
public class ClientController {

    // @Autowired
    // private LoadBalancerClient loadBalancerClient;

    // @Autowired
    // private RestTemplate restTemplate;

    @Autowired
    private ProductClient productClient;

    @GetMapping("/getProductMsg")
    public String getProductMsg() {
        // 1. 第一种方式,直接使用，url写死，不能多个服务地址
        // RestTemplate restTemplate = new RestTemplate();
        // String response = restTemplate.getForObject("http://localhost:8080/msg", String.class);

        // 2. 第二种方式（利用 loadBalancerClient通过应用名获取 url + port）
        // ServiceInstance serviceInstance = loadBalancerClient.choose("PRODUCT");
        // String host = serviceInstance.getHost();
        // int port = serviceInstance.getPort();
        // String url = String.format("http://%s:%s", host, port + "/msg");
        // RestTemplate restTemplate = new RestTemplate();
        // String response = restTemplate.getForObject(url, String.class);

        // 3. 第三种方式,利用注解 LoadBalancerClient，在 restTemplate 里使用应用名字
        // String response = restTemplate.getForObject("http://PRODUCT/msg", String.class);
        String response = productClient.msg();
        log.info("response={}", response);
        return response;
    }

    @GetMapping("/findByProductId")
    public String findByProductId() {
        List<String> list = Arrays.asList("157875196366160022", "157875227953464068");
        List<ProductInfo> productIdList = productClient.findByProductId(list);
        log.info("response = {}", productIdList);
        return "ok";
    }

    @GetMapping("/decreaseStock")
    public String decreaseStock() {
        productClient.decreaseStock(Arrays.asList(new CartDTO("157875196366160022", 111111)));
        return "ok";
    }
}
