package drConnect.repositorios;

import javax.persistence.EntityManager;

import drConnect.modelos.Medico;

public class MedicoRepositorio extends Repositorio<Medico, Integer>{

	public MedicoRepositorio(EntityManager entityManager) {
		super(entityManager);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected Class<Medico> pegaTipo() {
		// TODO Auto-generated method stub
		return Medico.class;
	}
	

}
