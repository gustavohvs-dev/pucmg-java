package lista3;

import java.util.Scanner;

public class atividade3 {

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		
		int n;
		
		System.out.print("Informe o valor de S: ");
		n = entrada.nextInt();
		
		System.out.println(serie(n, 0));
		
		entrada.close();

	}
	
	public static double serie(int n, double resultado)
	{
		
		if(n>0) {
			resultado += 1/fatorial(n);
			n -= 1;
			return serie(n, resultado);
		}else {
			return resultado;
		}
		
	
	}
	
	public static double fatorial(int num)
	{
		
		if(num==0) {
			return 1;
		}else {
			return num*fatorial(num-1);
		}
		
	}

}
