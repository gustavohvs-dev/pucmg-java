
public class Publicacao {
	
	private String titulo;
	private String editora;
	private int anoPublicacao;
	private double valorVenda;
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public void setEditora(String editora) {
		this.editora = editora;
	}
	
	public void setAnoPublicacao(int anoPublicacao) {
		this.anoPublicacao = anoPublicacao;
	}
	
	public void setValorVenda(double valorVenda) {
		this.valorVenda = valorVenda;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public String getEditora() {
		return editora;
	}
	
	public int getAnoPublicacao() {
		return anoPublicacao;
	}
	
	public double getValorVenda() {
		return valorVenda;
	}
	
	public void dadosPublicacao() {
		System.out.println("Título: " + getTitulo());
		System.out.println("Editora: " + getEditora());
		System.out.println("Ano de publicação: " + getAnoPublicacao());
		System.out.println("Valor de venda: " + getValorVenda());
		System.out.println("");
	}

}
