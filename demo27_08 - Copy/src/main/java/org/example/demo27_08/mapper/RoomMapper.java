package org.example.demo27_08.mapper;

import org.example.demo27_08.dto.RoomDTO;
import org.example.demo27_08.entity.Room;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = UserMapper.class)
public interface RoomMapper {
    @Mapping(target = "userDTOs", source = "users")
    RoomDTO entityToDTO(Room room);
    List<RoomDTO> entityToDTOs(List<Room> rooms);

    @Mapping(target = "users", source = "userDTOs")
    Room DTOtoEntity(RoomDTO roomDTO);
    List<Room> DTOtoEntity(List<RoomDTO> roomDTOs);
}
