package lista2;

import java.util.Scanner;

public class atividade7 {

	public static void main(String[] args) {
				
		Scanner entrada = new Scanner(System.in);
		
		int N, num;

		System.out.print("Informe a quantidade de n�meros: ");
		N = entrada.nextInt();
		
		for(int i=0; i<N; i++) {
			System.out.print("Informe um n�mero inteiro: ");
			num = entrada.nextInt();
			if(positivoNegativo(num)==true) {
				System.out.println("N�mero positivo");
			}else {
				System.out.println("N�mero negativo");
			}
		}	
		
		entrada.close();
		
	}
	
	public static boolean positivoNegativo(int num) {
			
		if(num>=0) {
			return true;
		}else {
			return false;
		}

	}
	
}
