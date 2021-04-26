package lista7;

public class Lista7 {

	public static void main(String[] args) {
		
		Biblioteca biblioteca = new Biblioteca();
		
		System.out.println("___________________________________________________________");
		System.out.println("» Criando livros...");
		
		Livro livro1 = new Livro("Drácula", "Bram Stoker", "Horror");
		Livro livro2 = new Livro("Fundamentos de matemática", "Gelson Izz", "Didático");
		Livro livro3 = new Livro("O último teorema de Fermat", "Simon Sight", "Didático");
		Livro livro4 = new Livro("Viagem ao centro da Terra", "Júlio Verne", "Fantasia");
		Livro livro5 = new Livro("50 tons de cinza", "E.L. James", "Romance");
		
		System.out.println("___________________________________________________________");
		System.out.println("» Adicionando 5 livros a biblioteca...");
		
		biblioteca.adicionarLivro(livro1);
		biblioteca.adicionarLivro(livro2);
		biblioteca.adicionarLivro(livro3);
		biblioteca.adicionarLivro(livro4);
		biblioteca.adicionarLivro(livro5);
		
		System.out.println("___________________________________________________________");
		System.out.println("» Buscando livros existentes na biblioteca...");
		
		biblioteca.tituloLivros();
		
		System.out.println("___________________________________________________________");
		System.out.println("» Buscando o título 'Drácula'...");
		
		biblioteca.buscaLivro("Drácula");
		
		System.out.println("___________________________________________________________");
		System.out.println("» Buscando número de livros na biblioteca...");
		
		biblioteca.numeroLivros();
		
		System.out.println("___________________________________________________________");
		System.out.println("» Excluindo dois livros...");
		
		biblioteca.removerLivro(livro1);
		biblioteca.removerLivro(livro5);
		
		System.out.println("___________________________________________________________");
		System.out.println("» Buscando número de vagas de livro na biblioteca...");
		
		biblioteca.vagasLivros();
		
		System.out.println("___________________________________________________________");
		System.out.println("» Incluindo um livro...");
		
		biblioteca.adicionarLivro(livro1);
		
		System.out.println("___________________________________________________________");
		System.out.println("» Buscando livros didáticos...");
		
		System.out.println(biblioteca.tituloLivrosCategoria("Didático"));
		
		System.out.println("___________________________________________________________");
		System.out.println("» Buscando livros existentes na biblioteca...");
		
		System.out.println(biblioteca.tituloLivros());
	}

}
