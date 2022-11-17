package com.example.springboot_layered.domain.dto;


import com.example.springboot_layered.domain.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class UserRequestDto {

    private String name;
    private String password;

    public User toEntity(){
        return new User(this.name,this.password);
    }
}
