package org.example.demo_20_08.mapper;

import org.example.demo_20_08.dto.UsersDTO;
import org.example.demo_20_08.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {
//    @BeforeMapping
//    default void before(User user){
//    }

    @Mapping(target = "role", source = "role.name")
    UsersDTO entityToUserDto(User u);
}
