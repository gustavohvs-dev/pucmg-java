package lista11;

import java.util.Calendar;

public class Empregado extends Pessoa implements Funcionario {
	
	private int anoDeAdmissao;
	private double salarioHora;
	private double horasMes;
	
	public Empregado(String nome, int anoDeAdmissao, double salarioHora, double horasMes) {
		setNome(nome);
		this.anoDeAdmissao = anoDeAdmissao;
		this.salarioHora = salarioHora;
		this.horasMes = horasMes;
	}
	
	@Override
	public double salario() {
		return this.salarioHora * this.horasMes;
	}
	
	@Override
	public int tempoDeCasa() {
		Calendar cal = Calendar.getInstance();
		return cal.get(Calendar.YEAR) - this.anoDeAdmissao;
	}

}
