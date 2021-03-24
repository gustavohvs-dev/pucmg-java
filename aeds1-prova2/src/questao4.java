import java.util.Scanner;

public class questao4 {

	public static int[][] preenche(int[][] valores) {
		for (int ln=0; ln<valores.length; ln++)
		{
			for (int col=0; col<valores[0].length;col++)
			{
				valores[ln][col] = (ln+1)+(col+1);
				//System.out.print(valores[ln][col] + " ");
			}
		}
		return valores;
		
	}
	
	public static void media(int[][] valores) {
		int[] vet = new int[valores[0].length];
		int soma = 0;
		int qnt = 0; 
		int media = 0;
		for (int col=0; col<valores[0].length; col++)
		{
			for (int ln=0; ln<valores.length;ln++)
			{
				soma += valores[ln][col];
				qnt += 1;
				
			}
			
			media = soma/qnt;
			
			vet[col] = media;
			
			soma = 0;
			qnt = 0;
			
			System.out.println(vet[col]);
		}
		
	}
	
	public static void main(String[] args)
	{
		int[][] matriz = new int[4][5];
		media(preenche(matriz));
	}

}
