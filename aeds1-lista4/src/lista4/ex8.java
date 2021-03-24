package lista4;

import java.util.Scanner;

public class ex8 {

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
        String texto;

        System.out.println("Digite um texto: ");
        texto = entrada.nextLine();

        texto = texto.toUpperCase();

        for (int i = 0; i < texto.length(); i++) {
            if (texto.charAt(i) != ' ') {
                char aux = texto.charAt(i);
                aux += 3;
                System.out.print(aux);
            } else {
                System.out.print(texto.charAt(i));
            }
        }

        entrada.close();

	}

}
