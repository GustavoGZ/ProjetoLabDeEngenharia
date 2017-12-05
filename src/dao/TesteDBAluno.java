package dao;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entidade.Aluno;

public class TesteDBAluno {

	public static void main(String[] args) {
		EntityManagerFactory emf = 
				Persistence.createEntityManagerFactory("ALUNOS");
		EntityManager em = emf.createEntityManager();
		
		Aluno t1 = new Aluno();
		t1.setNome("João");
		t1.setDataNascimento(new Date());

		
		em.getTransaction().begin();
		em.persist( t1 );
		em.getTransaction().commit();
		em.close();
		
		emf.close();
	}

}
