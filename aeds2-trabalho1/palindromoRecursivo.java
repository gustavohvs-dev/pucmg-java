
public class palindromoRecursivo {

    public static void main(String[] args) {
        String entrada;
        do {
            entrada = MyIO.readLine();
            if (entrada.equals("FIM")) break;
            char[] array1 = entrada.toCharArray();
            char[] array2 = new char[array1.length];
            array2 = Palindromo(array1, array2, 0, array1.length - 1);
            if (String.valueOf(array1).equals(String.valueOf(array2))) {
                MyIO.println("SIM");
            } else {
                MyIO.println("NAO");
            }
        } while (!entrada.equals("FIM"));
    }

    public static char[] Palindromo(char[] text, char[] palindromo, int i, int j) {
        if (i < text.length) {
            palindromo[j] = text[i];
            i++;
            j--;
            Palindromo(text, palindromo, i, j);
        }
        return palindromo;
    }

}
