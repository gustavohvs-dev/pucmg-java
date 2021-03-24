package arquivo;

import java.util.Scanner;
import java.io.*;

public class teste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		FileWriter arquivo;
		
		try{	
			arquivo = new FileWriter("C:\\Users\\Usuário\\Downloads\\resultado.txt");
			arquivo.write("Escrevendo conteúdo de texto:\nGustavo Soares\nPROVA DE AEDS\n10 de dezembro de 2020");
			arquivo.close();
		}
		catch(FileNotFoundException fe) {
			System.out.println("Erro: " + fe.getMessage());
		}
		catch(IOException io) {
			System.out.println("Erro: " + io.getMessage());
		}

	}

}
