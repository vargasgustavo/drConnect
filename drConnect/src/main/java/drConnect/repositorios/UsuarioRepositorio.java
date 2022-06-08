package drConnect.repositorios;

import javax.persistence.EntityManager;

import drConnect.modelos.Medico;
import drConnect.modelos.Usuario;

public class UsuarioRepositorio extends Repositorio<Usuario, Integer>{

	public UsuarioRepositorio(EntityManager entityManager) {
		super(entityManager);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected Class<Usuario> pegaTipo() {
		// TODO Auto-generated method stub
		return Usuario.class;
	}
	

}
