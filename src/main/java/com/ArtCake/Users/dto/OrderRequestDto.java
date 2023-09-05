package com.ArtCake.Users.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderRequestDto {

    private Integer count;

    private String deadline;

    private String clientWishes;

}
