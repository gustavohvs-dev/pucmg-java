
public class MainExercicio10 {

	public static void main(String[] args) {
		
		Publicacao publicacoes[] = new Publicacao[4];
		
		publicacoes[0] = new Livro("Java avançado", "Editora Lucila", 2019, 80.99, "Lucila", "5");
		publicacoes[1] = new Revista("Revista Recreio", "Editora Recreio", 2002, 20.99, 45, "Janeiro");
		publicacoes[2] = new Jornal("Jornal Globo", "Jornal Global", 2008, 0.50, 5, "Fevereiro");
		publicacoes[3] = new Jornal("Jornal Belo Horizonte", "Jornal BH", 2009, 0.99, 17, "Março");
		
		publicacoes[0].dadosPublicacao();
		publicacoes[1].dadosPublicacao();
		publicacoes[2].dadosPublicacao();
		publicacoes[3].dadosPublicacao();

	}

}
