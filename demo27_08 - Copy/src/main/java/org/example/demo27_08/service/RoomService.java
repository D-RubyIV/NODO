package org.example.demo27_08.service;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.example.demo27_08.dto.RoomDTO;
import org.example.demo27_08.entity.Room;
import org.example.demo27_08.mapper.RoomMapper;
import org.example.demo27_08.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private RoomMapper roomMapper;

    public RoomDTO createRoom(RoomDTO roomDTO) {
        // Chuyển đổi DTO sang entity
        Room room = roomMapper.DTOtoEntity(roomDTO);

        // Lưu entity vào database
        Room savedRoom = roomRepository.save(room);

        // Chuyển đổi entity lại sang DTO
        return roomMapper.entityToDTO(savedRoom);
    }
}
