package lista10;

public class main {

	public static void main(String[] args) {
		
		Evento evento = new Evento();
		
		IngressoNormal ingresso1 = new IngressoNormal("Gustavo Soares", "13632598657", '1');
		IngressoNormal ingresso2 = new IngressoNormal("Gabriel Soares", "23832598658", '2');
		IngressoNormal ingresso3 = new IngressoNormal("Brenda Kelly", "14632598659", '1');
		IngressoNormal ingresso4 = new IngressoNormal("Maxuell Costa", "13625498647", '2');
		IngressoNormal ingresso5 = new IngressoNormal("Jean Penido", "43632511137", '1');
		IngressoVIP ingresso6 = new IngressoVIP("Rafael Penido", "45411122245", 20);
		IngressoVIP ingresso7 = new IngressoVIP("Henrique Nascimento", "45411622245", 20);
		IngressoVIP ingresso8 = new IngressoVIP("Pedro Costela", "45411122275", 30);
		IngressoVIP ingresso9 = new IngressoVIP("Pedro Avelar", "45411124245", 28);
		IngressoVIP ingresso10 = new IngressoVIP("Kezia Costa", "97414522245", 25);
		
		evento.reserva(ingresso1);
		evento.reserva(ingresso2);
		evento.reserva(ingresso3);
		evento.reserva(ingresso4);
		evento.reserva(ingresso5);
		evento.reserva(ingresso6);
		evento.reserva(ingresso7);
		evento.reserva(ingresso8);
		evento.reserva(ingresso9);
		evento.reserva(ingresso10);
		
		evento.exibeReservas();

	}

}
