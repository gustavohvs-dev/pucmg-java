package lista3;

import java.util.Scanner;

public class atividade1 {

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		
		int numerador, denominador;
		
		System.out.print("Informe o numerador: ");
		numerador = entrada.nextInt();
		System.out.print("Informe o denomidador: ");
		denominador = entrada.nextInt();
		
		System.out.println(divisao(numerador, denominador, 0));
		
		entrada.close();

	}
	
	public static int divisao (int numerador, int denominador, int resultado)
	{
		
		if(numerador>= denominador){
			numerador -= denominador;
			resultado += 1;
			return divisao(numerador, denominador, resultado);
		}else {
			return resultado;
		}
		
	}

}
