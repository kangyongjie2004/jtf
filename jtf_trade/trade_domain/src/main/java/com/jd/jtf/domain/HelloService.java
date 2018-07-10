package com.jd.jtf.domain;

import org.springframework.stereotype.Service;

@Service("helloService")
public class HelloService {

    public String hello() {
        return "Hello";
    }

}
