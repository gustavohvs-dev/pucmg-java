
class ConversaoDeUnidadeDeVolume{

	public static double litrosParaCentimetrosCubicos(double litros) {
		return (litros*1000);
	}
	
	public static double metrosCubicosParaLitros(double m3) {
		return (m3*1000);
	}
	
	public static double metrosCubicosParaPesCubicos(double m3) {
		return (m3*35.32);
	}
	
	public static double metrosCubicosParaCentimetrosCubicos(double m3) {
		double litros = metrosCubicosParaLitros(m3);
		double c3 = litrosParaCentimetrosCubicos(litros);
		return (c3);
	}
	
	public static double galaoParaPolegadasCubicas(double galao) {
		return (galao*231);
	}
	
	public static double galaoParaLitros(double galao) {
		return (galao*3.785);
	}
	
}

public class ConversaoVolume {

	public static void main(String[] args) {
		
		System.out.println("Piscina ol�mpica de 1,890 metros c�bicos");
		System.out.println("Litros: " + ConversaoDeUnidadeDeVolume.metrosCubicosParaLitros(1.890));
		System.out.println("P�s c�bicos: " + ConversaoDeUnidadeDeVolume.metrosCubicosParaPesCubicos(1.890));
		System.out.println("Cent�metros c�bicos: " + ConversaoDeUnidadeDeVolume.metrosCubicosParaCentimetrosCubicos(1.890));
		
	}
}
