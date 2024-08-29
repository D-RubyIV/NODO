package org.example.demo21_08.mapper;


import org.example.demo21_08.dto.BookDTO;
import org.example.demo21_08.dto.LibraryDTO;
import org.example.demo21_08.entity.Book;
import org.example.demo21_08.entity.Library;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring", uses = BookMapper.class)
public interface LibraryMapper {

    @Mapping(target = "bookDTOS", source = "books")
    LibraryDTO entityToDTO(Library e);
    List<LibraryDTO> entityToDTOs(List<Library> list);


    @Mapping(target = "books", source = "bookDTOS")
    Library DTOtoEntity(LibraryDTO dto);
    List<Library> DTOsToEntities(List<LibraryDTO> dtoList);

    @AfterMapping
    default void afterHoaDonDTOToHoaDon(@MappingTarget Library library){
        library.getBooks().forEach(s -> {
            s.setLibrary(library);
        });
    }

}
