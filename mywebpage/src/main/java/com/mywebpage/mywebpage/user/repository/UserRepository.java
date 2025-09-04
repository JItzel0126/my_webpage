package com.mywebpage.mywebpage.user.repository;

import com.mywebpage.mywebpage.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

//    엔티티 PK(Long uno)와 로그인 기준(String email)이 서로 달라서 만들어줌
    Optional<User> findByEmail(String email);
}
