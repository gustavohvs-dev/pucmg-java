
public class Livro extends Publicacao {

	private String autores;
	private String edicao;
	
	public Livro(String titulo, String editora, int anoPublicacao, double valorVenda, String autores, String edicao) {
		setTitulo(titulo);
		setEditora(editora);
		setAnoPublicacao(anoPublicacao);
		setValorVenda(valorVenda);
		this.autores = autores;
		this.edicao = edicao;
	}
	
	public String getAutores() {
		return autores;
	}
	
	public String getEdicao() {
		return edicao;
	}
	
	public void dadosLivro() {
		System.out.println("Título: " + getTitulo());
		System.out.println("Editora: " + getEditora());
		System.out.println("Ano de publicação: " + getAnoPublicacao());
		System.out.println("Valor de venda: " + getValorVenda());
		System.out.println("Autores: " + getAutores());
		System.out.println("Edição: " + getEdicao());
	}
	
}
