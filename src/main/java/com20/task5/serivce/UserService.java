package com20.task5.serivce;

import com20.task5.dto.SimpleResponse;
import com20.task5.dto.userDto.UserRequest;
import com20.task5.dto.userDto.UserResponse;

import java.util.List;

public interface UserService {
    List<UserResponse> getAll();

    UserResponse getById(Long id);

    SimpleResponse save(UserRequest userRequest);

    SimpleResponse update(Long id, UserRequest userRequest);

    SimpleResponse delete(Long id);


}
