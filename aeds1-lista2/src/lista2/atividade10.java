package lista2;

import java.util.Scanner;

public class atividade10 {

	public static void main(String[] args) {
				
		Scanner entrada = new Scanner(System.in);
		
		int idade;
		char idadeNadador;
		
		System.out.print("Informe a idade do nadador: ");
		idade = entrada.nextInt();
		
		idadeNadador = idadeNadador(idade);
		
		if(idadeNadador=='N'){
			System.out.println("Idade inválida e/ou sem categoria");
		}else {
			System.out.println("A categoria do nadador é " + idadeNadador);
		}
		
		entrada.close();
		
	}
	
	public static char idadeNadador(int idade) {
		
		if((idade>=5)&&(idade<=7)) {
			return 'F';
		}else if((idade>=8)&&(idade<=10)) {
			return 'E';
		}else if((idade>=11)&&(idade<=13)) {
			return 'D';
		}else if((idade>=14)&&(idade<=15)) {
			return 'C';
		}else if((idade>=17)&&(idade<=17)) {
			return 'B';
		}else if(idade>=18) {
			return 'A';
		}else {
			return 'N';
		}
					
	}
	
}
