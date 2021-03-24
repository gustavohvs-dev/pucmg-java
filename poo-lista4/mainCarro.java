
public class mainCarro {

	public static void main(String[] args) {

		Carro carro1 = new Carro("FORD", "FORD KA 2018", "KSA4G22", "4721577915", "SDJ4121ASD12", "gasolina", 50);
		Carro carro2 = new Carro("FIAT", "PALIO 2001", "ARS4G22", "987812144", "AUJ78921XHL2", "etanol", 40);
		
		carro1.abastecer(20);
		carro2.abastecer(30);
		
		System.out.println(carro1.percorrer(100));
		System.out.println(carro2.percorrer(400));	
		
		System.out.print("\n");
				
		System.out.println("Carro: " + carro1.getMarca() + " (" + carro1.getModelo() + ")" + " (" + carro1.getPlaca() + ")" + " (" + carro1.getCombustivel() + ")");
		System.out.println("Capacidade do tanque: " + carro1.getTanqueCapacidade());
		System.out.println("Combustível atual: " + carro1.getTanqueCombustivel());
		
		System.out.print("\n");
		
		System.out.println("Carro: " + carro2.getMarca() + " (" + carro2.getModelo() + ")" + " (" + carro2.getPlaca() + ")" + " (" + carro2.getCombustivel() + ")");
		System.out.println("Capacidade do tanque: " + carro2.getTanqueCapacidade());
		System.out.println("Combustível atual: " + carro2.getTanqueCombustivel());
		

	}

}
