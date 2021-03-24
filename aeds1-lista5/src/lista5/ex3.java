package lista5;

import java.io.*; 
import java.util.Scanner;

public class ex3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String path = "C:\\Users\\Usuário\\Documents\\";
		String fileName;
		int linhas = 0;

		Scanner entrada = new Scanner(System.in);
		
		System.out.print("Digite o nome do arquivo: ");
		fileName = entrada.next();
		
		try{	
			String inFileName = path + fileName;
            String outFileName = path + "Cópia de " + fileName;

            FileInputStream in = new FileInputStream(inFileName);
            FileOutputStream out = new FileOutputStream(outFileName);

            byte[] buf = new byte[1024];
            int len;

            while ((len = in.read(buf)) > 0) {
                out.write(buf, 0, len);
            }

            out.close();
            in.close();
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
