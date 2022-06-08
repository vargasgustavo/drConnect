package drConnect.repositorios;


import java.util.List;

import javax.persistence.EntityManager;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class Repositorio<T, U> {
   
    protected EntityManager entityManager;
   
    protected abstract Class<T> pegaTipo();
   
    public T salva(T objeto){
        entityManager.getTransaction().begin();  // inicia transacao
        entityManager.persist(objeto);             // cria uma nova entrada na tabela
        entityManager.getTransaction().commit(); // confirma transacao (manda pro banco)
        return objeto;
    }
   
    public void atualiza(T objeto, U id){
        entityManager.getTransaction().begin(); // inicia transacao
        entityManager.merge(objeto);            // update dessa entrada na tabela
        entityManager.getTransaction().commit(); // confirma transacao (manda pro banco)
    }
   
    public void deletaPorId(U id){
        T objetoDoBanco = entityManager.find(pegaTipo(), id); // pega do banco por Id
        entityManager.getTransaction().begin(); // inicia transacao
        entityManager.remove(objetoDoBanco);    // deleta essa entrada na tabela
        entityManager.getTransaction().commit(); // confirma transacao (manda pro banco)
    }
   
    public T pegaPorId(U id){
        return  entityManager.find(pegaTipo(), id);  // pega por Id
    }
   
    public List<T> pegaLista(){
        return entityManager.createQuery("select a from "+pegaTipo().getSimpleName() + " a",
                pegaTipo()
            ).getResultList();   // pega resultado como lista
    }

}