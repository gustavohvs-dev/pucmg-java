package lista8;

public class CarrinhoCompras {
	
	public static final int MAXITEMS = 100;
	private Produto[] carrinho = new Produto[MAXITEMS];
	
	public void adicionar(Produto item) {
		
		boolean espacoLivre = false;
		for(int i=0; i<MAXITEMS; i++) {
			if(carrinho[i]==null) {
				espacoLivre = true;
				carrinho[i] = item;
				break;
			}
		}
		if(espacoLivre == true) {
			System.out.println("Produto adicionado");
		}else {
			System.out.println("Carrinho lotado!");
		}
		
	}
	
	public void verCarrinho() {
		
		System.out.println("\n • Lista de produtos no carrinho \n");
		
		for(int i=0; i<MAXITEMS; i++) {
			if(carrinho[i]!=null) {
				System.out.print(carrinho[i].getDescricao());
				System.out.print(" - R$" + carrinho[i].getPreco());
				System.out.println("");
			}
		}

	}
	
	public void verValorTotal() {
		
		System.out.println("\n • Valor total da compra \n");
		
		double precoFinal = 0;
			
		for(int i=0; i<MAXITEMS; i++) {
			if(carrinho[i]!=null) {
				precoFinal += carrinho[i].getPreco();
			}
		}
		
		System.out.print("Preço total: R$" + precoFinal);

	}

}
