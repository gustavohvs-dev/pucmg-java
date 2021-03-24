package arquivo;

import java.io.*; 
import java.util.Scanner;

public class teste3 {

	public static void main(String[] args) {
		
		String nomeArquivo = preencheArquivo();
		
		System.out.println(nomeArquivo);
		
		lerArquivo(nomeArquivo);

	}
	
	public static String preencheArquivo() {
		
		FileWriter arquivo;
				
		String[][] celulares = new String[2][5];
		String nomeArquivo;
		String texto = "";
		
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Digite o nome do arquivo de texto: ");
		nomeArquivo = entrada.next();
		
		for (int i = 0; i < 2; i++) {
			
			System.out.println("Celular " + i);
			System.out.print("Digite a marca do celular: ");
			celulares[i][0] = entrada.next();
			System.out.print("Digite o modelo do celular: ");
			celulares[i][1] = entrada.next();
			System.out.print("Digite o preço do celular em reais: ");
			celulares[i][2] = entrada.next();
			System.out.print("Digite quantidade de memória RAM do celular em GB: ");
			celulares[i][3] = entrada.next();
			System.out.print("Digite o limite de armazenamento interno do celular em GB: ");
			celulares[i][4] = entrada.next();
			
		}
		
		for (int i = 0; i < 2; i++) {
			texto += "Celular" + i;
			for (int j = 0; j < 5; j++) {
				texto += "\n" + celulares[i][j];
			}
			texto += "\n";
		}
		
		System.out.println(texto);
		
		try{	
			arquivo = new FileWriter("C:\\Users\\Usuário\\Downloads\\"+ nomeArquivo +".txt");
			arquivo.write(texto);
			arquivo.close();
		}
		catch(FileNotFoundException fe) {
			System.out.println("Erro: " + fe.getMessage());
		}
		catch(IOException io) {
			System.out.println("Erro: " + io.getMessage());
		}
		
		entrada.close();
		
		return nomeArquivo;

	}
	
	public static void lerArquivo(String nomeArquivo) {
		
		String linha;
		int count = 0;
		String[] vetor = new String[12];
		
		try{	
			BufferedReader arquivo = new BufferedReader(new FileReader("C:\\Users\\Usuário\\Downloads\\"+ nomeArquivo +".txt"));
			while ((linha = arquivo.readLine()) != null) {
				vetor[count] = linha;
				System.out.println(vetor[count]);
				count+=1;
			}
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
