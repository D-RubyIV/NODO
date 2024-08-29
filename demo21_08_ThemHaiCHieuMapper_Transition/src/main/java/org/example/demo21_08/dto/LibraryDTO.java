package org.example.demo21_08.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.example.demo21_08.entity.Book;

import java.util.List;
import java.util.Set;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(exclude = "bookDTOS")
public class LibraryDTO {

    private Integer id;

    private String name;

    private List<BookDTO> bookDTOS;
}
