package lista5;

import java.io.*; 
import java.util.Scanner;

public class ex2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String path = "C:\\Users\\Usuário\\Documents\\";
		String fileName;
		int linhas = 0;

		Scanner entrada = new Scanner(System.in);
		
		System.out.print("Digite o nome do arquivo: ");
		fileName = entrada.next();
		
		try{	
			BufferedReader arquivo = new BufferedReader(new FileReader(path + fileName));
			while (arquivo.readLine() != null) {
				linhas += 1;
			}
			arquivo.close();
		}
		catch(FileNotFoundException fe) {
			System.out.println("Erro: " + fe.getMessage());
		}
		catch(IOException io) {
			System.out.println("Erro: " + io.getMessage());
		}
		
		System.out.println(linhas);
		
		
		entrada.close();


	}

}
