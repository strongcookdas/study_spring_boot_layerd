package com.example.springboot_layered.domain.entity;

import com.example.springboot_layered.domain.dto.user.UserResponseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String password;

    public User(String name, String password){
        this.name = name;
        this.password = password;
    }

    public UserResponseDto toResponse(){
        return new UserResponseDto(this.id,this.name,"");
    }
}
