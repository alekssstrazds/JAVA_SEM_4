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
	
	public ProfesSor(String name, String surname, ProfDegree degree) {
		this.name = name;
		this.surname = surname;
		this.degree = degree;
	}
	
}
