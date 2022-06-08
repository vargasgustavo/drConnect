package drConnect.modelos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="usuarios")

public class Usuario {
	@Id
	@GeneratedValue
	private Integer id;
	private String nome;
	@Column(unique=true)
	private String email;
	private String telefone;
	private String password;
	private TipoUsuario tipoUsuario;

}
