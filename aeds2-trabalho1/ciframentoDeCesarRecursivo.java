
public class ciframentoDeCesarRecursivo {

    public static void main(String args[]) {
        String entrada;
        do {
            entrada = MyIO.readLine();
            if (entrada.equals("FIM")) break;

            MyIO.println(Recursivo(entrada.toCharArray(), 0));

        } while (!entrada.equals("FIM"));
    }

    public static String Recursivo(char[] text, int i) {
        if (i < text.length) {
            int ascii = (int) text[i] + 3;
            text[i] = (char) ascii;
            i++;
            Recursivo(text, i);
        }
        return String.valueOf(text);
    }
}
