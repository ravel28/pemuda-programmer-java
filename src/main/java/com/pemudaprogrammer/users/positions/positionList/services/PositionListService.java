package com.pemudaprogrammer.users.positions.positionList.services;

import com.pemudaprogrammer.cores.dtos.FilterPaginationDto;
import com.pemudaprogrammer.users.positions.entities.PositionEntity;
import com.pemudaprogrammer.users.positions.positionList.dtos.CreateUpdatePositionDto;
import com.pemudaprogrammer.users.positions.repositories.PositionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class PositionListService {
    private final PositionRepository positionRepository;

    @Autowired
    public PositionListService (
            PositionRepository positionRepository
    ){
        this.positionRepository = positionRepository;
    }

    public PositionEntity createPosition(CreateUpdatePositionDto createPositionDto){
        PositionEntity createPosition = PositionEntity.builder()
                .position_name(createPositionDto.getPosition_name())
                .build();
        return positionRepository.save(createPosition);
    }

    public List<PositionEntity> getPosition (FilterPaginationDto filterPaginationDto){
        Pageable pageable = PageRequest.of(filterPaginationDto.getCurrent_page(), filterPaginationDto.getTake());
        Page<PositionEntity> pageResult = positionRepository.findAll(pageable);
        return pageResult.getContent();
    }

    public PositionEntity updatePositionName(Integer id,CreateUpdatePositionDto updatePositionDto) {
        PositionEntity createPosition = PositionEntity.builder()
                .position_name(updatePositionDto.getPosition_name())
                .build();
        return positionRepository.save(createPosition);
    }
}
