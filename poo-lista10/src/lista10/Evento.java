package lista10;

import java.util.ArrayList;

public class Evento {
	
	private ArrayList<IngressoVIP> listIngressosVIP = new ArrayList<IngressoVIP>();
	private ArrayList<IngressoNormal> listIngressosNormal = new ArrayList<IngressoNormal>();
	private int numIngressosVIP = 200;
	private int numIngressosNormaisPisoSuperior = 300;
	private int numIngressosNormaisPisoInferior = 700;
	
	public Evento() {
		System.out.println("Evento criado");
	}
	
	public boolean reserva(IngressoVIP ingresso) {
		if(ingresso.getValorIngresso()>=20) {
			if(this.numIngressosVIP>0) {
				this.numIngressosVIP -= 1;
				listIngressosVIP.add(ingresso);
				System.out.println("Reserva realizada com sucesso");
				return true;
			}else {
				System.out.println("Erro ao realizar reserva: Ingressos VIP esgotados");
				return false;
			}
		}else {
			System.out.println("Erro ao realizar reserva: O valor do ingresso deve ser no mínimo 20 reais");
			return false;
		}			
	}
	
	public boolean reserva(IngressoNormal ingresso) {
		if(ingresso.getLocal()=='1' || ingresso.getLocal()=='2') {
			if(ingresso.getLocal()=='1' && numIngressosNormaisPisoInferior>0) {
				this.numIngressosNormaisPisoInferior -= 1;
				listIngressosNormal.add(ingresso);
				System.out.println("Reserva realizada com sucesso");
				return true;
			}else if(ingresso.getLocal()=='2' && numIngressosNormaisPisoSuperior>0) {
				this.numIngressosNormaisPisoSuperior -= 1;
				listIngressosNormal.add(ingresso);
				System.out.println("Reserva realizada com sucesso");
				return true;	
			}else {
				System.out.println("Erro ao realizar reserva: Ingressos normais para o piso selecionado esgotados");
				return false;
			}
		}else {
			System.out.println("Erro ao realizar reserva: O ingresso não possui especificação do local");
			return false;
		}	
	}
	
	public void exibeReservas() {
		
		int ingressosNormaisDistribuidos = 0;
		int ingressosVIPDistribuidos = 0;
		
		System.out.println("\n### Ingressos normais ###");
		for(IngressoNormal i : listIngressosNormal) {
			ingressosNormaisDistribuidos++;
			System.out.println(i.getNome() + "|" + i.getCpf() + "|" + i.getLocal());
		}
		System.out.println("### Quantidade de ingressos normais distribuídos: "+ ingressosNormaisDistribuidos +" ###");
		
		System.out.println("\n### Ingressos VIP ###");
		for(IngressoVIP i : listIngressosVIP) {
			ingressosVIPDistribuidos++;
			System.out.println(i.getNome() + "|" + i.getCpf() + "|" + i.getValorIngresso());
		}
		System.out.println("### Quantidade de ingressos VIP distribuídos: "+ ingressosVIPDistribuidos +" ###");
		
	}
	
}
