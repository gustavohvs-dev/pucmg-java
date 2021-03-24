package lista2;

import java.util.Scanner;

public class atividade2 {

	public static void main(String[] args) {
		
		 pesquisaGoverno();

	}
	
	public static void pesquisaGoverno() {
		
		Scanner entrada = new Scanner(System.in);
		
		double idade, filhos;
		double somaIdade=0, somaFilhos=0, qntIdade=0, qntFilhos=0;
		double mediaIdade, mediaFilhos;
		char pessoa='S';
		
		while((pessoa=='S')||(pessoa=='s')) {
			System.out.print("Insira sua idade: ");
			idade = entrada.nextDouble();
			System.out.print("Insira a quantidade de filhos: ");
			filhos = entrada.nextDouble();
			if((idade>=0)&&(filhos>=0)) {
				somaIdade += idade;
				somaFilhos += filhos;
				qntIdade += 1;
				qntFilhos += 1;
				System.out.print("Inserir uma nova pessoa a pesquisa (S- Sim, N- Não):");
				pessoa = entrada.next().charAt(0);
			}else {
				System.out.println("Dados inválidos inseridos! Insira novamente");
			}
		}
		
		mediaIdade = somaIdade / qntIdade;
		mediaFilhos = somaFilhos / qntFilhos;
		
		System.out.println("Média de idade do grupo pesquisado: " + mediaIdade);
		System.out.println("Média de quantidade de filhos do grupo pesquisado: " + mediaFilhos);
	
		entrada.close();
	}
	
}
