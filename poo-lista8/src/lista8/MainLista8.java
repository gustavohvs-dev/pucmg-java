package lista8;

public class MainLista8 {

	public static void main(String[] args) {
		
		Produto produto1 = new Caderno(1, "Caderno do Maxsteel", 15.50 , "Capa dura", 90);
		Produto produto2 = new Caderno(2, "Caderno da Barbie",  20.00 , "Capa dura", 60);
		Produto produto3 = new Caderno(3, "Caderno do Bob Esponja",  10.00 , "Capa dura", 30);
		Produto produto4 = new Caneta(4, "Caneta Bic Azul", 0.50, "Azul");
		Produto produto5 = new Caneta(5, "Caneta Bic Vermelha", 0.50, "Vermelha");
		Produto produto6 = new Livro(6, "Trigonometria básica", 80.00, "Didático");
		Produto produto7 = new Livro(7, "Programação Orientada a objetos em Java", 75.00, "Didático");
		
		CarrinhoCompras carrinho = new CarrinhoCompras();
		
		carrinho.adicionar(produto1);
		carrinho.adicionar(produto2);
		carrinho.adicionar(produto3);
		carrinho.adicionar(produto4);
		carrinho.adicionar(produto5);
		
		carrinho.verCarrinho();
		carrinho.verValorTotal();

	}

}
