package lista4;

import java.util.Scanner;

public class ex5 {

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
        String tel;

        System.out.println("Digite um telefone: ");
        tel = entrada.nextLine();

        System.out.print("Telefone corrigido com formatação: ");

        if (((tel.length() == 9) || (tel.length() == 10)) && (tel.charAt(0) == '9')) {
            System.out.print(tel.charAt(0));
        } else {
            System.out.print("9" + tel.charAt(0));
        }

        for (int i = 1; i < tel.length() - 4; i++) {
            System.out.print(tel.charAt(i));
        }

        if (tel.charAt(4) == '-' || tel.charAt(5) == '-' || tel.charAt(6) == '-') {
        } else {
            System.out.print("-");
        }

        for (int repet = tel.length() - 4; repet < tel.length(); repet++) {
            System.out.print(tel.charAt(repet));
        }

        entrada.close();

	}

}
