
public class palindromoIterativo {
    public static boolean palindromo(String texto) {
        String aux = "";

        for (int i = texto.length() - 1; i >= 0; i--) {
            aux = aux + (char) (texto.charAt(i));
        }
        if (texto.equals(aux)) {

            return true;

        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        MyIO entrada = new MyIO();
        
        while(!entrada.equals("FIM")){
            String text = entrada.readLine();
            if(text.equals("FIM")){
                break;
            }else{
             if (palindromo(text) == true) {
                MyIO.println("SIM");
            } else {
                MyIO.println("NAO");
            }
   
            }
            
        }
       
    }    
}
    
