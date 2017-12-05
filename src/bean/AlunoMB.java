package bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import org.primefaces.model.chart.PieChartModel;

import dao.AlunoDAO;
import dao.AlunoDAOImpl;
import entidade.Aluno;

@ManagedBean
@SessionScoped
public class AlunoMB implements Serializable {
	private static final long serialVersionUID = -3009074750360499144L;
	private List<Aluno> alunos = new ArrayList<Aluno>();
	private AlunoDAO tDAO = new AlunoDAOImpl();
	private PieChartModel grafico = new PieChartModel();

	private Aluno alunoAtual = new Aluno();

	public Aluno getAlunoAtual() {
		return alunoAtual;
	}
	public void setAlunoAtual(Aluno alunoAtual) {
		this.alunoAtual = alunoAtual;
	}
	
	public List<Aluno> getAlunos() {
		return alunos;
	}
	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}
	
	public PieChartModel getGrafico() {
		return grafico;
	}
	public void setGrafico(PieChartModel grafico) {
		this.grafico = grafico;
	}
	
	public String adicionar() {
		tDAO.adicionar( alunoAtual );
		alunoAtual = new Aluno();
		FacesMessage msg = new FacesMessage("Aluno adicionado");
		FacesContext.getCurrentInstance().addMessage( null, msg);
		return "";
	}
	
	public void validaData(FacesContext fc, UIComponent ui, Object o) { 
		Date d = (Date) o;
		Calendar cal = Calendar.getInstance();
		cal.setTime( d );
		if (cal.get(Calendar.YEAR) >= 2012) { 
			FacesMessage msg = new FacesMessage("O aluno deve ter ao menos 5 anos");
			throw new ValidatorException( msg );
		}
	}
	
	public String pesquisar() { 
		setAlunos(tDAO.pesquisar( alunoAtual.getNome() ));
		FacesMessage msg = new FacesMessage("Pesquisa efetuada, foram encontrados " + getAlunos().size() + "alunos");
		FacesContext.getCurrentInstance().addMessage( null, msg);
		if (getAlunos().size() > 0) { 
			alunoAtual = getAlunos().get(0);
		}
		
		return "";
	}
}
