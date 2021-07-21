package lista12;

public class teste {

	public static void main(String[] args) {

		TriAtleta atleta1 = new TriAtleta("João Tavares");
		TriAtleta atleta2 = new TriAtleta("Henrico Souza");
		
		System.out.println(atleta1);	
		atleta1.correr();
		atleta1.nadar();
		atleta1.pedalar();	
		
		System.out.println();
		
		System.out.println(atleta2);	
		atleta2.correr();
		atleta2.nadar();
		atleta2.pedalar();	

	}

}
