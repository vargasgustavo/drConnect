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
@Table(name="medicos")
public class Medico {
	@Id
	@GeneratedValue
	private Integer id; 
	private String crm;
	private Especialidades especialidades;
	
	@OneToOne
	private Usuario usuario;

}
