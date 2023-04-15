package com.example.crowdfunding.mappers;

import com.example.crowdfunding.dto.SignUpDto;
import com.example.crowdfunding.dto.UserDto;
import com.example.crowdfunding.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toUserDto(User user);

    @Mapping(target = "password", ignore = true)
    User signUpToUser(SignUpDto signUpDto);
}
