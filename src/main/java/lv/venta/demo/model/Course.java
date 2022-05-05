package lv.venta.demo.model;

import javax.persistence.GenerationType;

import lombok.Setter;

@Getter
@Setter
@ToString
@NoArgsConstructor
@RequiredArgsConstructor
@Table
@Entity
public class Course {
	@Column(name= "IdCo")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Setter(value=AccessLevel.NONE)
	private int idPr;
	@Column(name= "Title")  
    @Pattern(regexp="[A-Z]{1}[a-z\\s]+", message="Must be first capital letter and others small")
	private String title;
	@Min(0)
	@Max(25)
	@Column(name= "Cp")
	private int cp;
	
	//1.vienam kursam ir tikais viens pasniedzējs
	//viens pret vienu
	//@OneToOne
	//joinColumn uz otrās klases
	//@JoinColumn(name="IdPr")
	//private Professor professor;
	//2.vienam kursam ir viens pasniedzējs
	//daudzi pret vienu
	/*@ManyToOne
	@JoinColumn(name="IdPr")
	private Professor professor;*/
	//3.vienam kursam ir vairāki profesori
	//daudzi pret daudziem
	@ManyToMany
	@JoinTable(name="Prof_Course", joinColumns = @JoinColumn(name="IdPr"),
	inverseJoinColumns=@JoinColumn(name="IdCo"))
	private Collection<Professor> professors;
}
