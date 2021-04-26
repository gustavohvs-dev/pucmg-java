package lista7;

public class Livro {

	public String nome;
	private String autores;
	private String categoria;
	
	public Livro(String nome, String autores, String categoria) {
		
		this.nome = nome;
		this.autores = autores;
		if(setCategoria(categoria)==true) {
			System.out.println("Livro criado com sucesso: " + nome);
		}else {
			System.out.println("Categoria não encontrada, livro criado como 'sem categoria'");
		}
		
	}
	
	public boolean setCategoria(String categoria) {
		
		String[] categorias = {"Antologia", "Audiolivro", "Aventura", "Científico", "Conto", "Crônica", "Didático", "Épico", "Fantasia", "Ficção Científica", "Horror", "Ação", "Drama", "Romance"};
		
		boolean categoriaEncontrada = false;
		
		for(int i=0; i<categorias.length; i++) {
			if(categoria.equals(categorias[i])) {
				categoriaEncontrada = true;
			}
		}
		
		if(categoriaEncontrada==true) {
			this.categoria = categoria;
			return true;
		}else {
			return false;
		}
		
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public String getAutores() {
		return this.autores;
	}
	
	public String getCategoria() {
		return this.categoria;
	}
	
}
