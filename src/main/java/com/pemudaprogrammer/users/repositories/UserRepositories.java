package com.pemudaprogrammer.users.repositories;

import com.pemudaprogrammer.users.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositories extends JpaRepository<UserEntity, Integer> {
}