public class Televisao {

	//Atributos
	private int volume;
	private int canal;
	
	//Construtor
	public Televisao(int volume, int canal) {
		this.volume = volume;
		this.canal = canal;
	}

	//Getters
	public int getVolume() {
		return this.volume;
	}
	public int getCanal() {
		return this.canal;
	}

	//Metodos
	public int aumentarVolume(){
		if(this.volume<100){
			this.volume += 1;
		}
		return this.volume;
	}
	public int diminuirVolume(){
		if(this.volume>0){
			this.volume -= 1;
		}
		return this.volume;
	}
	public int aumentarCanal(){
		if(this.canal<150){
			this.canal += 1;
		}
		return this.canal;
	}
	public int diminuirCanal(){
		if(this.canal>1){
			this.canal -= 1;
		}
		return this.canal;
	}
	public int trocarCanal(int canal){
		if((canal>=1)&&(canal<=150))
		this.canal = canal;
		return this.canal;
	}
	
}