
public class MainExercicio9 {

	public static void main(String[] args) {
		
		ConversaoDeUnidadesDeTempo conversao = new ConversaoDeUnidadesDeTempo();
		double gestacaoElefanteIndiano = 624;
		
		System.out.println("Tempo de gesta��o em meses: " + conversao.diasParaMeses(gestacaoElefanteIndiano));
		System.out.println("Tempo de gesta��o em dias: " + gestacaoElefanteIndiano);
		System.out.println("Tempo de gesta��o em horas: " + conversao.diasParaHoras(gestacaoElefanteIndiano));

	}

}

