package lv.venta.demo.model;
import java.util.Collection;

import javax.persistence.GenerationType;

import lombok.Setter;
@Getter
@Setter
@ToString
@NoArgsConstructor
@RequiredArgsConstructor
@Table
@Entity
public class Professor {
	@Column(name= "IdPr")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Setter(value=AccessLevel.NONE)
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
	
	//1.profesoram ir tikai viens kurss
	//viens-pet-viens
	//mappedBy uz mainigo no otras klases
	//@OneToOne(mappedBy="professor")
	//@ToString.Exclude
	//private Course course;
	//2.profesoram ir vairāki kursi
	//viens pret daudziem
	/*@OneToOne(mappedBy="professor")
	private Collection<Course> courses;*/
	//3.vienam profesoram ir vairāki kursi
	//daudzi pret daudziem
	@ManyToMany(mappedBy="professors")
	private Collection<Course> courses;
	
	
	public ProfesSor(String name, String surname, ProfDegree degree) {
		this.name = name;
		this.surname = surname;
		this.degree = degree;
	}
	
}
