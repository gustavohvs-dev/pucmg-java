
public class Jornal extends Publicacao {
	
	private int dia;
	private String mes;
	
	public Jornal(String titulo, String editora, int anoPublicacao, double valorVenda, int dia, String mes) {
		setTitulo(titulo);
		setEditora(editora);
		setAnoPublicacao(anoPublicacao);
		setValorVenda(valorVenda);
		this.dia = dia;
		this.mes = mes;
	}
	
	public int getDia() {
		return dia;
	}
	
	public String getMes() {
		return mes;
	}
	
	public void dadosJornal() {
		System.out.println("T�tulo: " + getTitulo());
		System.out.println("Editora: " + getEditora());
		System.out.println("Ano de publica��o: " + getAnoPublicacao());
		System.out.println("Valor de venda: " + getValorVenda());
		System.out.println("Dia da publica��o: " + getDia());
		System.out.println("M�s da publica��o: " + getMes());
	}

}
