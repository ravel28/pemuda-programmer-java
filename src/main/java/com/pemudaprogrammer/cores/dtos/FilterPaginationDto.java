package com.pemudaprogrammer.cores.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class FilterPaginationDto {
    @Min(10)
    private Integer take;

    @Min(value=1, message = "current_page minimal 1")
    private Integer current_page;
}