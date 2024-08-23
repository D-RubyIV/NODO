package org.example.demot3.test;

import org.example.demot3.dto.PersonDto;
import org.example.demot3.entity.mysql.Person;
//import org.example.demot3.mapper.PersonMapper;
import org.example.demot3.mapper.PersonMapper;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonMapperTest {
    private PersonMapper studentMapper = Mappers.getMapper(PersonMapper.class);
    @Test
    public void testEntityToModel() {
        Person entity = new Person();
        entity.setFirstName("John");
        entity.setId(1);
        PersonDto dto = studentMapper.toDto(entity);
        assertEquals(entity.getFirstName(), dto.getNameMapper());
        assertEquals(entity.getId(), dto.getId());
    }
    @Test
    public void testModelToEntity() {
        PersonDto dto = new PersonDto();
        dto.setId(1);
        dto.setNameMapper("John");
        Person entity = studentMapper.toEntity(dto);
        assertEquals(entity.getFirstName(), dto.getNameMapper());
        assertEquals(entity.getId(), dto.getId());
    }
}
