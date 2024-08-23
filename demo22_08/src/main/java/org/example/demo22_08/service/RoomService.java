package org.example.demo22_08.service;

import org.example.demo22_08.dto.RoleDTO;
import org.example.demo22_08.dto.RoomDTO;
import org.example.demo22_08.entity.Room;
import org.example.demo22_08.entity.Student;
import org.example.demo22_08.entity.User;
import org.example.demo22_08.mapper.RoomMapper;
import org.example.demo22_08.repository.RoomRepository;
import org.example.demo22_08.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class RoomService {
    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private RoomMapper roomMapper;

    public List<RoomDTO> findAll(){
        return roomMapper.entityToDTOs(roomRepository.findAll());
    }

    public RoomDTO saveRoom(Room room){
        Room result = roomRepository.save(room);

        Set<Student> students = new HashSet<>(room.getStudents());
        students.forEach(s -> {
            s.setRoom(result);
            studentRepository.save(s);
        });

        return roomMapper.entityToDTO(result);
    }

}
