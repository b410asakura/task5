package com20.task5.dto.userDto;

import com20.task5.entity.User;
import com20.task5.enums.Role;
import lombok.Builder;

@Builder
public record UserResponse(
        Long id,
        String firstName,
        String lastName,
        String email,
        String password,
        String phoneNumber,
        Role role
) {

    public static UserResponse entityToResponse(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .password(user.getPassword())
                .phoneNumber(user.getPhoneNumber())
                .role(user.getRole())
                .build();

    }
}
