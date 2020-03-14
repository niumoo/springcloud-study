package com.wdbyte.product.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *
 * @author niujinpeng
 * @Date 2020/3/12 22:30
 */
@RestController
public class ServiceController {

    @GetMapping("/msg")
    public String msg() {
        return "this is product msg";
    }
}
