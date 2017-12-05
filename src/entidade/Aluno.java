package entidade;
//testando
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Aluno implements Serializable  {
private static final long serialVersionUID = 1733893507737561217L;
@Id

private String nome;
private String nomeDoResponsavel;
private String cpf;
private String endereco;
private Date dataNascimento;
private String telefone;
private  int id;

public String getNomeDoResponsavel() {
	return nomeDoResponsavel;
}
public void setNomeDoResponsavel(String nomeDoResponsavel) {
	this.nomeDoResponsavel = nomeDoResponsavel;
}

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getNome() {
	return nome;
}
public void setNome(String nome) {
	this.nome = nome;
}
public String getCpf() {
	return cpf;
}
public void setCpf(String cpf) {
	this.cpf = cpf;
}
public String getEndereco() {
	return endereco;
}
public void setEndereco(String endereco) {
	this.endereco = endereco;
}
public String getTelefone() {
	return telefone;
}
public void setTelefone(String telefone) {
	this.telefone = telefone;
}
public Date getDataNascimento() {
	return dataNascimento;
}
public void setDataNascimento(Date dataNascimento) {
	this.dataNascimento = dataNascimento;
}


}
