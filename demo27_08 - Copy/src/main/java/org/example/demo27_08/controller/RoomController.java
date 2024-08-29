package org.example.demo27_08.controller;

import org.example.demo27_08.dto.RoomDTO;
import org.example.demo27_08.dto.UserDTO;
import org.example.demo27_08.mapper.RoomMapper;
import org.example.demo27_08.repository.RoomRepository;
import org.example.demo27_08.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("rooms")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @Autowired
    private RoomMapper roomMapper;

    @Autowired
    private RoomRepository roomRepository;

    @GetMapping(value = "")
    public List<RoomDTO> findAll() {
        return roomMapper.entityToDTOs(roomRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<RoomDTO> createRoom(@RequestBody RoomDTO roomDTO) {
        RoomDTO savedRoomDTO = roomService.createRoom(roomDTO);
        return new ResponseEntity<>(savedRoomDTO, HttpStatus.CREATED);
    }
}
