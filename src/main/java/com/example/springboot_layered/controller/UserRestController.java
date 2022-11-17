package com.example.springboot_layered.controller;

import com.example.springboot_layered.domain.dto.UserRequestDto;
import com.example.springboot_layered.domain.dto.UserResponseDto;
import com.example.springboot_layered.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
public class UserRestController {

    private final UserService userService;

    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> getUserApi(@PathVariable Long id){
        UserResponseDto userResponseDto = userService.getUser(id);
        return ResponseEntity.ok().body(userResponseDto);
    }

    @PostMapping("/new")
    public ResponseEntity<UserResponseDto> addUserApi(@RequestBody UserRequestDto userRequestDto){
        return ResponseEntity.ok().body(userService.addUser(userRequestDto));
    }
}