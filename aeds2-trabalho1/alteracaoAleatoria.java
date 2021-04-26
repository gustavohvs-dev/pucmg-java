
import java.util.Random;

public class alteracaoAleatoria {

    public static String alteraAleatorio(String palavra, int rep) {
        String alterada = "";
        char aleatorio1 = 'a';
        char aleatorio2 = 'b';
        Random gerador = new Random();
        gerador.setSeed(4);

        for (int j = 0; j <= rep; j++) {
            aleatorio1 = ((char) ('a' + Math.abs(gerador.nextInt()) % 26));
            aleatorio2 = ((char) ('a' + Math.abs(gerador.nextInt()) % 26));
        }

        for (int i = 0; i < palavra.length(); i++) {
            if (palavra.charAt(i) == (aleatorio1)) {
                alterada += aleatorio2;
            } else {
                alterada += palavra.charAt(i);
            }

        }

        return alterada;
    }

    public static void main(String[] args) {
        MyIO entrada = new MyIO();
        String resultado;
        int rep = 0;

        while (!entrada.equals("FIM")) {
            String text = entrada.readLine();
            if (text.equals("FIM")) {
                break;
            } else {
                resultado = alteraAleatorio(text, rep);
                rep += 1;
                MyIO.println(resultado);
            }

        }

    }

}
