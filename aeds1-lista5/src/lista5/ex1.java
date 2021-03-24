package lista5;

import java.io.*; 

import java.util.Scanner;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class ex1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String path = "C:\\Users\\Usuário\\Documents\\";
		String fileName1;
		String fileName2;

		Scanner entrada = new Scanner(System.in);
		
		System.out.print("Digite o nome do primeiro arquivo: ");
		fileName1 = entrada.next();
		System.out.print("Digite o nome do segundo arquivo: ");
		fileName2 = entrada.next();
		
		
		
		try {
			File file1 = new File(path + fileName1);
			File file2 = new File(path + fileName2);	
			byte[] bytes1 = Files.readAllBytes(file1.toPath());
			byte[] bytes2 = Files.readAllBytes(file2.toPath());
			String textoDoArquivo1 = new String(bytes1, "UTF-8");
			String textoDoArquivo2 = new String(bytes2, "UTF-8");
			if(textoDoArquivo1 == textoDoArquivo2) {
				System.out.println("Os arquivos são iguais");
			}else {
				System.out.println("Os arquivos são diferentes");
			}
		}
		catch(FileNotFoundException fe) {
			System.out.println("Erro: " + fe.getMessage());
		}
		catch(IOException io) {
			System.out.println("Erro: " + io.getMessage());
		}
				
		entrada.close();

	}

}
