package lista4;

import java.util.Scanner;

public class ex4 {

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
        String texto;
        String palindromo = "";

        System.out.println("Digite alguma coisa: ");
        texto = entrada.nextLine(); 

        for (int i = texto.length() - 1; i >= 0; i--) {
            palindromo += texto.charAt(i);
        }

        if (palindromo.toLowerCase().equals(texto.toLowerCase())) {
            System.out.println("Essa palavra � um pal�ndromo");
        } else {
            System.out.println("Essa palavra n�o � um pal�ndromo");
        }

        entrada.close();

	}

}
