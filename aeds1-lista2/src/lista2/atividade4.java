package lista2;

import java.util.Scanner;

public class atividade4 {

	public static void main(String[] args) {
				
		Scanner entrada = new Scanner(System.in);
		
		double l1, l2, l3;
		
		System.out.println("Informe o tamanho dos três lados do triângulo");
		System.out.print("Primeiro lado: ");
		l1 = entrada.nextDouble();
		System.out.print("Segundo lado: ");
		l2 = entrada.nextDouble();
		System.out.print("Terceiro lado: ");
		l3 = entrada.nextDouble();
		
		ladosTriangulo(l1, l2, l3);	
		
		entrada.close();
		
		 
	}
	
	public static void ladosTriangulo(double l1, double l2, double l3) {
			
		if((l1<l2+l3)&&(l2<l1+l3)&&(l3<l1+l2)) {
			if((l1==l2)&&(l2==l3)) {
				System.out.println("Triângulo equilátero");
			}else if((l1==l2)||(l2==l3)||(l3==l1)){
				System.out.println("Triângulo isósceles");
			}else {
				System.out.println("Triângulo escaleno");
			}
		}else {
			System.out.println("Não é um triângulo");
		}
				
	}
	
}
