package lista4;

import java.util.Scanner;

public class ex1 {

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
        String nome;

        System.out.println("Digite o seu nome completo: ");
        nome = entrada.nextLine();

        nome = nome.toUpperCase();

        System.out.print(nome.charAt(0));
        for (int repet = 1; repet <= nome.length(); repet++) {

            if ((nome.charAt(repet - 1) == ' ' && nome.charAt(repet) == 'E' && nome.charAt(repet + 1) == ' ')
                    ||
                    (nome.charAt(repet - 1) == ' ' && nome.charAt(repet) == 'D' && nome.charAt(repet + 1) == 'O' && nome.charAt(repet + 2) == ' ')
                    ||
                    (nome.charAt(repet - 1) == ' ' && nome.charAt(repet) == 'D' && nome.charAt(repet + 1) == 'A' && nome.charAt(repet + 2) == ' ')
                    ||
                    (nome.charAt(repet - 1) == ' ' && nome.charAt(repet) == 'D' && nome.charAt(repet + 1) == 'O' && nome.charAt(repet + 2) == 'S' && nome.charAt(repet + 3) == ' ')
                    ||
                    (nome.charAt(repet - 1) == ' ' && nome.charAt(repet) == 'D' && nome.charAt(repet + 1) == 'A' && nome.charAt(repet + 2) == 'S' && nome.charAt(repet + 3) == ' ')
                    ||
                    (nome.charAt(repet - 1) == ' ' && nome.charAt(repet) == 'D' && nome.charAt(repet + 1) == 'E' && nome.charAt(repet + 2) == ' ')
                    ||
                    (nome.charAt(repet - 1) == ' ' && nome.charAt(repet) == 'D' && nome.charAt(repet + 1) == 'I' && nome.charAt(repet + 2) == ' ')
                    ||
                    (nome.charAt(repet - 1) == ' ' && nome.charAt(repet) == 'D' && nome.charAt(repet + 1) == 'U' && nome.charAt(repet + 2) == ' ')
                    ) {
            	//...
            } else {
                if (nome.charAt(repet - 1) == ' ') {
                    System.out.print(nome.charAt(repet));
                }
            }
        }

        entrada.close();

	}

}
