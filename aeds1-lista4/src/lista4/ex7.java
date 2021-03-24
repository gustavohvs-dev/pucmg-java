package lista4;

import java.util.Scanner;

public class ex7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner entrada = new Scanner(System.in);
        int qnt;

        System.out.println("Digite a quantidade de caracteres: ");
        qnt = entrada.nextInt();

        char[] txt = new char[qnt];

        for (int i = 0; i < qnt; i++) {
            System.out.print((i + 1) + "º caractere: ");
            txt[i] = entrada.next().charAt(0);
        }

        for (int i = 0; i < qnt; i++) {
            int ascii = (int) txt[i] - 32;
            txt[i] = (char) ascii;
            System.out.print(txt[i]);
        }

        entrada.close();

	}

}
