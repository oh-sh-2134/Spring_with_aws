package com.jojoldu.book.springboot.domain.pasts;

import lombok.Builder;
import lombok.Getter;
// 롬북의 어노테이션
import lombok.NoArgsConstructor;
// 롬북의 어노테이션

import javax.persistence.*;

@Table(name = "Posts")
@Getter
@NoArgsConstructor// 기본 생성자 자동 생성 -> public Posts(){} 같음
@Entity // JAP 어노테이션 , 테이블과 링크될 클래스임을 나타냄
public class Posts {

    @Id // 해당 테이블의 PK테이블 필드를 나타냄
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PK의 생성 규칙
    private Long id;

    @Column(length = 500, nullable = false)  // @Column : 테이블의 칼럼을 나타냄 표시안해도됨
    private String title;

    @Column(columnDefinition = "TEXT" ,nullable = false)
    private String content;

    private String author;


    @Builder // 빌터 패턴 클래스를 생성
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content)
    {
        this.title = title;
        this.content = content;
    }
}
