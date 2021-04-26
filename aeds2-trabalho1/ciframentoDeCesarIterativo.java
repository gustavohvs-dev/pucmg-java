
public class ciframentoDeCesarIterativo {

    public static void main(String[] args) {
               
        String texto ="";
        String resultado = "";
        int chave = 3;
        while(!texto.equals("FIM")){
                texto = MyIO.readLine();
                if(texto.equals("FIM")){
                   break; 
                }
                else{
                    resultado = criptografa(texto, chave);
                }       
           
            MyIO.println(resultado);
        }

    }

    public static String criptografa(String texto, int chave) {
        String aux = "";

        for (int i = 0; i < texto.length(); i++) {
            aux = aux + (char) (texto.charAt(i) + chave);
        }

        return (aux);
    }

}
