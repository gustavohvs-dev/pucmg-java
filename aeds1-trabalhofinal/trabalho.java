/*
 * Esse sistema foi criado por:
 * 
 * Gustavo Soares
 * Maxwell Junio
 * Rafael Penido
 * 
 * Algoritmo e Estrutura de Dados
 */

package trabalhofinal;

import java.io.*; 
import java.util.Scanner;
import java.util.Date;

public class trabalho {

	public static void main(String[] args) {

		//Chama a fun��o lerProdutos() para resgatar informa��es sobre os produtos
		String[][] produtos = new String[4][4];
		
		//Menu principal
		int menu = 1;
		Scanner entrada = new Scanner(System.in);
		
		//Cria um menu principal que se repete at� que seja digitado 0 na vari�vel 'menu'
		while(menu!=0) {
			produtos = lerProdutos();
			System.out.println("Selecione uma op��o no menu");
			System.out.println("1- Realizar uma venda");
			System.out.println("2- Gerar relat�rio de vendas");
			System.out.println("3- Gerar relat�rio de estoque");
			System.out.println("4- Verificar estoque e pre�os");
			System.out.println("0- Encerrar programa");
			System.out.print("Digite o c�digo da op��o: ");
			menu = entrada.nextInt();
			
			if(menu==1) {
				System.out.println("\n");
				realizarVenda(produtos);
			}else if(menu==2){
				System.out.println("\n");
				relatorioVendas();
			}else if(menu==3){
				System.out.println("\n");
				relatorioEstoque(produtos);
			}else if(menu==4){
				System.out.println("\n");
				verificarDatabase();
			}else if(menu==0){
				System.out.println("Programa encerrado!");
			}else {
				System.out.println("Op��o inv�lida");
			}
		}
		
		entrada.close();
					
	}
	
	public static String[][] lerProdutos() {
		
		/* 
		 * Essa fun��o coleta a quantidade em estoque, valor do produto, e custo de produ��o
		 * armazenada no arquivo produtos.txt, desta forma o arquivo serve como "banco de dados"
		*/
		
		//Instanciando matriz produtos...
		String[][] produtos = new String[4][4];
		
		
		try{	
			BufferedReader arquivo = new BufferedReader(new FileReader("C:\\Users\\Usu�rio\\Documents\\TrabalhoFinalAeds\\produtos.txt"));
			//Realizando leitura de arquivo e registrando os dados na matriz produtos
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					produtos[i][j] = arquivo.readLine();
				}
			}
			arquivo.close();
			return produtos;
		}
		catch(FileNotFoundException fe) {
			//Coleta de mensagem de erro
			System.out.println("Erro: " + fe.getMessage());
			return produtos;
		}
		catch(IOException io) {
			//Coleta de mensagem de erro
			System.out.println("Erro: " + io.getMessage());
			return produtos;
		}
		
	}
	
	public static void realizarVenda(String[][] produtos) {
		
		/* 
		 * Essa fun��o realiza a venda de um produto, verificando se o mesmo possui em estoque
		 * e registrando a venda no arquivo log.txt
		*/
		
		//Instanciando vari�veis necess�rias
		Scanner entrada = new Scanner(System.in);
		int codProduto;
		int qntEstoque;
				
		//Lista de sele��o de produtos
		System.out.println("Selecione o produto que gostaria de comprar");
		System.out.println("0- M�scara lisa adulto R$" + produtos[0][2]);
		System.out.println("1- M�scara lisa infantil R$" + produtos[1][2]);
		System.out.println("2- M�scara estampada adulto R$" + produtos[2][2]);
		System.out.println("3- M�scara estampada infantil R$" + produtos[3][2]);
		System.out.print("Digite o c�digo do produto: ");
		codProduto = entrada.nextInt();
		
		//Verificando se o produ��o consta na lista para verifica��o do estoque
		if((codProduto==0)||(codProduto==1)||(codProduto==2)||(codProduto==3)) {
			qntEstoque = Integer.parseInt(produtos[codProduto][1]);
			if(qntEstoque<=0) {
				System.out.print("\nFora de estoque\n\n");
			}else {
				System.out.print("\nEm estoque\n\n");
				//Remove um produto do estoque
				qntEstoque -= 1;
				String qntEstoqueString = String.valueOf(qntEstoque);
				produtos[codProduto][1] = qntEstoqueString;
				//Salva a remo��o no arquivo produtos.txt
				try {
		            FileWriter arquivo = new FileWriter("C:\\Users\\Usu�rio\\Documents\\TrabalhoFinalAeds\\produtos.txt");
		            for (int i = 0; i < 4; i++) {
						for (int j = 0; j < 4; j++) {
							arquivo.write(produtos[i][j] + "\n");
						}
					}
		            arquivo.close();
		            System.out.println("Produto removido do estoque.\n");
		        } catch (IOException e) {
		            System.out.println("Ocorreu um erro para remo��o do estoque.\n");
		            e.printStackTrace();
		        }
				//C�lculo de lucro
				double valorVenda = Double.parseDouble(produtos[codProduto][2]);
				double valorCusto = Double.parseDouble(produtos[codProduto][3]);
				double lucro = valorVenda - valorCusto;
				String lucroString = String.valueOf(lucro);
				//Salva uma venda no arquivo vendas.txt
				try {
					Date dataAgora = dataAtual();
		            FileWriter vendasTxt = new FileWriter("C:\\Users\\Usu�rio\\Documents\\TrabalhoFinalAeds\\vendas.txt", true);
		            vendasTxt.write("Venda realizada - Produto: " + produtos[codProduto][0] + " - Lucro obtido: " + lucroString + " - Data de venda: " + dataAgora + "\n");
		            vendasTxt.close();
		            System.out.println("Venda realizada.\n");
		        } catch (IOException e) {
		        	//Coletando mensagem de erro
		            System.out.println("Ocorreu um erro para registrar a venda.\n");
		            e.printStackTrace();
		        }
				
			}
		}else {
			System.out.print("C�digo inv�lido, direcionando para o menu principal");
		}
		
	}
	
	public static void relatorioEstoque(String[][] produtos) {
		
		/* 
		 * Essa fun��o gera um arquivo .txt com o relat�rio
		 * do estoque.
		*/
	
		try {
            FileWriter relatorio = new FileWriter("C:\\Users\\Usu�rio\\Documents\\TrabalhoFinalAeds\\relatorioEstoque.txt");
            for (int i = 0; i < produtos.length; i++) {
                relatorio.write("A mascara " + produtos[i][0] + " possui " + produtos[i][1] + " em estoque. \n");
            }
            relatorio.close();
            System.out.println("Relat�rio dispon�vel em relatorioEstoque.\n\n");
        } catch (IOException e) {
            System.out.println("Ocorreu um erro - relatorio estoque");
            e.printStackTrace();
        }
		
	}

	public static void relatorioVendas() {
		
		/* 
		 * Essa fun��o retorna uma mensagem avisando que o
		 * relat�rio vendas j� existe e est� dispon�vel
		*/
		
		System.out.println("Relat�rio dispon�vel em vendas.txt");
		
	}
	
	public static void verificarDatabase() {
		
		/* 
		 * Essa fun��o reporta a quantidade de produtos em estoque e seus respectivos valores
		*/
		
		String[][] produtos = new String[4][4];
		
		try{	
			BufferedReader arquivo = new BufferedReader(new FileReader("C:\\Users\\Usu�rio\\Documents\\TrabalhoFinalAeds\\produtos.txt"));
			System.out.println("DATABASE ATUAL");
			System.out.println(" Nome do produto / Estoque / Valor de venda / Custo de produ��o");
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					produtos[i][j] = arquivo.readLine();
					System.out.print(" " + produtos[i][j]);
				}
				System.out.println("");
			}
			System.out.println("\n");
			arquivo.close();
		}
		catch(FileNotFoundException fe) {
			System.out.println("Erro: " + fe.getMessage());
		}
		catch(IOException io) {
			System.out.println("Erro: " + io.getMessage());
		}
		
	}
	
    public static Date dataAtual() {
    	
    	/* 
		 * Essa fun��o retorna a data atual
		*/
    	
        Date data = new Date();
        return data;
    }

}


