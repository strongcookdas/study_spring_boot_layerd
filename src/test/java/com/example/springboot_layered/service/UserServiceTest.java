package com.example.springboot_layered.service;

import com.example.springboot_layered.domain.dto.user.UserRequestDto;
import com.example.springboot_layered.domain.dto.user.UserResponseDto;
import com.example.springboot_layered.domain.entity.User;
import com.example.springboot_layered.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

class UserServiceTest {

    private UserRepository userRepository = Mockito.mock(UserRepository.class);

    private UserService userService;

    @BeforeEach
    void setup() {
        userService = new UserService(userRepository);
    }

    @Test
    @DisplayName("회원 등록 성공 메세지가 나오는지 테스트")
    void addTest() {
        Mockito.when(userRepository.save(any())).thenReturn(new User(1l,"홍길동","0000"));

        UserResponseDto userResponseDto = userService.addUser(new UserRequestDto("홍길동","0000"));
        assertEquals("홍길동", userResponseDto.getName());
        assertEquals("등록되었습니다.", userResponseDto.getMessage());
    }
}