package org.example.demo27_08.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "library")
@Table(name = "libraries", uniqueConstraints = @UniqueConstraint(columnNames = {"code"}))
public class Library {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String code;

    private String name;



    // LAZY
//Hibernate: select l1_0.id,l1_0.code,l1_0.name from libraries l1_0 where l1_0.id=?
//Library(id=1, code=LBs, name=Library 1)
//Hibernate: select b1_0.library_id,b1_0.id,b1_0.code,b1_0.name,b1_0.price from books b1_0 where b1_0.library_id=?
//[Book(id=2, code=BOK2, name=Book 2, price=20, library=Library(id=1, code=LBs, name=Library 1)), Book(id=1, code=BOK1, name=Book 1, price=20, library=Library(id=1, code=LBs, name=Library 1)), Book(id=3, code=BOK3, name=Book 3, price=20, library=Library(id=1, code=LBs, name=Library 1))]


    // EAGER
//Hibernate: select l1_0.id,b1_0.library_id,b1_0.id,b1_0.code,b1_0.name,b1_0.price,l1_0.code,l1_0.name from libraries l1_0 left join books b1_0 on l1_0.id=b1_0.library_id where l1_0.id=?
//Library(id=1, code=LBs, name=Library 1)
//[Book(id=1, code=BOK1, name=Book 1, price=20, library=Library(id=1, code=LBs, name=Library 1)), Book(id=2, code=BOK2, name=Book 2, price=20, library=Library(id=1, code=LBs, name=Library 1)), Book(id=3, code=BOK3, name=Book 3, price=20, library=Library(id=1, code=LBs, name=Library 1))]


    @JsonManagedReference
    @ToString.Exclude
    @OneToMany(mappedBy = "library", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Book> books;
}

