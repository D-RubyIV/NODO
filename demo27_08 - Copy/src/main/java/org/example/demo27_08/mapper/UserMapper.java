package org.example.demo27_08.mapper;

import org.example.demo27_08.dto.UserDTO;
import org.example.demo27_08.entity.User;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @BeforeMapping
    default void before(User user) {
        // Đặt logic nếu cần
    }

    @Mapping(target = "roomDTO", source = "room")
    UserDTO entityToDTO(User user);
    List<UserDTO> entityToDTOs(List<User> users);

    @Mapping(target = "room", source = "roomDTO")
    User DTOtoEntity(UserDTO userDTO);

    List<User> DTOtoEntity(List<UserDTO> userDTO);

    @AfterMapping
    default void after(@MappingTarget UserDTO userDTO, User user) {
        // Đặt logic nếu cần
    }
}
