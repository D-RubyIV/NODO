package org.example.demo22_08.mapper;

import jakarta.persistence.Entity;
import org.example.demo22_08.dto.RoomDTO;
import org.example.demo22_08.dto.UserDTO;
import org.example.demo22_08.entity.Room;
import org.example.demo22_08.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = StudentMapper.class)
public interface RoomMapper {
//    @Mapping(target = "studentDTOS", source = "students")
    RoomDTO entityToDTO(Room room);

    List<RoomDTO> entityToDTOs(List<Room> rooms);
}
