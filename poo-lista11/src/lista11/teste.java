package lista11;

public class teste {

	public static void main(String[] args) {
		
		Empregado empregado1 = new Empregado("Alfredo", 2012, 80.00, 30);
		Empregado empregado2 = new Empregado("Gertrudes", 2011, 120.00, 35);
		Empregado empregado3 = new Empregado("Claudinei", 2018, 50.00, 40);
		
		System.out.println("TESTES:");
		
		System.out.println("\n" + empregado1.getNome());
		System.out.println("Salário a pagar: " + empregado1.salario() + ".");
		System.out.println("O funcionário possui " + empregado1.tempoDeCasa() + " anos de tempo de casa.");
		
		System.out.println("\n" + empregado2.getNome());
		System.out.println("Salário a pagar: " + empregado2.salario() + ".");
		System.out.println("O funcionário possui " + empregado2.tempoDeCasa() + " anos de tempo de casa.");
		
		System.out.println("\n" + empregado3.getNome());
		System.out.println("Salário a pagar: " + empregado3.salario() + ".");
		System.out.println("O funcionário possui " + empregado3.tempoDeCasa() + " anos de tempo de casa.");

	}

}
