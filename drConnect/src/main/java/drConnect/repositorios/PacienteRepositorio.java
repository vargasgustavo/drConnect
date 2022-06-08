package drConnect.repositorios;

import javax.persistence.EntityManager;

import drConnect.modelos.Medico;
import drConnect.modelos.Paciente;

public class PacienteRepositorio extends Repositorio<Paciente, Integer>{

	public PacienteRepositorio(EntityManager entityManager) {
		super(entityManager);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected Class<Paciente> pegaTipo() {
		// TODO Auto-generated method stub
		return Paciente.class;
	}
	

}
