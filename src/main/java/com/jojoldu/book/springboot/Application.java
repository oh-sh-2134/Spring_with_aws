package com.jojoldu.book.springboot;

import org.springframework.boot.SpringApplication;
import  org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing //JPA Auditing 활성화
@SpringBootApplication //스프링부트 자동설정
public class Application {
    public static void main(String[] args){
        SpringApplication.run(Application.class,args); //SpringApplication.run으로 내장 WAS서버 실행
    }
}
