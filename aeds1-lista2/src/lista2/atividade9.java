package lista2;

import java.util.Scanner;

public class atividade9 {

	public static void main(String[] args) {
				
		Scanner entrada = new Scanner(System.in);
		
		int alunos;
		
		System.out.print("Informe o número de alunos: ");
		alunos = entrada.nextInt();
		
		System.out.println("A média das notas é " + mediaAlunos(alunos));
		
		entrada.close();
		
	}
	
	public static double mediaAlunos(int alunos) {
		
		Scanner entrada = new Scanner(System.in);
		
		double nota, soma=0, qnt=0, media;
			
		for(int i=0; i<alunos; i++) {
			System.out.print("Informe a média do aluno: ");
			nota = entrada.nextDouble();
			soma += nota;
			qnt += 1;
		}
		
		media = soma/qnt;
		
		entrada.close();
		
		return media;
				
	}
	
}
