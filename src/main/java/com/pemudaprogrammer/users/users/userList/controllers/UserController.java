package com.pemudaprogrammer.users.users.userList.controllers;

import com.pemudaprogrammer.cores.dtos.FilterPaginationDto;
import com.pemudaprogrammer.cores.entities.ApiResponseEntity;
import com.pemudaprogrammer.users.users.userList.dtos.CreateUpdateUserDto;
import com.pemudaprogrammer.users.users.userList.services.UserSevice;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {
    private final UserSevice userSevice;

    @Autowired
    public UserController (UserSevice userSevice){
        this.userSevice =  userSevice;
    }

    @PostMapping()
    public ResponseEntity<?> createUser(@RequestBody CreateUpdateUserDto createUser) {
        return new ApiResponseEntity<>(userSevice.createUser(createUser))
                .toResponseCreated();
    }

    @GetMapping()
    public ResponseEntity<?> getUsersList(@Valid @ModelAttribute FilterPaginationDto filterPaginationDto){
        filterPaginationDto.setCurrent_page(filterPaginationDto.getCurrent_page() - 1);
        return new ApiResponseEntity<>(userSevice.getList(filterPaginationDto)).toResponseOk();
    }
}
