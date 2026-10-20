package com.example.demo;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component 
public class HpPrinter implements Printer, InitializingBean  {

    private int totalCount;

    private int count;

    @Value ("${minus}")
    private int minus;

    
    @PostConstruct 
    public void init(){
        totalCount = 5;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        count = 5;
    }


    @Override
    public void print(String message) {
        count -= minus;
        System.out.println("HP Printer : " + message);
        System.out.printf("HP Printer totalCount :%d, use %d, %d remains ", totalCount, minus, count);

    }

}
