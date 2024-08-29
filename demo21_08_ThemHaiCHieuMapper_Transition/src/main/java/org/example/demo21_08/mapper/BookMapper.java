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

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookMapper {

    @Mapping(target = "libraryDTO", source = "library")
    BookDTO entityToDTO(Book e);
    List<BookDTO> entityToDTOs(List<Book> list);


    @Mapping(target = "library", source = "libraryDTO")
    Book DTOtoEntity(BookDTO dto);
    List<Book> DTOsToEntities(List<BookDTO> bookDTOS);

}
