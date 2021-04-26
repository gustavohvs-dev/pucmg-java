
public class Revista extends Publicacao {
	
	private int numero;
	private String mesPublicacao;
	
	public Revista(String titulo, String editora, int anoPublicacao, double valorVenda, int numero, String mesPublicacao) {
		setTitulo(titulo);
		setEditora(editora);
		setAnoPublicacao(anoPublicacao);
		setValorVenda(valorVenda);
		this.numero = numero;
		this.mesPublicacao = mesPublicacao;
	}
	
	public int getNumero() {
		return numero;
	}
	
	public String getMesPublicacao() {	
		return mesPublicacao;
	}
	
	public void dadosRevista() {
		System.out.println("T�tulo: " + getTitulo());
		System.out.println("Editora: " + getEditora());
		System.out.println("Ano de publica��o: " + getAnoPublicacao());
		System.out.println("Valor de venda: " + getValorVenda());
		System.out.println("N�mero: " + getNumero());
		System.out.println("M�s da publica��o: " + getMesPublicacao());
	}

}
