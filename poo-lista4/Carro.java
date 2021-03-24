
public class Carro {
	
	//Atributos
	private String marca;
	private String modelo;
	private String placa;
	private String renavam;
	private String chassi;
	private String combustivel;
	private double tanqueCombustivel;
	private double tanqueCapacidade;
	
	//Construtor
	public Carro(String marca, String modelo, String placa, String renavam, String chassi, String combustivel, double tanqueCapacidade) {
		this.marca = marca;
		this.modelo = modelo;
		this.placa = placa;
		this.renavam = renavam;
		this.chassi = chassi;
		
		if((combustivel!="gasolina")&&(combustivel!="etanol")) {
			this.combustivel = "gasolina";
		}else {
			this.combustivel = combustivel;
		}
		
		if((tanqueCapacidade>=40)&&(tanqueCapacidade<=50)) {
			this.tanqueCapacidade = tanqueCapacidade;
		}else {
			this.tanqueCapacidade = 40;
		}
		
		this.tanqueCombustivel = 0;
		
	}

	//Getters
	public String getMarca() {return this.marca;}
	public String getModelo() {return this.modelo;}
	public String getPlaca() {return this.placa;}
	public String getRenavam() {return this.renavam;}
	public String getChassi() {return this.chassi;}
	public String getCombustivel() {return this.combustivel;}
	public double getTanqueCombustivel() {return this.tanqueCombustivel;}
	public double getTanqueCapacidade() {return this.tanqueCapacidade;}
	
	public String abastecer(double combustivel) {
		if((this.tanqueCombustivel + combustivel) > this.tanqueCapacidade) {
			return "Não foi possível abastecer";
		}else {
			this.tanqueCombustivel += combustivel;
			return "Abastecido";
		}
	}
	
	public String percorrer(double km) {
		if(this.combustivel=="gasolina") {
			double litrosGastar = km / 10;
			if(litrosGastar>this.tanqueCombustivel) {
				double distanciaPercorrida = this.tanqueCombustivel * 7;
				this.tanqueCombustivel = 0;
				return "O carro percorreu " + distanciaPercorrida + " quilômetros, mas ficou sem combustível";
			}else {
				this.tanqueCombustivel -= litrosGastar;
				return "O carro percorreu " + km + " quilômetros";
			}
		}else if(this.combustivel=="etanol"){
			double litrosGastar = km / 7;
			if(litrosGastar>this.tanqueCombustivel) {
				double distanciaPercorrida = this.tanqueCombustivel * 7;
				this.tanqueCombustivel = 0;
				return "O carro percorreu " + distanciaPercorrida + " quilômetros, mas ficou sem combustível";
			}else {
				this.tanqueCombustivel -= litrosGastar;
				return "O carro percorreu " + km + " quilômetros";
			}
		}else {
			return "Tipo de combustível não encontrado";
		}
	}
	
}
