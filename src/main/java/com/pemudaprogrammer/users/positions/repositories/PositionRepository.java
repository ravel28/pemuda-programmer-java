package com.pemudaprogrammer.users.positions.repositories;

import com.pemudaprogrammer.users.positions.entities.PositionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PositionRepository extends JpaRepository<PositionEntity, Integer> {
}
