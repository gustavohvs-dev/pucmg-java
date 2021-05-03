package lista10;

public class IngressoVIP extends IngressoPromocional {
	
	private double valorIngresso;
	
	public IngressoVIP(String nome, String cpf, double valorIngresso){
		setNome(nome);
		setCpf(cpf);
		setValorIngresso(valorIngresso);
	}
	
	public void setValorIngresso(double param) {
		if(param>=20) {
			this.valorIngresso = param;
		}else {
			System.out.println("Erro ao definir valor de ingresso, valor mínimo de 20 reais");
		}
	}
	
	public double getValorIngresso() {
		return this.valorIngresso;
	}

}
