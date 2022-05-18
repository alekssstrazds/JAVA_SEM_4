package lv.venta.demo.model;


import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Table
@Entity
public class Student {
    @Column(name = "IdSt")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(value=AccessLevel.NONE)
    private int idSt;
    
    @Column(name = "Name")
    @Size(min = 3, max = 30)
    @Pattern(regexp = "[A-Z]{1}[a-z]+", message="Must be first capital letter and others small")
    private String name;
    
    @Column(name = "Surname")
    @Size(min = 3, max = 30)
    @Pattern(regexp = "[A-Z]{1}[a-z]+", message="Must be first capital letter and others small")
    private String surname;
    
    @OneToMany(mappedBy="student")
    @ToString.Exclude
    private Collection<Grade> grades;

    public Student(
            @Size(min = 3, max = 30) @Pattern(regexp = "[A-Z]{1}[a-z]+", message = "Must be first capital letter and others small") String name,
            @Size(min = 3, max = 30) @Pattern(regexp = "[A-Z]{1}[a-z]+", message = "Must be first capital letter and others small") String surname) {
        super();
        this.name = name;
        this.surname = surname;
    }      
}