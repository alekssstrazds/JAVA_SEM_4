
package lv.venta.demo.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

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
public class Grade {
    @Column(name = "IdGr")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(value=AccessLevel.NONE)
    private int idGr;
    
    @Min(0)
    @Max(10)
    @Column(name = "Value")
    private int value;
    
    @ManyToOne
    @JoinColumn(name="IdSt")
    private Student student;
    
    @ManyToOne
    @JoinColumn(name="IdCo")
    private Course course;

    public Grade(@Min(0) @Max(10) int value, Student student, Course course) {
        super();
        this.value = value;
        this.student = student;
        this.course = course;
    }
}