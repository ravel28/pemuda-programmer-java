package com.pemudaprogrammer.users.users.entities;

import com.pemudaprogrammer.users.positions.entities.PositionEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.util.Date;


@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users", schema = "public")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "email", unique = true, nullable = false, length = 255)
    private String email;

    @Column(name = "full_name", nullable = false, length = 255)
    private String full_name;

    @Column(name= "birthdate", nullable = false)
    private LocalDate birthdate;

    @Column(name = "is_active", nullable = false)
    private Boolean is_active = true;

    @Column(name = "fired_date")
    private LocalDate fired_date;

    @OneToOne
    @JoinColumn(name = "position_id", nullable = false)
    private PositionEntity positionEntity;

    @CreationTimestamp
    @Column(name= "created_at", nullable = false, updatable = false)
    private Date created_at;

    @UpdateTimestamp
    @Column(name= "updated_at", nullable = false)
    private Date updated_at;
}
