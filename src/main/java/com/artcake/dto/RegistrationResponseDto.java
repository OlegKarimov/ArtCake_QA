package com.artcake.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class RegistrationResponseDto {
    private int id;
    private String fullName;
    private String email;
    private String address;
    private String phoneNumber;
    private String role;
    private String state;

}
