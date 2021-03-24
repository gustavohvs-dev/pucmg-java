
public class questao2 {

	public static void main(String[] args) {
		
		int[][] matriz = new int[2][2];
		
		matriz[0][0] = 1;
		matriz[0][1] = 2;
		matriz[1][0] = 3;
		matriz[1][1] = 4;
		
		chamarMatriz(matriz);
		
		System.out.println(matriz[1][1]);

	}
	
	public static void chamarMatriz(int [][] matriz){
		
		matriz[1][1] = 5;
		
	}

}
