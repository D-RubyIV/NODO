package org.example.demo22_08.mapper;

import org.example.demo22_08.dto.UserDTO;
import org.example.demo22_08.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(source = "id", target = "id")
    @Mapping(source = "username", target = "username")
    @Mapping(source = "password", target = "password")
    @Mapping(source = "roles", target = "roleDTOS")
    UserDTO entityToDTO(User user);
    List<UserDTO> entityToDTOs(List<User> user);


    @Mapping(source = "id", target = "id")
    @Mapping(source = "username", target = "username")
    @Mapping(source = "password", target = "password")
    @Mapping(source = "roleDTOS", target = "roles")
    User DTOtoEntity(UserDTO userDTO);
    List<User> DTOtoEntities(List<UserDTO> userDTOS);
}
