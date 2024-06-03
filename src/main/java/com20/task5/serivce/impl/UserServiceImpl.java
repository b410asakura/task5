package com20.task5.serivce.impl;

import com20.task5.dto.SimpleResponse;
import com20.task5.dto.userDto.UserRequest;
import com20.task5.dto.userDto.UserResponse;
import com20.task5.entity.User;
import com20.task5.enums.Role;
import com20.task5.globalException.NotFoundException;
import com20.task5.repository.UserRepository;
import com20.task5.serivce.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    @Override
    public List<UserResponse> getAll() {
        return userRepository.getAll();
    }

    @Override
    public UserResponse getById(Long id) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new NotFoundException("User not found with id " + id)
        );
        return UserResponse.entityToResponse(user);
    }

    @Override
    public SimpleResponse save(UserRequest userRequest) {
        User user = userRequest.requestToEntity();
        user.setPassword(passwordEncoder.encode(userRequest.password()));
        user.setRole(Role.USER);
        userRepository.save(user);
        return SimpleResponse.builder()
                .httpStatus(HttpStatus.OK)
                .message("User saved")
                .build();
    }

    @Override
    public SimpleResponse update(Long id, UserRequest userRequest) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new NotFoundException("User not found with id " + id)
        );
        userRepository.save(userRequest.requestToEntityForUpdate(user));
        return SimpleResponse.builder()
                .httpStatus(HttpStatus.OK)
                .message("User updated with  id "+ user.getId())
                .build();
    }

    @Override
    public SimpleResponse delete(Long id) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new NotFoundException("User not found with id " + id)
        );
        userRepository.deleteById(id);
        return SimpleResponse.builder()
                .httpStatus(HttpStatus.OK)
                .message("User deleted with id " + id)
                .build();
    }
}
