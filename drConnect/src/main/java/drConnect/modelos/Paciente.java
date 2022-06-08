package drConnect.modelos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="pacientes")
public class Paciente {
	@Id
	@GeneratedValue
	private Integer id; 
	private String cep;
	private String numero;
	private String complemento;
	
	@OneToOne
	private Usuario usuario;

}
