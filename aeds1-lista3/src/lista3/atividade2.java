package lista3;

import java.util.Scanner;

public class atividade2 {

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		
		int numerador, denominador;
		
		System.out.print("Informe o numerador: ");
		numerador = entrada.nextInt();
		System.out.print("Informe o denomidador: ");
		denominador = entrada.nextInt();
		
		System.out.println(resto(numerador, denominador));
		
		entrada.close();

	}
	
	public static int resto (int numerador, int denominador)
	{
		
		if(numerador>= denominador){
			numerador -= denominador;
			return resto(numerador, denominador);
		}else {
			return numerador;
		}
		
	}

}
