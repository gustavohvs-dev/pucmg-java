package lista3;

import java.util.Scanner;

public class atividade4 {

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		
		int[] vetor = new int[10];
		int num;
		
		System.out.print("Informe um número: ");
		num = entrada.nextInt();
		
		preenche(vetor);
		
		System.out.print("O número " + num + " apareceu " + analisar(vetor, num) + " vezes no vetor informado.");
		
		entrada.close();

	}
	
	public static void preenche(int[] vetor) {
		Scanner entrada = new Scanner(System.in);
		for (int ln=0; ln<vetor.length; ln++)
		{
			System.out.print("Digite:");
			vetor[ln] = entrada.nextInt();
		}
		entrada.close();
		
	}
	
	public static int analisar(int[] vetor, int num) {
		
		int resultado = 0;
		for (int ln=0; ln<vetor.length; ln++)
		{
			if(vetor[ln]==num)
			{
				resultado += 1;
			}
		}
		return resultado;
		
	}

}
