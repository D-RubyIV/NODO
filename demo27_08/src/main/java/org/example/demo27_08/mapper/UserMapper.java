package org.example.demo27_08.mapper;

import org.example.demo27_08.dto.UserDTO;
import org.example.demo27_08.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO entityToDTO(User user);
    List<UserDTO> entityToDTOs(List<User> users);
    User DTOtoEntity(UserDTO userDTO);
    List<User> DTOtoEntity(List<UserDTO> userDTO);
}
