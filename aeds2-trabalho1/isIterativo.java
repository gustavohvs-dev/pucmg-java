public class isIterativo {

    public static String somenteVogais(String text){

        char[] vogais = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
        boolean isVogal = false;

        for(int i=0; i<text.length();i++){
            for(int j = 0; j<vogais.length ; j++){
                if(text.charAt(i)==vogais[j]){
                    isVogal = true;
                    break;
                }else{
                    isVogal = false;
                }
            }
            if(isVogal==false){
                return "NAO";
            }
        }
        return "SIM";
        
    }

    public static String somenteConsoantes(String text){

        char[] consoantes = {'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'k', 'r', 's', 't', 'v', 'x', 'w', 'y', 'z', 'B', 'C', 'D', 'F', 'G', 'H', 'J', 'K', 'L', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'V', 'W', 'X', 'Y', 'Z'};
        boolean isConsoante = false;

        for(int i=0; i<text.length();i++){
            for(int j = 0; j<consoantes.length ; j++){
                if(text.charAt(i)==consoantes[j]){
                    isConsoante = true;
                    break;
                }else{
                    isConsoante = false;
                }
            }
            if(isConsoante==false){
                return "NAO";
            }
        }
        return "SIM";

    }

    public static String numeroInteiro(String text){

        try {
            int numero = Integer.parseInt(text);
            return "SIM";
        } catch (NumberFormatException e) {
            return "NAO";
        } 

    }

    public static String numeroReal(String text){

        try {
            String textoTratado = text.replaceAll(",",".");
            double numero = Double.parseDouble(textoTratado);
            return "SIM";
        } catch (NumberFormatException e) {
            return "NAO";
        } 

    }
    
    public static void main(String args[]){

        String text = "";
        String X1 = "";
        String X2 = "";
        String X3 = "";
        String X4 = "";

        while(!text.equals("FIM")){
            text = MyIO.readLine();
            if(text.equals("FIM")){
                break; 
            }else{
                X1 = somenteVogais(text);
                X2 = somenteConsoantes(text);
                X3 = numeroInteiro(text);
                X4 = numeroReal(text);
                MyIO.println(X1 + " " + X2 + " " + X3 + " " + X4);
            }          
        }
  
    }

}
