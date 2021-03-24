package lista4;

import java.util.Scanner;

public class ex2 {

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
        String texto;

        System.out.println("Removedor de espaços extras");
        System.out.println("Digite o texto: ");
        texto = entrada.nextLine();

        for (int i = 0; i < texto.length(); i++) {
            if (texto.charAt(i) == ' ' && texto.charAt(i + 1) == ' ')  {
            } else {
                System.out.print(texto.charAt(i));
            }
        }

        entrada.close();

	}

}
