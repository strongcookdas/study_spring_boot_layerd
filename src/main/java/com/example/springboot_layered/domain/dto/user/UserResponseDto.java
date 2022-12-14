package com.example.springboot_layered.domain.dto.user;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UserResponseDto {

    private Long id;
    private String name;
    private String message;

}
