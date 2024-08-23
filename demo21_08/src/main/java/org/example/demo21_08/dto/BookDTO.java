package org.example.demo21_08.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookDTO {
    private Integer id;
    private String name;
    private String libName;
    private String toStr;
    private String before;
    private String after;
}
