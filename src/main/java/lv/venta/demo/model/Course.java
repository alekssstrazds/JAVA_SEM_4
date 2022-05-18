package lv.venta.demo.model;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;

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
public class Course{
	@Column(name = "IdCo")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Setter(value = AccessLevel.NONE)
	private int idPr;

	@Column(name= "Title")  
    @Pattern(regexp="[A-Z]{1}[a-z\\s]+", message="Must be first capital letter and others small")
	private String title;

	@Min(0)
	@Max(25)
	@Column(name= "Cp")
	private int cp;
	
	/*1.vienam kursam ir tikais viens pasniedzējs
	viens pret vienu
	@OneToOne
	joinColumn uz otrās klases
	@JoinColumn(name="IdPr")
	private Professor professor;*/

	/*2.vienam kursam ir viens pasniedzējs
	daudzi pret vienu
	@ManyToOne
	@JoinColumn(name="IdPr")
	private Professor professor;*/

	//3.vienam kursam ir vairāki profesori
	//daudzi pret daudziem
	@ManyToMany(mappedBy="courses")
	private Collection<Professor> professors;

	@OneToMany(mappedBy="course")
		@ToString.Exclude
		private Collection<Grade> grades;

	public Course(@Size(min = 3, max = 60) @Pattern(regexp = "[A-Z]{1}[a-z\\s]+") String title,
	@Min(0) @Max(25) int cp, Collection<Professor> professors) {
		super();
		this.title = title;
		this.cp = cp;
		this.professors = professors;
	}
}
