package lista2;

import java.util.Scanner;

public class atividade1 {

	public static void main(String[] args) {
		
		 Scanner entrada = new Scanner(System.in);
		 
		 int N;
		 double nota1, nota2, nota3;
		 char tipo;
		 
		 System.out.print("Insira a quantidade de alunos: ");
		 N = entrada.nextInt();
		 
		 for(int i=0; i<N; i++) {
			 System.out.print("Informe o tipo de cálculo, sendo A, média aritmética e P, média ponderada: ");
			 tipo = entrada.next().charAt(0);
			 System.out.print("Digite o valor da nota 1: ");
			 nota1 = entrada.nextDouble();
			 System.out.print("Digite o valor da nota 2: ");
			 nota2 = entrada.nextDouble();
			 System.out.print("Digite o valor da nota 3: ");
			 nota3 = entrada.nextDouble();
			 calcularMedia(nota1, nota2, nota3, tipo);
		 }
		 
		 System.out.println("Fim do programa");
		 
		 entrada.close();

	}
	
	public static void calcularMedia(double nota1, double nota2, double nota3, char tipo) {
		double soma;
		if((tipo=='A')||(tipo=='a')) {
			soma = (nota1 + nota2 + nota3)/3;
			System.out.println("O valor da média aritmética é: " + soma);
		}else if((tipo=='P')||(tipo=='p')) {
			soma = (nota1*5 + nota2*3 + nota3*2)/10;
			System.out.println("O valor da média aritmética é: " + soma);
		}else {
			System.out.println("Tipo de cálculo inválido!");
		}
	}

}
