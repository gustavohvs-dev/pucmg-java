package lista6;

public class Estacionamento {
	
	public static final int NUMMAXVAGAS = 50;
	public String nome;
	private Veiculo[] vagas = new Veiculo[NUMMAXVAGAS];
	private int numTotalVagas;
	private int numVagasLivres;
	
	public Estacionamento(String nomeEstabelecimento, int totalVagas) {
		this.nome = nomeEstabelecimento;
		this.numTotalVagas = totalVagas;
		this.numVagasLivres = totalVagas;
	}
	
	public void estacionar(Veiculo carro) {
		boolean estacionado = false;
		if(this.numVagasLivres>0) {
			for(int i=0; ((i<this.numTotalVagas)&&(estacionado == false)) ; i++) {
				if(this.vagas[i]==null){
					estacionado = true;
					this.vagas[i] = carro;
				}
			}
			if(estacionado == true) {
				this.numVagasLivres -= 1;
				System.out.println("Veículo estacionado!");
			}else {
				System.out.println("Veículo não foi estacionado");
			}
		}else {
			System.out.println("Não há vagas livres");
		}	
	}
	
	public int obterVagaOcupada(Veiculo carro) {
		boolean encontrado = false;
		int pos = 0;
		for(int i=0; ((i<this.numTotalVagas)&&(encontrado == false)) ; i++) {
			if(this.vagas[i].placa==carro.placa){
				encontrado = true;
				pos = i;
			}
		}
		if(encontrado == true) {
			return pos;
		}else {
			return -1;
		}
	}
	
	public void retirarVeiculo(int numVaga) {
		if(this.vagas[numVaga]!=null) {
			this.vagas[numVaga] = null;
			this.numVagasLivres += 1;
			System.out.println("Veículo retirado da vaga " + numVaga);
		}else {
			System.out.println("Não há veículo estacionado nessa vaga");
		}
	}
	
	public int getNumVagasLivres() {
		return this.numVagasLivres;
	}
	
	public String ocupacaoEstacionamento() {
		String response = "";
		for(int i=0; (i<this.numTotalVagas) ; i++) {
			if(this.vagas[i]==null){
				response += "Vazio";
			}else {
				response += this.vagas[i].placa;
			}
			response += " ";
		}
		return response;
	}

}
