package lista5;

import java.io.*; 
import java.util.Scanner;

public class ex4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String path = "C:\\Users\\Usuário\\Documents\\";
		File arq;
        FileWriter saida;
        Scanner entrada = new Scanner(System.in);
        Scanner arqEntrada;
        String nomeArq, nomeSaida, linha, palavra;
        String[] palavras;
        int ln = 1, conta = 0;

        System.out.print("Digite o nome completo do arquivo de entrada: ");
        nomeArq = entrada.nextLine();
        System.out.print("Digite o nome completo do arquivo de saída: ");
        nomeSaida = entrada.nextLine();
        System.out.print("Digite a palavra que quer procurar no arquivo: ");
        palavra = entrada.nextLine().toUpperCase();
        arq = new File(path + nomeArq);

        try
        {
            if (arq.exists())
            {
                arqEntrada = new Scanner(arq);
                saida = new FileWriter(path + nomeSaida);

                while (arqEntrada.hasNextLine())
                {
                    linha = arqEntrada.nextLine().toUpperCase();

                    if (linha.contains(palavra))
                    {
                        saida.write("A palavra foi encontrada na linha " + ln + "\n");
                        System.out.println("A palavra foi encontrada na linha " + ln);

                        palavras = linha.split(" ");
                        for (int pos=0; pos < palavras.length; pos++)
                        {
                            palavras[pos] = palavras[pos].toUpperCase();

                            if (palavras[pos].equals(palavra))
                            {
                            conta++;    
                            }
                        }
                    }
                    ln++;
                }
                saida.write("O total de palavras encontradas foi " + conta + "\n");
                System.out.println("O total de palavras encontradas foi " + conta);
                arqEntrada.close();
                saida.close();
            }
        }
        catch (FileNotFoundException fe)
        {
            System.out.println(fe.getMessage());
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
        entrada.close();
	}

}
