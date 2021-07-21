import java.lang.NullPointerException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.*;

class ArquivoTextoLeitura {

	private BufferedReader entrada;
	
	ArquivoTextoLeitura(String nomeArquivo) {	
		
		try {
			entrada = new BufferedReader(new FileReader(nomeArquivo));
		}
		catch (FileNotFoundException excecao) {
			System.out.println("Arquivo não encontrado");
		}
	}
	
	public void fecharArquivo() {
		
		try {
			entrada.close();
		}
		catch (IOException excecao) {
			System.out.println("Erro no fechamento do arquivo de leitura: " + excecao);	
		}
	}
	
	@SuppressWarnings("finally")
	public String ler() {
		
		String textoEntrada = null;
		
		try {
			textoEntrada = entrada.readLine();
		}
		catch (EOFException excecao) { //Exceção de final de arquivo.
			textoEntrada = null;
		}
		catch (IOException excecao) {
			System.out.println("Erro de leitura: " + excecao);
			textoEntrada = null;
		}
		finally {
			return textoEntrada;
		}
	}
}

class PesquisaSequencial {

	public Musica buscarId(Musica[] listaMusicas, String id) {
		
		for (int i = 0; i < listaMusicas.length; i++)
			if (listaMusicas[i].getId().equals(id))
					return listaMusicas[i];
		
		return null;
	}	
}

class Musica {

	private String id;
	private String name;             // nome
	private String key;              // chave
	private String[] artists;        // lista de artistas
	private Date release_date;       // data de lançamento
	private double acousticness;     // acústica
	private double danceability;     // dança
	private double energy;           // energia
	private int duration_ms;         // duração, em milissegundos
	private double instrumentalness; // instrumentalidade
	private double valence;          // valência
	private int popularity;          // popularidade
	private double time;             // tempo
	private double liveness;         // vivacidade 
	private double loudness;         // volume
	private double speechiness;      // discurso
	private int year;                // ano
	
	private int i;                   // índice da string que apresenta todos os dados relacionados a uma música
	
	public Musica(String id, String name, String key, String[] artists, Date release_date, double acousticness, double danceability, double energy, int duration_ms, double instrumentalness, double valence, int popularity, double time, double liveness, double loudness, double speechiness, int year) {
		
		this.id = id;
		this.name = name;
		this.key = key;
		this.artists = artists;
		this.release_date = release_date;
		this.acousticness = acousticness;
		this.danceability = danceability;
		this.energy = energy;
		this.duration_ms = duration_ms;
		this.instrumentalness = instrumentalness;
		this.valence = valence;
		this.popularity = popularity;
		this.time = time;
		this.liveness = liveness;
		this.loudness = loudness;
		this.speechiness = speechiness;
		this.year = year;		
	}
	
	public Musica(String dados) {
		
		i = 0;
		this.valence = Double.parseDouble(getToken(dados));
		this.year = Integer.parseInt(getToken(dados));
		this.acousticness = Double.parseDouble(getToken(dados));
		
		this.artists = getArtistas(dados);
		
		this.danceability = Double.parseDouble(getToken(dados));
		this.duration_ms = Integer.parseInt(getToken(dados));
		this.energy = Double.parseDouble(getToken(dados));
		
		getToken(dados); // saltar campo da string original que não será utilizado
		
		this.id = getToken(dados);
		this.instrumentalness = Double.parseDouble(getToken(dados));
		this.key = getToken(dados);
		this.liveness = Double.parseDouble(getToken(dados));
		this.loudness = Double.parseDouble(getToken(dados));
		
		getToken(dados); // saltar campo da string original que não será utilizado
		
		this.name = getNome(dados);
		
		this.popularity = Integer.parseInt(getToken(dados));
		
		this.release_date = getData(getToken(dados));
		
		this.speechiness = Double.parseDouble(getToken(dados));
		this.time = Double.parseDouble(getToken(dados));
	}
	
	public Musica(){
		id = "";
		name = "";
		key = "";
		acousticness = 0.0;
		danceability = 0.0;
		energy = 0.0;
		duration_ms = 0;
		instrumentalness = 0.0;
		valence = 0.0;
		popularity = 0;
		time = 0.0;
		liveness = 0.0;
		loudness = 0.0;
		speechiness = 0.0;
		year = 0;
	}

	private String getNome(String dados) {
	
		String campo = "";
		boolean terminou = false;
		
		i+=2; // percorrendo a string até encontrar o início do texto.
	
		while (!terminou) {
			if ((dados.charAt(i) == ']') && (dados.charAt(i+1) == '\"') && (dados.charAt(i+2) == ',')) 
				terminou = true;
			else {
				campo += dados.charAt(i);
				i++;
			}
		}
			
		i+=3;
		
		return campo;
	}
	
	private Date getData(String dataString) {
		
		SimpleDateFormat formato;
		String[] dataCampos = dataString.split("-");
		Date data = new Date();
		
		if (dataCampos.length == 1) {
			dataString += "-01-01"; 
		}
		
		formato = new SimpleDateFormat("yyyy-MM-dd"); 
		try {
			data = formato.parse(dataString);
		} catch (ParseException excecao) {
			excecao.getMessage();
		}
		return data;
	}
	
	private String[] getArtistas (String dados) {
		
		String campo = "";
		String[] artistas;
		String nomeArtista = "";
		int inicio = 0;
		int fim;
		
		while (dados.charAt(i) != '[') // percorrendo a string até encontrar o início da lista de artistas.
			i++;
		
		i++;
		
		while (dados.charAt(i) != ']') { // percorrendo a string até encontrar o final da lista de artistas.
			campo += dados.charAt(i);
			i++;
		}
		
		while (dados.charAt(i) != ',') // percorrendo a string até encontrar o separador para o próximo campo.
			i++;
		
		i++;
		
		artistas = campo.split("\',"); // separador entre artistas: ',
	
		for (int j = 0; j < artistas.length; j++) {
			
			nomeArtista = "";
			inicio = 0;
			while ((artistas[j].charAt(inicio) == '\'') || (artistas[j].charAt(inicio) == ' ')) // percorrendo até encontrar o início do nome do artista.
				inicio++;
			
			for (fim = artistas[j].length()-1; (artistas[j].charAt(fim) == '\''); fim--);
			
			while (inicio <= fim) {
				nomeArtista += artistas[j].charAt(inicio);
				inicio++;
			}
			
			artistas[j] = nomeArtista;
		}
		
		return artistas;
	}
	
	private String getToken (String dados) {
	
		String campo = "";
		while ((i < dados.length()) && (dados.charAt(i) != ',')) {
			campo += dados.charAt(i);
			i++;
		}
		i++;
		return campo;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getKey() {
		return key;
	}
	
	public void setKey(String key) {
		this.key = key;
	}
	
	public String[] getArtists() {
		return artists;
	}
	
	public void setArtists(String[] artists) {
		this.artists = artists;
	}
	
	public Date getRelease_date() {
		return release_date;
	}
	
	public void setRelease_date(Date release_date) {
		this.release_date = release_date;
	}
	
	public double getAcousticness() {
		return acousticness;
	}
	
	public void setAcousticness(double acousticness) {
		this.acousticness = acousticness;
	}
	
	public double getDanceability() {
		return danceability;
	}
	
	public void setDanceability(double danceability) {
		this.danceability = danceability;
	}
	
	public double getEnergy() {
		return energy;
	}
	
	public void setEnergy(double energy) {
		this.energy = energy;
	}
	
	public int getDuration_ms() {
		return duration_ms;
	}
	
	public void setDuration_ms(int duration_ms) {
		this.duration_ms = duration_ms;
	}
	
	public double getInstrumentalness() {
		return instrumentalness;
	}
	
	public void setInstrumentalness(double instrumentalness) {
		this.instrumentalness = instrumentalness;
	}
	
	public double getValence() {
		return valence;
	}
	
	public void setValence(double valence) {
		this.valence = valence;
	}
	
	public int getPopularity() {
		return popularity;
	}
	
	public void setPopularity(int popularity) {
		this.popularity = popularity;
	}
	
	public double getTime() {
		return time;
	}
	
	public void setTime(double time) {
		this.time = time;
	}
	
	public double getLiveness() {
		return liveness;
	}
	
	public void setLiveness(double liveness) {
		this.liveness = liveness;
	}
	
	public double getLoudness() {
		return loudness;
	}
	
	public void setLoudness(double loudness) {
		this.loudness = loudness;
	}
	
	public double getSpeechiness() {
		return speechiness;
	}
	
	public void setSpeechiness(double speechiness) {
		this.speechiness = speechiness;
	}
	
	public int getYear() {
		return year;
	}
	
	public void setYear(int year) {
		this.year = year;
	}
	
	public Musica clone() {
	
		Musica copia;
		Date release_date;
		String[] artists = new String[this.artists.length];
		
		for (int i = 0; i < this.artists.length; i++) {
			artists[i] = this.artists[i];
		}
		
		release_date = (Date)this.release_date.clone();
		
		copia = new Musica(this.id, this.name, this.key, artists, release_date, this.acousticness, this.danceability, this.energy, this.duration_ms, this.instrumentalness, this.valence, this.popularity, this.time, this.liveness, this.loudness, this.speechiness, this.year);
		
		return copia;
	}
	
	public void ler() {
	
		int qtdeArtistas;
		String dataString;
		
		System.out.print("Informe o id da musica: ");
		this.id = MyIO.readString();
		
		System.out.print("Informe o nome da música: ");
		this.name = MyIO.readLine();
		
		System.out.print("Informe a chave da música: ");
		this.key = MyIO.readString();
		
		System.out.print("Informe a quantidade de artistas associados a essa música: ");
		qtdeArtistas = MyIO.readInt();
		
		this.artists = new String[qtdeArtistas];
		for (int i = 0; i < qtdeArtistas; i++) {
			System.out.println("Informe o nome do " + (i + 1) + ".o artista associado a essa música: ");
			this.artists[i] = MyIO.readLine();
		}
		
		System.out.print("Informe a data de lançamento da música, no formato yyyy-MM-dd: ");
		dataString = MyIO.readString();
		this.release_date = getData(dataString);
		
		System.out.print("Informe a acústica da música: ");
		this.acousticness = MyIO.readDouble();
		
		System.out.print("Informe a dança da música: ");
		this.danceability = MyIO.readDouble();
		
		System.out.print("Informe a energia da música: ");
		this.energy = MyIO.readDouble();
		
		System.out.print("Informe a duração da música, em milissegundos: ");
		this.duration_ms = MyIO.readInt();
		
		System.out.print("Informe a instrumentabilidade da música: ");
		this.instrumentalness = MyIO.readDouble();
		
		System.out.print("Informe a valência da música: ");
		this.valence = MyIO.readDouble();
		
		System.out.print("Informe a popularidade da música: ");
		this.popularity = MyIO.readInt();
		
		System.out.print("Informe o tempo da música: ");
		this.time = MyIO.readDouble();
		
		System.out.print("Informe a vivacidade da música: ");
		this.liveness = MyIO.readDouble();
		
		System.out.print("Informe o volume da música: ");
		this.loudness = MyIO.readDouble();
		
		System.out.print("Informe o discurso da música: ");
		this.speechiness = MyIO.readDouble();
		
		System.out.print("Informe o ano da música: ");
		this.year = MyIO.readInt();
	}
	
	public void imprimir() {
		
		int j;
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); 
		
		System.out.print(this.id + " ## [");
		for (j = 0; j < (this.artists.length - 1); j++) {
			System.out.print(this.artists[j] + ", ");
		}
		System.out.print(this.artists[j] + "] ## " + this.name + " ## ");
		System.out.print(formato.format(this.release_date));
		System.out.print(" ## " + this.acousticness + " ## " + this.danceability +  " ## " + this.instrumentalness + " ## " + this.liveness + " ## " + this.loudness + " ## " + this.speechiness + " ## " + this.energy + " ## " + this.duration_ms);
	}
}

class Nodo {

	private Musica item;
	private Nodo esquerda;
	private Nodo direita;
	
	Nodo(Musica item) {
		this.item = item;
		this.esquerda = null;
		this.direita = null;
	}

	Nodo() {
		this.item = new Musica();
		this.esquerda = null;
		this.direita = null;
	}
	
	public Musica getItem() {
		return item;
	}
	public void setItem(Musica item) {
		this.item = item;
	}
	
	public Nodo getEsquerda() {
		return esquerda;
	}
	public void setEsquerda(Nodo esquerda) {
		this.esquerda = esquerda;
	}
	
	public Nodo getDireita() {
		return direita;
	}
	public void setDireita(Nodo direita) {
		this.direita = direita;
	}
}

class ABB {

	private int comparacoes;
	private Nodo raiz;
	
	ABB() {
		this.raiz = null;
		this.comparacoes = 0;
	}

        public int getComparacoes() {
            return comparacoes;
        }
	
	public boolean arvoreVazia() {
		
		boolean resp;
		
		if (raiz == null)
			resp = true;
		else
			resp = false;
		
		return resp;
	}
	
	public Musica pesquisar(String chavePesquisa) {
		return pesquisar(this.raiz, chavePesquisa);
	}
	
	private Musica pesquisar(Nodo raizSubarvore, String chavePesquisa) {

		Musica pesquisado;
		
		if (raizSubarvore == null){
			pesquisado = null;
		}else if (raizSubarvore.getItem().getName().equals(chavePesquisa)){
			MyIO.print("[" + raizSubarvore.getItem().getName() + "] - ");
			pesquisado = raizSubarvore.getItem();
		}else if (chavePesquisa.compareTo(raizSubarvore.getItem().getName()) < 0){
			MyIO.print("[" + raizSubarvore.getItem().getName() + "] - ");
			pesquisado = pesquisar(raizSubarvore.getEsquerda(), chavePesquisa);
		}else{
			MyIO.print("[" + raizSubarvore.getItem().getName() + "] - ");
			pesquisado = pesquisar(raizSubarvore.getDireita(), chavePesquisa);
		}
		return pesquisado;
	}	
	
	public void inserir(Musica item) throws Exception {
		this.raiz = inserir(this.raiz, item);
	}
	
	private Nodo inserir(Nodo raizSubarvore, Musica item) throws Exception {

		this.comparacoes++;

		if (raizSubarvore == null)
			raizSubarvore = new Nodo(item);
		else if (raizSubarvore.getItem().getName() == item.getName())
			throw new Exception ("Não foi possível inserir o item na árvore: o item já foi inserido anteriormente!");
		else if (raizSubarvore.getItem().getName().compareTo(item.getName()) > 0)
			raizSubarvore.setEsquerda(inserir(raizSubarvore.getEsquerda(), item));
		else if (raizSubarvore.getItem().getName().compareTo(item.getName()) < 0)
			raizSubarvore.setDireita(inserir(raizSubarvore.getDireita(), item));
		
		System.out.println(item.getName());

		return raizSubarvore;
	}
	
    private Nodo antecessor(Nodo noRetirar, Nodo raizSubarvore) {
       
        if (raizSubarvore.getDireita() != null)

            raizSubarvore.setDireita(antecessor(noRetirar, raizSubarvore.getDireita()));
       
        else {
            noRetirar.setItem(raizSubarvore.getItem());
           
            raizSubarvore = raizSubarvore.getEsquerda();
        }
        
        return raizSubarvore;
    }
  
    private Nodo remover(Nodo raizSubarvore, String chaveRemover) throws Exception {
    	
        if (raizSubarvore == null) 
        	throw new Exception ("Não foi possível remover o item da árvore: o item não foi encontrado na árvore!");
      
        else if (raizSubarvore.getItem().getName().compareTo(chaveRemover) == 0) {
        	
                if (raizSubarvore.getDireita() == null)
                    raizSubarvore = raizSubarvore.getEsquerda();
                
                else if (raizSubarvore.getEsquerda() == null)
                	raizSubarvore = raizSubarvore.getDireita();
                
                else
                	raizSubarvore.setEsquerda(antecessor(raizSubarvore, raizSubarvore.getEsquerda()));
        } else {

                if (raizSubarvore.getItem().getName().compareTo(chaveRemover) > 0)
                    raizSubarvore.setEsquerda(remover(raizSubarvore.getEsquerda(), chaveRemover));
                else

                    raizSubarvore.setDireita(remover(raizSubarvore.getDireita(), chaveRemover));
        }

        return raizSubarvore;
    }

    public void remover(String chaveRemover) throws Exception {

        this.raiz = remover(this.raiz, chaveRemover);
    }
    
    public void imprimirEmOrdem() throws Exception {
    	
    	if (arvoreVazia())
    		throw new Exception("A árvore está vazia!");
    	else
    		imprimirEmOrdem(this.raiz);
    }
    
    private void imprimirEmOrdem(Nodo raizSubarvore) {
    	
    	if (raizSubarvore != null) {
    		imprimirEmOrdem(raizSubarvore.getEsquerda());
    		raizSubarvore.getItem().imprimir();
    		imprimirEmOrdem(raizSubarvore.getDireita());
    	}
    }
}

//Main
public class Exerc03 {

	public static int contarTotalMusicas() {
	
		int numMusicas = 0;
		ArquivoTextoLeitura arquivoMusicas = new ArquivoTextoLeitura("/tmp/dataAEDs.csv");
		
		while (arquivoMusicas.ler() != null)
			numMusicas++;
		
		arquivoMusicas.fecharArquivo();
		
		return numMusicas;
	}
	
	public static void lerMusicas(Musica[] listaMusicas) {
		
		ArquivoTextoLeitura arquivoMusicas = new ArquivoTextoLeitura("/tmp/dataAEDs.csv");
		int i = 0;
		String dadosMusica;
		
		dadosMusica = arquivoMusicas.ler();
		while ((dadosMusica = arquivoMusicas.ler()) != null) {
			
			listaMusicas[i] = new Musica(dadosMusica);
			i++;
		}
	
		arquivoMusicas.fecharArquivo();
	}
	
	public static void main(String[] args) throws Exception {

		//Trocando o Charset para leitura de acentos
		MyIO.setCharset("UTF-8");

		//Tempo de início do algoritmo
		long tempoInicio = System.currentTimeMillis();  
		
		//Coletando total de músicas para criação do vetor "listaMusicas"
		int numTotalMusicas = contarTotalMusicas();
		//Criação de um vetor para armazenar todas as músicas
		Musica[] listaMusicas = new Musica[numTotalMusicas];
		//Variável que irá guardar a música pesquisada
		Musica pesquisado;
		//Classe que realiza a pesquisa da música no arquivo CSV através do ID
		PesquisaSequencial pesquisa = new PesquisaSequencial();
		//Variável que irá guardar o ID da música a ser pesquisada
		String id;
		//Coletando todas as músicas no CSV e armazenando dentro de "listaMusicas"
		lerMusicas(listaMusicas);
		//Instanciando árvore binária
		ABB arvoreBinaria = new ABB();
		Musica arvoreBinariaPesquisa;

		id = MyIO.readLine();
		while (!id.equals("FIM")) {
			pesquisado = pesquisa.buscarId(listaMusicas, id);
			arvoreBinaria.inserir(pesquisado);
			id = MyIO.readLine();
		}
		id = MyIO.readLine();
		while (!id.equals("FIM")){
			arvoreBinariaPesquisa = arvoreBinaria.pesquisar(id);
			if (arvoreBinariaPesquisa != null) {
				MyIO.println("SIM");
			} else {
				MyIO.println("NAO");
			}
			id = MyIO.readLine();
		};

		/** Gerando arquivo log **/
		String path = "\\";
		try {
			File log = new File(path + "722838_arvoreBinaria.txt");
			log.createNewFile();
		} catch (IOException e) {
			System.err.println("Não foi possível criar o arquivo!");
		}

		long tempoFinal = System.currentTimeMillis();  

		try {
			FileWriter logWriter = new FileWriter(path + "722838_arvoreBinaria.txt", true);
			logWriter.write("722838\t" + (tempoFinal-tempoInicio) + "\t" + arvoreBinaria.getComparacoes());
			logWriter.close();
		} catch (IOException e) {
			System.err.print("Erro ao gerar arquivo");
		}

	}

}
