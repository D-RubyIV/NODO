package org.example.demo21_08.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;
import org.example.demo21_08.entity.Library;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(exclude = "libraryDTO")
public class BookDTO {
    private Integer id;

    private String name;

    private LibraryDTO libraryDTO;
}
