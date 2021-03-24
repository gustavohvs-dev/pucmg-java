import java.util.Scanner;

public class questao3 {

	public static void preenche(int[][] valores) {
		Scanner entrada = new Scanner(System.in);
		for (int ln=0; ln<valores.length; ln++)
		{
			for (int col=0; col<valores[0].length;col++)
			{
				System.out.print("Digite:");
				valores[ln][col] = entrada.nextInt();
			}
		}
		entrada.close();
		
	}
	
	public static int[] somaLinhas(int[][] mat)
	{
		int[] vet = new int[mat.length];
		
		for(int i=0; i<mat.length; i++)
		{
			vet[i] = 0;
			for (int j=0; j<mat[i].length; j++)
			{
				vet[i] += mat[i][j];
			}

		}
		
		return vet;
	}
	
	public static void exibe(int[] v)
	{
		for (int pos=0; pos<v.length; pos++)
		{
			System.out.print(v[pos] + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args)
	{
		Scanner entrada = new Scanner(System.in);
		int[][] matriz = new int[3][4];
		preenche(matriz);
		exibe(somaLinhas(matriz));
		entrada.close();
	}

}
