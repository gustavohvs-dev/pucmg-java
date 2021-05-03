package lista10;

public class IngressoNormal extends IngressoPromocional {
	
	private char local;
	
	public IngressoNormal(String nome, String cpf, char local){
		setNome(nome);
		setCpf(cpf);
		setLocal(local);
	}
	
	public void setLocal(char param) {
		if(param == '1' || param == '2') {
			this.local = param;
		}else {
			System.out.println("Erro ao inserir local, insira 1 para piso inferior e 2 para piso superior");
		}
	}
	
	public char getLocal() {
		return this.local;
	}

}
