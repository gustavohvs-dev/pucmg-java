package lista4;

import java.util.Scanner;

public class ex6 {

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
        String texto;

        System.out.println("Digite um texto: ");
        texto = entrada.nextLine();

        for (int i = 0; i < texto.length(); i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            System.out.print(texto.charAt(i) + "\n");
        }

        entrada.close();

	}

}
