import org.springframework.boot.SpringApplication;
import  org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication //스프링부트 자동설정
public class Aplication {
    public static void main(String[] args){
        SpringApplication.run(Aplication.class,args); //SpringApplication.run으로 내장 WAS서버 실행
    }
}
