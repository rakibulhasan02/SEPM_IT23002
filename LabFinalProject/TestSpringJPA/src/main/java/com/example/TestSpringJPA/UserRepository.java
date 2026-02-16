package com.example.TestSpringJPA;


//package com.example.springdbweb;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
