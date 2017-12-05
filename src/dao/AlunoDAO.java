package dao;

import java.util.List;

import entidade.Aluno;

public interface AlunoDAO {
	
	void adicionar(Aluno t);
	List<Aluno> pesquisar(String nome);

}
