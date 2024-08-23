package org.example.demo22_08.controller;

import org.example.demo22_08.entity.Room;
import org.example.demo22_08.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "rooms")
public class RoomController {
    @Autowired
    private RoomService roomService;

    @GetMapping(value = "")
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(roomService.findAll());
    }

    @PostMapping(value = "")
    public ResponseEntity<?> save(@RequestBody Room room){
        return ResponseEntity.ok(roomService.saveRoom(room));
    }
}
