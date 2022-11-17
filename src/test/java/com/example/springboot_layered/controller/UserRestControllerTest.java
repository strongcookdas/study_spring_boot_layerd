package com.example.springboot_layered.controller;

import com.example.springboot_layered.domain.dto.UserResponseDto;
import com.example.springboot_layered.service.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserRestController.class)
class UserRestControllerTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    UserService userService;

    @Test
    @DisplayName("해당 id를 가진 user가 잘 출력되는지 테스트")
    void getUserTest() throws Exception
    {

        Long id = 1l;

        given(userService.getUser(id)).willReturn(new UserResponseDto(id,"홍길동","등록되었습니다."));

        mockMvc.perform(get("/api/v1/user/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.message").value("등록되었습니다."))
                .andDo(print());
    }

    @Test
    @DisplayName("해당 id인 정보가 없을 때의 테스트")
    void getUserFail()throws Exception {
        given(userService.getUser(25l)).willReturn(new UserResponseDto(null,"","해당 id가 없습니다."));

        mockMvc.perform(get("/api/v1/user/25"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").isEmpty())
                .andExpect(jsonPath("$.message").value("해당 id가 없습니다."))
                .andDo(print());
    }
}