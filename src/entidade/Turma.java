package entidade;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Turma implements Serializable {
	private static final long serialVersionUID = 1733893507737561217L;
	@Id
	private int quantidade;
	private String nome;

}
