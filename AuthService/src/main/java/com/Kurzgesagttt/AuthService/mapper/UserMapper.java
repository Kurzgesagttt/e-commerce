package com.Kurzgesagttt.AuthService.mapper;

import com.Kurzgesagttt.AuthService.model.dto.UserRequestDTO;
import com.Kurzgesagttt.AuthService.model.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class UserMapper {
    @Autowired
    private ModelMapper modelMapper;

    public UserRequestDTO convertToDto(User user) {
        return modelMapper.map(user, UserRequestDTO.class);
    }
    public User convertToEntity(UserRequestDTO userDto) {
        return modelMapper.map(userDto, User.class);
    }

}
