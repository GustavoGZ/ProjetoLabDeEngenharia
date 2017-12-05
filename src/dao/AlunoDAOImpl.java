package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import entidade.Aluno;

public class AlunoDAOImpl implements AlunoDAO {
	
	private EntityManagerFactory emf;

	public AlunoDAOImpl() { 
		emf = Persistence.createEntityManagerFactory("ALUNOS");
	}

	@Override
	public void adicionar(Aluno t) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist( t );
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public List<Aluno> pesquisar(String nome) {
		EntityManager em = emf.createEntityManager();
		TypedQuery<Aluno> qry = em.createQuery(
				"select t from Aluno t where t.nome like :n", 
				Aluno.class);
		qry.setParameter("n", "%" + nome + "%");
		List<Aluno> lista = qry.getResultList();
		em.close();
		return lista;
	}

}
