package lista6;

public class Index {

	public static void main(String[] args) {
		
		int vagaOcupada;
		
		Estacionamento estacionamento = new Estacionamento("Parking zone", 5);
		
		Veiculo veiculo1 = new Veiculo("ARR9984", "Gol", "Branco");
		Veiculo veiculo2 = new Veiculo("BRT5461", "Toyota", "Preto");
		Veiculo veiculo3 = new Veiculo("ASV1A22", "BMW", "Amarelo");
		Veiculo veiculo4 = new Veiculo("PSD7811", "Audi", "Cinza");
		Veiculo veiculo5 = new Veiculo("UJN5417", "Toyota", "Vermelho");
		Veiculo veiculo6 = new Veiculo("PQA1128", "Audi", "Azul");
		
		System.out.println(estacionamento.nome);
		
		estacionamento.estacionar(veiculo1);
		estacionamento.estacionar(veiculo2);
		estacionamento.estacionar(veiculo3);
		estacionamento.estacionar(veiculo4);
		estacionamento.estacionar(veiculo5);
		estacionamento.estacionar(veiculo6);
		
		System.out.println("Veículo 3 está ocupando a vaga: " + estacionamento.obterVagaOcupada(veiculo3));
		
		estacionamento.retirarVeiculo(1);
		estacionamento.retirarVeiculo(2);
		
		System.out.println("Número de vagas livres: " + estacionamento.getNumVagasLivres());
		
		System.out.println("Atual situação do estacionamento");
		System.out.println(estacionamento.ocupacaoEstacionamento());
		
	}

}
