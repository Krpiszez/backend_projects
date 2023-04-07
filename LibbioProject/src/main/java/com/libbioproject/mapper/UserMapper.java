package com.libbioproject.mapper;

import com.libbioproject.domain.User;
import com.libbioproject.dto.UserDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel="spring")
public interface UserMapper {

    UserDTO userToDTO(User user);

    List<UserDTO> userListToDTOList(List<User> userList);

}
