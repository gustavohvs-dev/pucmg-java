
public class ConversaoDeUnidadesDeTempo {
	
	public double minutosParaSegundos(double min) {
		
		return (min*60);
		
	}
	
	public double horasParaMinutos(double hour) {
		
		return (hour*60);
		
	}

	public double diasParaHoras(double day) {
		
		return (day*24);
		
	}

	public double semanasParaDias(double semana) {
		
		return (semana*7);
		
	}
	
	public double mesesParaDias(double mes) {
		
		return (mes*30);
		
	}
	
	public double diasParaMeses(double dia) {
		
		return (dia/30);
		
	}

}
