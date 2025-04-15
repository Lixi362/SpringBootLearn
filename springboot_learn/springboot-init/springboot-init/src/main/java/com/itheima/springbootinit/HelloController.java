package com.itheima.springbootinit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    //对象注入
    @Value("${name}")
    private String name;
    @Value("${person.name}")
    private String name2;
    @Value("${person.age}")
    private int age;
    //数组注入
    @Value("${address[0]}")
    private String address1;
    //纯量注入
    @Value("${msg1}")
    private String msg1;
    @Value("${msg2}")
    private String msg2;
    //    Environment注入
    @Autowired
    private Environment env;
    @Autowired
    private Person person;

    @RequestMapping("/hello2")
    public String hello2(){
        System.out.println(name);
        System.out.println("name:"+name2);
        System.out.println("age:"+age);
        System.out.println("age:"+address1);
        System.out.println("age:"+msg1);
        System.out.println("age:"+msg2);
        System.out.println("---------------------------------------");
        System.out.println(env.getProperty("person.name"));
        System.out.println(env.getProperty("address[0]"));
        System.out.println("---------------------------------------");
        System.out.println(person);
        String[] address= person.getAddress();
        for (String s :address){
            System.out.println(s);
        }
        return "lol";
    }
    @RequestMapping("/hello1")
    public String hello(){
        return "Hello Spring Boot!!!";
    }

}
