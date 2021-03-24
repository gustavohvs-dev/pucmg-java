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

		//Chama a função lerProdutos() para resgatar informações sobre os produtos
		String[][] produtos = new String[4][4];
		
		//Menu principal
		int menu = 1;
		Scanner entrada = new Scanner(System.in);
		
		//Cria um menu principal que se repete até que seja digitado 0 na variável 'menu'
		while(menu!=0) {
			produtos = lerProdutos();
			System.out.println("Selecione uma opção no menu");
			System.out.println("1- Realizar uma venda");
			System.out.println("2- Gerar relatório de vendas");
			System.out.println("3- Gerar relatório de estoque");
			System.out.println("4- Verificar estoque e preços");
			System.out.println("0- Encerrar programa");
			System.out.print("Digite o código da opção: ");
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
				System.out.println("Opção inválida");
			}
		}
		
		entrada.close();
					
	}
	
	public static String[][] lerProdutos() {
		
		/* 
		 * Essa função coleta a quantidade em estoque, valor do produto, e custo de produção
		 * armazenada no arquivo produtos.txt, desta forma o arquivo serve como "banco de dados"
		*/
		
		//Instanciando matriz produtos...
		String[][] produtos = new String[4][4];
		
		
		try{	
			BufferedReader arquivo = new BufferedReader(new FileReader("C:\\Users\\Usuário\\Documents\\TrabalhoFinalAeds\\produtos.txt"));
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
		 * Essa função realiza a venda de um produto, verificando se o mesmo possui em estoque
		 * e registrando a venda no arquivo log.txt
		*/
		
		//Instanciando variáveis necessárias
		Scanner entrada = new Scanner(System.in);
		int codProduto;
		int qntEstoque;
				
		//Lista de seleção de produtos
		System.out.println("Selecione o produto que gostaria de comprar");
		System.out.println("0- Máscara lisa adulto R$" + produtos[0][2]);
		System.out.println("1- Máscara lisa infantil R$" + produtos[1][2]);
		System.out.println("2- Máscara estampada adulto R$" + produtos[2][2]);
		System.out.println("3- Máscara estampada infantil R$" + produtos[3][2]);
		System.out.print("Digite o código do produto: ");
		codProduto = entrada.nextInt();
		
		//Verificando se o produção consta na lista para verificação do estoque
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
				//Salva a remoção no arquivo produtos.txt
				try {
		            FileWriter arquivo = new FileWriter("C:\\Users\\Usuário\\Documents\\TrabalhoFinalAeds\\produtos.txt");
		            for (int i = 0; i < 4; i++) {
						for (int j = 0; j < 4; j++) {
							arquivo.write(produtos[i][j] + "\n");
						}
					}
		            arquivo.close();
		            System.out.println("Produto removido do estoque.\n");
		        } catch (IOException e) {
		            System.out.println("Ocorreu um erro para remoção do estoque.\n");
		            e.printStackTrace();
		        }
				//Cálculo de lucro
				double valorVenda = Double.parseDouble(produtos[codProduto][2]);
				double valorCusto = Double.parseDouble(produtos[codProduto][3]);
				double lucro = valorVenda - valorCusto;
				String lucroString = String.valueOf(lucro);
				//Salva uma venda no arquivo vendas.txt
				try {
					Date dataAgora = dataAtual();
		            FileWriter vendasTxt = new FileWriter("C:\\Users\\Usuário\\Documents\\TrabalhoFinalAeds\\vendas.txt", true);
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
			System.out.print("Código inválido, direcionando para o menu principal");
		}
		
	}
	
	public static void relatorioEstoque(String[][] produtos) {
		
		/* 
		 * Essa função gera um arquivo .txt com o relatório
		 * do estoque.
		*/
	
		try {
            FileWriter relatorio = new FileWriter("C:\\Users\\Usuário\\Documents\\TrabalhoFinalAeds\\relatorioEstoque.txt");
            for (int i = 0; i < produtos.length; i++) {
                relatorio.write("A mascara " + produtos[i][0] + " possui " + produtos[i][1] + " em estoque. \n");
            }
            relatorio.close();
            System.out.println("Relatório disponível em relatorioEstoque.\n\n");
        } catch (IOException e) {
            System.out.println("Ocorreu um erro - relatorio estoque");
            e.printStackTrace();
        }
		
	}

	public static void relatorioVendas() {
		
		/* 
		 * Essa função retorna uma mensagem avisando que o
		 * relatório vendas já existe e está disponível
		*/
		
		System.out.println("Relatório disponível em vendas.txt");
		
	}
	
	public static void verificarDatabase() {
		
		/* 
		 * Essa função reporta a quantidade de produtos em estoque e seus respectivos valores
		*/
		
		String[][] produtos = new String[4][4];
		
		try{	
			BufferedReader arquivo = new BufferedReader(new FileReader("C:\\Users\\Usuário\\Documents\\TrabalhoFinalAeds\\produtos.txt"));
			System.out.println("DATABASE ATUAL");
			System.out.println(" Nome do produto / Estoque / Valor de venda / Custo de produção");
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
		 * Essa função retorna a data atual
		*/
    	
        Date data = new Date();
        return data;
    }

}


