package lista2;

import java.util.Scanner;

public class atividade6 {

	public static void main(String[] args) {
				
		Scanner entrada = new Scanner(System.in);
		
		double N;
		
		System.out.print("Informe o valor de N: ");
		N = entrada.nextDouble();
		
		System.out.println(calcularFuncao(N));
		
		entrada.close();
		
	}
	
	public static double calcularFuncao(double N) {
			
		double soma = 1, tempNumber;
		
		for(int i=1; i<=N; i++) {
			tempNumber = 1/fatorial(i);
			soma += tempNumber;
		}
		
		return soma;
				
	}
	
	public static double fatorial(double num) {
		
		double result = 1;
		
		if(num==0) {
			result = 1;
		}else if(num<0) {
			result = -1;
		}else {
			for(int i=1; i<=num; i++) {
				result *= i;
			}
		}
		
		return result;
		
	}
	
}
