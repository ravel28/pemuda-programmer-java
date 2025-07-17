package com.pemudaprogrammer.stock_management.outbond.entities;

import com.pemudaprogrammer.users.users.entities.UserEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.Immutable;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
@Builder
@Table(name = "outbond", schema = "public")
@NoArgsConstructor
@AllArgsConstructor
public class OutbondEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "outbond_number")
    private String outbond_number;

    @Column(name = "outbond_data", nullable = false)
    private LocalDate outbond_date;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "description", columnDefinition = "text")
    private String description;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user_id;

    @CreationTimestamp
    @Column(name= "created_at", nullable = false, updatable = false)
    private Date created_at;

    @UpdateTimestamp
    @Column(name= "updated_at", nullable = false)
    private Date updated_at;
}
