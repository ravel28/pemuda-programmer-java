package com.pemudaprogrammer.users.positions.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@Table(name = "positions", schema = "public")
@AllArgsConstructor
@NoArgsConstructor
public class PositionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "position_name", nullable = false)
    private String position_name;
}
