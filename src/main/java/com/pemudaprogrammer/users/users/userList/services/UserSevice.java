package com.pemudaprogrammer.users.users.userList.services;

import com.pemudaprogrammer.cores.dtos.FilterPaginationDto;
import com.pemudaprogrammer.product_list.brands.entities.ViewBrandEntity;
import com.pemudaprogrammer.users.positions.entities.PositionEntity;
import com.pemudaprogrammer.users.positions.repositories.PositionRepository;
import com.pemudaprogrammer.users.users.entities.UserEntity;
import com.pemudaprogrammer.users.users.entities.ViewUsersEntity;
import com.pemudaprogrammer.users.users.repositories.UserRepository;
import com.pemudaprogrammer.users.users.repositories.ViewUserRepository;
import com.pemudaprogrammer.users.users.userList.dtos.CreateUpdateUserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Slf4j
@Service
public class UserSevice {
    private final UserRepository userRepository;
    private final ViewUserRepository viewUserRepository;
    private final PositionRepository positionRepository;

    @Autowired
    public UserSevice(UserRepository userRepository, ViewUserRepository viewUserRepository, PositionRepository positionRepository){
        this.userRepository = userRepository;
        this.viewUserRepository = viewUserRepository;
        this.positionRepository = positionRepository;
    }

    public UserEntity createUser (CreateUpdateUserDto createUserDto){
        PositionEntity findPosition = this.positionRepository.findById(createUserDto.getPosition_id())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Position not found"));

        UserEntity createUser = UserEntity.builder()
                .birthdate(createUserDto.getBirthdate())
                .email(createUserDto.getEmail())
                .full_name(createUserDto.getFull_name())
                .is_active(true)
                .positionEntity(findPosition)
                .build();
        return userRepository.save(createUser);
    }

    public List<ViewUsersEntity> getList(FilterPaginationDto filterPaginationDto) {
        Pageable pageable = PageRequest.of(filterPaginationDto.getCurrent_page(), filterPaginationDto.getTake());
        Page<ViewUsersEntity> pageResult = viewUserRepository.findAll(pageable);
        return pageResult.getContent();
    }
}
