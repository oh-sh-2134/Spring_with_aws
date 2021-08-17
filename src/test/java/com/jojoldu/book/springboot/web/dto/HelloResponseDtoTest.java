package com.jojoldu.book.springboot.web.dto;

import org.junit.Test;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDtoTest {
    @Test
    public void 롬북_기능_테스트(){
        //given
        String name = "test";
        int amount = 1000;

        //when
        HelloResponseDto dto = new HelloResponseDto(name,amount);

        //then
        assertThat(dto.getName()).isEqualTo(name); // assertThat은 검증 라이브러리리
        assertThat(dto.getAmount()).isEqualTo(amount);
    }
}
// Junit과 비교하여 assertj의 장점은 담은과 같음
// CoreMatchers와 달리 추가적으로 라이브러리가 필요하지 않음
// 자동완성이 좀 더 확실하게 지원 됨
// 에러나서 gradle 4.10.2 버전으로 다운 그래이드 후 진행
// https://github.com/jojoldu/freelec-springboot2-webservice/issues/2

