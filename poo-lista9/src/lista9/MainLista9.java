package lista9;

public class MainLista9 {

	public static void main(String[] args) {
		
		Contato[] listaContatos = new Contato[6];
		
		Familiar contato1 = new Familiar("Gustavo Soares", "Tavo", "gustavohvs.dev@gmail.com", "Irmão");
		Familiar contato2 = new Familiar("Susana Soares", "Sus", "sussoares@gmail.com", "Irmã");
		Amigo contato3 = new Amigo("Jean Ferreira", "Gê", "jeanff@outlook.com", 1);
		Amigo contato4 = new Amigo("Pedro Sousa", "Pedroso", "pedroka22@gmail.com", 2);
		Colega contato5 = new Colega("Fernando Ferreira", "Fernandim", "fernandoferreira@live.com", "Chefe");
		Colega contato6 = new Colega("Henrique Barbosa", "Rick", "barbosa.dev@gmail.com", "Colega");
		
		listaContatos[0] = contato1;
		listaContatos[1] = contato2;
		listaContatos[2] = contato3;
		listaContatos[3] = contato4;
		listaContatos[4] = contato5;
		listaContatos[5] = contato6;
		
		System.out.println("Confraternizações");
		contato1.confraterniza("festa de família");
		contato2.confraterniza("almoço de família");
		contato3.confraterniza("festa da faculdade");
		contato4.confraterniza("churrascão na laje");
		contato5.confraterniza("festa de 15 anos da empresa");
		contato6.confraterniza("formatura da faculdade");
		
	}

}
