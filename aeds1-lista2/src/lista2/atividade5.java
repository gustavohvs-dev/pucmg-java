package lista2;

import java.util.Scanner;

public class atividade5 {

	public static void main(String[] args) {
				
		Scanner entrada = new Scanner(System.in);
		
		int N, media;

		System.out.print("Informe a quantidade de alunos: ");
		N = entrada.nextInt();
		
		for(int i=0; i<N; i++) {
			System.out.print("Informe a média do aluno: ");
			media = entrada.nextInt();
			conceitoAluno(media);	
		}	
		
		entrada.close();
		
	}
	
	public static void conceitoAluno(int media) {
			
		if(media>=90) {
			System.out.print("Nota A");
		}else if((media>=80)&&(media<=89)){
			System.out.print("Nota B");
		}else if((media>=70)&&(media<=79)){
			System.out.print("Nota C");
		}else if((media>=60)&&(media<=69)){
			System.out.print("Nota D");
		}else if((media>=40)&&(media<=59)){
			System.out.print("Nota E");
		}else {
			System.out.print("Nota F");
		}
		
		System.out.println(" ");
				
	}
	
}
