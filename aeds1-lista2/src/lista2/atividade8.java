package lista2;

import java.util.Scanner;

public class atividade8 {

	public static void main(String[] args) {
				
		Scanner entrada = new Scanner(System.in);
		
		double N;
		
		System.out.print("Informe o valor de N: ");
		N = entrada.nextDouble();
		
		System.out.println(calcularFuncao(N));
		
		entrada.close();
		
	}
	
	public static double calcularFuncao(double N) {
			
		double soma = 0, tempNumber;
		
		for(int i=1; i<=N; i++) {
			tempNumber = (Math.pow(i,2)+1)/(i+3);
			soma += tempNumber;
		}
		
		return soma;
				
	}
	
}
