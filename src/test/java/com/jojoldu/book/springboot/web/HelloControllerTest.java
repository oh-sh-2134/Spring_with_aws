package com.jojoldu.book.springboot.web;

import com.jojoldu.book.springboot.web.HelloController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class) //SpringRunner라는 스프링 실행자 사용 // 스프링 부트 테스트와 JUnit사이 연결자 역활
@WebMvcTest(controllers = HelloController.class) // 스프링 테스트 어노테이션 중 Web에 집중할 수 있는 어노테이션
public class HelloControllerTest {

    @Autowired // 스프링이 관리하는 Bean을 주입받음 Bean : Spring Framework의 핵심부인 Spring Container에 존재하는 Spring IoC Container를 생성함
    private  MockMvc mvc; // 웹 API를 테스트 할때 사용 , 스프링 MVC 테스트의 시작점, 이 클래스를 통해 GET, HTTP, POST 등에 대한 API 테스트 할 수 있음

    @Test
    public void hello가_리턴된다() throws Exception{
        String hello = "hello";

        mvc.perform(get("/hello")) // /hello 주소로 HTTP GET 요청
                .andExpect(status().isOk()) // mvc.perform의 결과 검증 , HTTP Header의 Status를 검증, OK(200) 검증
                .andExpect(content().string(hello));  // mvc.perform의 결과 검증, 응답 본문의 내용을 검증 Controller에서 "hello" 리턴
    }
    
    @Test
    public void helloDto가_리턴된다() throws Exception{
        String name = "hello";
        int amount = 1000;
        
        mvc.perform(
                get("/hello/dto")
                        .param("name",name) // API 테스트할 때 사용될 요청 파라미터 설정 , 값은 Sting만 허용
                        .param("amount", String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name))) // jsonPath : JSON 응답값을 필드별로 검증할 수 있는 메소드 , $을 기준으로 필드명 명시
                .andExpect(jsonPath("$.amount",is(amount)));

    }
}
