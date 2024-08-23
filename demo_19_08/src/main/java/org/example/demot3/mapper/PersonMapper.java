package org.example.demot3.mapper;

import org.example.demot3.dto.PersonDto;
import org.example.demot3.entity.mysql.Person;
import org.mapstruct.AfterMapping;
import org.mapstruct.BeforeMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    @BeforeMapping
    default void preparePersonForMapping(Person person) {
        person.setFirstName(person.getFirstName() + " OOOO");
    }

    @AfterMapping
    default void afterMapping(Person person) {
        System.out.println("DION HANDSOME");
    }
    // ÁNH XẠ CƠ BẢN
    // target: Chỉ định tên của thuộc tính trong đối tượng nguồn.
    // source: Chỉ định tên của thuộc tính trong đối tượng đích.
    // expression: Cho phép thực hiện ánh xạ bằng cách sử dụng một biểu thức Java.
    // Đây là một cách để tùy chỉnh ánh xạ mà không cần phải tạo một phương thức ánh xạ riêng.
    // defaultValue: Chỉ định giá trị mặc định sẽ được sử dụng cho thuộc tính đích nếu thuộc tính nguồn là null.
    // constant: Chỉ định một giá trị cố định cho thuộc tính đích, không phụ thuộc vào giá trị của thuộc tính nguồn

    @Mapping(target = "nameMapper", source = "firstName")
    @Mapping(target = "nameMapperV2", expression = "java(person.getFirstName() + ' ' + person.getAge())")
    @Mapping(target = "createAt", ignore = true)
    @Mapping(target = "status", source = "status", defaultValue = "1")
    @Mapping(target = "balance", constant = "20000.0")
    @Mapping(target = "updateAt", source = "updateAt", dateFormat = "dd-MM-yyyy")
    @Mapping(target = "levelId", source = "level.id")
    PersonDto toDto(Person person);

    @Mapping(target = "level.id", source = "levelId")
    @Mapping(target = "firstName", source = "nameMapper")
    Person toEntity(PersonDto personDto);


    //    // ÁNH XẠ TÙY CHỈNH
    @Mapping(target = "nameMapper", expression = "java(entity.getFirstName() + ' ' + entity.getAge())")
    PersonDto getModelFromEntityCustom(Person entity);

}
