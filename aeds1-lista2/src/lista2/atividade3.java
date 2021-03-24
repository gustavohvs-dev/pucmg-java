package lista2;

import java.util.Scanner;

public class atividade3 {

	public static void main(String[] args) {
				
			ordenarNumeros();		
		 
	}
	
	public static void ordenarNumeros() {
		
		Scanner entrada = new Scanner(System.in);
		
		int N;
		double n1, n2, n3;
		
		System.out.print("Informe a quantidade de N conjuntos: ");
		N = entrada.nextInt();
		
		for(int i=0; i<N; i++) {
		
			System.out.println("Informe três números a serem ordenados");
			System.out.print("Primeiro número: ");
			n1 = entrada.nextDouble();
			System.out.print("Segundo número: ");
			n2 = entrada.nextDouble();
			System.out.print("Terceiro número: ");
			n3 = entrada.nextDouble();
			
			if((n1>=n2)&&(n1>=n3)) {
				System.out.print("Ordem:");
				System.out.print(" " + n1);
				if(n2>n3) {
					System.out.print(" " + n2);
					System.out.print(" " + n3);
				}else {
					System.out.print(" " + n3);
					System.out.print(" " + n2);
				}
			}else if((n2>=n1)&&(n2>=n3)) {
				System.out.print("Ordem:");
				System.out.print(" " + n2);
				if(n1>n3) {
					System.out.print(" " + n1);
					System.out.print(" " + n3);
				}else {
					System.out.print(" " + n3);
					System.out.print(" " + n1);
				}
			}else {
				System.out.print("Ordem:");
				System.out.print(" " + n3);
				if(n1>n2) {
					System.out.print(" " + n1);
					System.out.print(" " + n2);
				}else {
					System.out.print(" " + n2);
					System.out.print(" " + n1);
				}
			}
			
			System.out.println(" ");
		
		}
		
		entrada.close();
		
		
	}
	
}
