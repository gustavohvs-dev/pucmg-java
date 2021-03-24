public class mainTelevisao {

	public static void main(String[] args) {
		
		Televisao tv = new Televisao(20, 1);
		tv.trocarCanal(149);
		tv.aumentarCanal();
		tv.aumentarCanal();
		tv.diminuirVolume();
		tv.diminuirVolume();
		tv.diminuirVolume();
		tv.aumentarVolume();
		
		System.out.println("Volume: " + tv.getVolume());
		System.out.println("Canal: " + tv.getCanal());

	}

}