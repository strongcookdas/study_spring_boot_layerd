package com.example.springboot_layered.service;

import com.example.springboot_layered.domain.dto.UserRequestDto;
import com.example.springboot_layered.domain.dto.UserResponseDto;
import com.example.springboot_layered.domain.entity.User;
import com.example.springboot_layered.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponseDto getUser(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isEmpty()) {
            return new UserResponseDto(id, "", "해당 id의 user가 없습니다.");
        } else {
            return userOptional.get().toResponse();
        }
    }

    public UserResponseDto addUser(UserRequestDto userRequestDto) {
        User user = userRequestDto.toEntity();
        if(userRepository.findByName(user.getName()).isEmpty()) {
            user = userRepository.save(user);
            return userRepository.findById(user.getId()).get().toResponse();
        }else {
            log.info(userRepository.findByName(user.getName()).get().toString());
            return new UserResponseDto(user.getId(), user.getName(), "해당 user는 이미 가입되었습니다");
        }
    }
}
