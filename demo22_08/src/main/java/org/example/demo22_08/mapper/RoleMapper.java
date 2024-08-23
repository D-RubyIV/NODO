package org.example.demo22_08.mapper;

import org.example.demo22_08.dto.RoleDTO;
import org.example.demo22_08.entity.Role;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface RoleMapper {
    @BeforeMapping
    default void before(Role role) {

    }

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    RoleDTO entityToDTO(Role role);
    List<RoleDTO> entityToDTOs(List<Role> roles);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    Role DTOtoEntity(RoleDTO roleDTO);
    List<Role> DTOtoEntities(List<RoleDTO> roleDTOS);

    @AfterMapping
    default void after(@MappingTarget RoleDTO roleDTO){
//        roleDTO.setUsers(new HashSet<>());
    }
}
