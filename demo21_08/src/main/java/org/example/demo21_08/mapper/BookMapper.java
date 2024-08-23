package org.example.demo21_08.mapper;

import lombok.Data;
import org.example.demo21_08.dto.BookDTO;
import org.example.demo21_08.entity.Book;
import org.mapstruct.AfterMapping;
import org.mapstruct.BeforeMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import org.mapstruct.AfterMapping;
import org.mapstruct.BeforeMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface BookMapper {

    @BeforeMapping
    default void beforeMapping(Book b, @MappingTarget BookDTO dto) {
        // Thực hiện các hành động trước khi ánh xạ
        b.setName("DION DEP ZAI");
        dto.setBefore("BEFORE 1");
    }
    @Mapping(target = "id", ignore = true)
    @Mapping(source = "library.name", target = "libName", defaultExpression = "java(\"Unknown\")")
    @Mapping(target = "toStr", expression = "java(e.getName() + ' ' + e.getId())")
    BookDTO eToDto(Book e);

    @AfterMapping
    default void afterMapping( @MappingTarget BookDTO dto) {
        // Thực hiện các hành động sau khi ánh xạ
        dto.setAfter("AFTER 2");
    }
}
