package com.pemudaprogrammer.users.users.userList.dtos;

import com.pemudaprogrammer.users.positions.entities.PositionEntity;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
public class UserDto {
    private Integer id;
    private LocalDate birthdate;
    private String email;
    private LocalDate fired_date;
    private String full_name;
    private Boolean is_actibve;
    private PositionEntity positionEntity;
    private Date created_at;
    private Date updated_at;
}
