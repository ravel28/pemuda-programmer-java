package com.pemudaprogrammer.users.users.userList.dtos;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CreateUpdateUserDto {
    private LocalDate birthdate;
    private String email;
    private LocalDate fired_date;
    private String full_name;
    private Boolean is_active;
    private Integer position_id;
}
