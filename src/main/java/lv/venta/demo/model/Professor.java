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
	private String name;
	@Column(name= "Surname")
	private String surname;
	@Column(name= "Degree")
	private ProfDegree degree;
	
	public ProfesSor(String name, String surname, ProfDegree degree) {
		this.name = name;
		this.surname = surname;
		this.degree = degree;
	}
	
}
