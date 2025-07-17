package com.pemudaprogrammer.users.users.repositories;

import com.pemudaprogrammer.users.users.entities.ViewUsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ViewUserRepository extends JpaRepository<ViewUsersEntity, Integer> {
}
