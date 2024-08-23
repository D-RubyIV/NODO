package org.example.demo22_08.service;

import org.example.demo22_08.dto.StudentDTO;
import org.example.demo22_08.entity.Student;
import org.example.demo22_08.mapper.StudentMapper;
import org.example.demo22_08.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentMapper studentMapper;

    public List<StudentDTO> findAll(){
        return studentMapper.EntityToDTOs(studentRepository.findAll());
    }

    public StudentDTO saveStudent(Student student){
        return studentMapper.EntityToDTO(studentRepository.save(student));
    }

}
