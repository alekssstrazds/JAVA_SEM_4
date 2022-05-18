
package lv.venta.demo.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
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
public class Professor {
	@Column(name= "IdPr")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Setter(value = AccessLevel.NONE)
	private int idPr;

	@Column(name= "Name")
	@Size(min = 3, max = 30)        
    @Pattern(regexp="[A-Z]{1}[a-z]+", message="Must be first capital letter and others small")
	private String name;

	@Column(name= "Surname")
	@Size(min = 3, max = 30)        
    @Pattern(regexp="[A-Z]{1}[a-z]+", message="Must be first capital letter and others small")
	private String surname;

	@Column(name= "Degree")
	private ProfDegree degree;
	
	/*1.profesoram ir tikai viens kurss
	viens-pet-viens
	mappedBy uz mainigo no otras klases
	@OneToOne(mappedBy="professor")
	@ToString.Exclude
	private Course course;*/

	/*2.profesoram ir vairāki kursi
	viens pret daudziem
	@OneToOne(mappedBy="professor")
	private Collection<Course> courses;*/

	/*3.vienam profesoram ir vairāki kursi
	daudzi pret daudziem
	@ManyToMany(mappedBy="professors")
	private Collection<Course> courses;*/
	@ManyToMany
	@JoinTable(joinColumns= @JoinColumn(name="IdPr"),
	inverseJoinColumns = @JoinColumn(name="IdCo"))
	private Collection<Course> courses = new ArrayList<Course>();
	
	public void addNewCourse(Course course)
	{
		courses.add(course);
	}

	//2. get un set no lombok
	//3.1. bezargumenta konstruktors - lombok
	//3.2. argumenta konstruktors
	public Professor(String name, String surname, ProfDegree degree) {
		super();
		this.name = name;
		this.surname = surname;
		this.degree = degree;
	}
	//4.toString - lombok
}
