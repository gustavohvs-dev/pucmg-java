package lista7;

public class Biblioteca {
	
	public static final int MAXLIV = 100;
	private Livro[] livros = new Livro[MAXLIV];
	
	//Adiciona livro na biblicoteca
	public void adicionarLivro (Livro livro) {
		boolean vagaEncontrada = false;
		for(int i=0; i<MAXLIV; i++) {
			if(livros[i]==null) {
				vagaEncontrada = true;
				livros[i] = livro;
				break;
			}
		}
		if(vagaEncontrada == true) {
			System.out.println("Livro adicionado a biblioteca");
		}else {
			System.out.println("Sem espa�o na biblioteca, livro n�o adicionado");
		}
	}
	
	//Remove livro da biblioteca
	public void removerLivro (Livro livro) {
		boolean livroEncontrado = false;
		for(int i=0; i<MAXLIV; i++) {
			if(livros[i]!=null) {
				if(livros[i].getNome()==livro.getNome()) {
					livroEncontrado = true;
					livros[i] = null;
					break;
				}
			}
		}
		if(livroEncontrado == true) {
			System.out.println("Livro removido da biblioteca");
		}else {
			System.out.println("Livro n�o encontrado");
		}
	}
	
	//Retorna dados de um livro
	public void buscaLivro (String livro) {
		boolean livroEncontrado = false;
		for(int i=0; i<MAXLIV; i++) {
			if(livros[i]!=null) {
				if(livros[i].getNome()==livro) {
					livroEncontrado = true;
					System.out.println("Nome do t�tulo: " + livros[i].getNome());
					System.out.println("Autores: " + livros[i].getAutores());
					System.out.println("Categoria: " + livros[i].getCategoria());
					break;
				}
			}	
		}
		if(livroEncontrado == false) {
			System.out.println("Livro n�o encontrado");
		}
	}
	
	//Retorna t�tulo de todos os livros
	public String tituloLivros () {
		String livrosEncontrados = "";
		boolean primeiraExecucao = true;
		for(int i=0; i<MAXLIV; i++) {
			if(livros[i]!=null) {
				if(primeiraExecucao==true) {
					livrosEncontrados += livros[i].getNome();
					primeiraExecucao = false;
				}else {
					livrosEncontrados += " ; " + livros[i].getNome();
				}
			}
		}
		return livrosEncontrados;
	}
	
	//Retorna t�tulo de livros de uma determinada categoria
	public String tituloLivrosCategoria (String categoria) {
		String livrosEncontrados = "";
		boolean primeiraExecucao = true;
		for(int i=0; i<MAXLIV; i++) {
			if(livros[i]!=null) {
				if(livros[i].getCategoria()==categoria) {
					if(primeiraExecucao==true) {
						livrosEncontrados += livros[i].getNome();
						primeiraExecucao = false;
					}else {
						livrosEncontrados += " ; " + livros[i].getNome();
					}
				}
			}	
		}
		return livrosEncontrados;
	}
	
	//Retorna n�mero de livros na biblioteca
	public void numeroLivros () {
		int numLivros = 0;
		for(int i=0; i<MAXLIV; i++) {
			if(livros[i]!=null) {
				numLivros += 1;
			}
		}
		System.out.println("N�mero de livros na biblioteca: " + numLivros);
	}
	
	//Retorna quantidade de espa�os dispon�veis
	public void vagasLivros () {
		int numVagas = 0;
		for(int i=0; i<MAXLIV; i++) {
			if(livros[i]==null) {
				numVagas += 1;
			}
		}
		System.out.println("N�mero de vagas para livro na biblioteca: " + numVagas);
	}
	

}
