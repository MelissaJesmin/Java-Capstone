package com.devmountain.gameApp.services;

import com.devmountain.gameApp.dtos.UserDto;

import java.util.List;

public interface UserService {
    @Transactional
    List<String> addUser(UserDto userDto);

    List<String> userLogin(UserDto userDto);
}
