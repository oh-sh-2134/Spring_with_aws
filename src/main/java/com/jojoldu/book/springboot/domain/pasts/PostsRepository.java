package com.jojoldu.book.springboot.domain.pasts;

import org.springframework.data.jpa.repository.JpaRepository;
public interface PostsRepository extends JpaRepository<Posts, Long> {
}
