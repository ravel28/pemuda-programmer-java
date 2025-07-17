package com.pemudaprogrammer.users.users.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Subselect;
import org.springframework.data.annotation.Immutable;

import java.time.LocalDate;

@Data
@Entity
@Immutable
@Subselect("SELECT * FROM view_users")
@Table(name = "view_users", schema = "public")
public class ViewUsersEntity {
    @Id
    @Column(name = "id_user")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "birthdate")
    private LocalDate birthdate;

    @Column(name = "is_active")
    private Boolean is_active;

    @Column(name = "position_name")
    private String position_name;
}
