package com.Kurzgesagttt.AuthService.mapper;

import com.Kurzgesagttt.AuthService.model.dto.CreateUserRequestDTO;
import com.Kurzgesagttt.AuthService.model.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class UserMapper {
    @Autowired
    private ModelMapper modelMapper;

    public CreateUserRequestDTO convertToDto(User user) {
        return modelMapper.map(user, CreateUserRequestDTO.class);
    }
    public User convertToEntity(CreateUserRequestDTO userDto) {
        return modelMapper.map(userDto, User.class);
    }

}
