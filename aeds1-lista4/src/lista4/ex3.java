package lista4;

import java.util.Scanner;

public class ex3 {

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
        String texto = new String("ddmmaaaa");

        System.out.println("Digite sua data de nascimento (dd/mm/aaaa): ");
        texto = entrada.nextLine();

        if (texto.length() == 8) {

            System.out.print("Você nasceu em ");

            if (texto.charAt(2) == '0' && texto.charAt(3) == '1') {
                for (int i = 0; i < 2; i++) {
                    System.out.print(texto.charAt(i));
                }
                System.out.print(" de janeiro de ");
                for (int i = 4; i < texto.length(); i++) {
                    System.out.print(texto.charAt(i));
                }
            }
            
            if (texto.charAt(2) == '0' && texto.charAt(3) == '2') {
                for (int i = 0; i < 2; i++) {
                    System.out.print(texto.charAt(i));
                }
                System.out.print(" de fevereiro de ");
                for (int i = 4; i < texto.length(); i++) {
                    System.out.print(texto.charAt(i));
                }
            }
            
            if (texto.charAt(2) == '0' && texto.charAt(3) == '3') {
                for (int i = 0; i < 2; i++) {
                    System.out.print(texto.charAt(i));
                }
                System.out.print(" de março de ");
                for (int i = 4; i < texto.length(); i++) {
                    System.out.print(texto.charAt(i));
                }
            }
            
            if (texto.charAt(2) == '0' && texto.charAt(3) == '4') {
                for (int i = 0; i < 2; i++) {
                    System.out.print(texto.charAt(i));
                }
                System.out.print(" de abril de ");
                for (int i = 4; i < texto.length(); i++) {
                    System.out.print(texto.charAt(i));
                }
            }
            
            if (texto.charAt(2) == '0' && texto.charAt(3) == '5') {
                for (int i = 0; i < 2; i++) {
                    System.out.print(texto.charAt(i));
                }
                System.out.print(" de maio de ");
                for (int i = 4; i < texto.length(); i++) {
                    System.out.print(texto.charAt(i));
                }
            }
            
            if (texto.charAt(2) == '0' && texto.charAt(3) == '6') {
                for (int i = 0; i < 2; i++) {
                    System.out.print(texto.charAt(i));
                }
                System.out.print(" de junho de ");
                for (int i = 4; i < texto.length(); i++) {
                    System.out.print(texto.charAt(i));
                }
            }
            
            if (texto.charAt(2) == '0' && texto.charAt(3) == '7') {
                for (int i = 0; i < 2; i++) {
                    System.out.print(texto.charAt(i));
                }
                System.out.print(" de julho de ");
                for (int i = 4; i < texto.length(); i++) {
                    System.out.print(texto.charAt(i));
                }
            }
            
            if (texto.charAt(2) == '0' && texto.charAt(3) == '8') {
                for (int i = 0; i < 2; i++) {
                    System.out.print(texto.charAt(i));
                }
                System.out.print(" de agosto de ");
                for (int i = 4; i < texto.length(); i++) {
                    System.out.print(texto.charAt(i));
                }
            }
            
            if (texto.charAt(2) == '0' && texto.charAt(3) == '9') {
                for (int i = 0; i < 2; i++) {
                    System.out.print(texto.charAt(i));
                }
                System.out.print(" de setembro de ");
                for (int i = 4; i < texto.length(); i++) {
                    System.out.print(texto.charAt(i));
                }
            }
            
            if (texto.charAt(2) == '1' && texto.charAt(3) == '0') {
                for (int i = 0; i < 2; i++) {
                    System.out.print(texto.charAt(i));
                }
                System.out.print(" de outubro de ");
                for (int i = 4; i < texto.length(); i++) {
                    System.out.print(texto.charAt(i));
                }
            }
            
            if (texto.charAt(2) == '1' && texto.charAt(3) == '1') {
                for (int i = 0; i < 2; i++) {
                    System.out.print(texto.charAt(i));
                }
                System.out.print(" de novembro de ");
                for (int i = 4; i < texto.length(); i++) {
                    System.out.print(texto.charAt(i));
                }
            }
            
            if (texto.charAt(2) == '1' && texto.charAt(3) == '2') {
                for (int i = 0; i < 2; i++) {
                    System.out.print(texto.charAt(i));
                }
                System.out.print(" de dezembro de ");
                for (int i = 4; i < texto.length(); i++) {
                    System.out.print(texto.charAt(i));
                }
            }

        } else {
            System.out.print("Data inválida");
        }

        entrada.close();

	}

}
