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
	
	public static void main(String[] args) {
		
		int numTotalMusicas = contarTotalMusicas(); //Devolve o total de mÃºsicas para criaÃ§Ã£o da pilha
		Musica[] listaMusicas = new Musica[numTotalMusicas];
		Lista lista = new Lista(numTotalMusicas); //Criando lista
		Musica pesquisado; //Criando uma variÃ¡vel para armazenar a mÃºsica pesquisada
		PesquisaSequencial pesquisa = new PesquisaSequencial(); //Realiza a pesquisa no arquivo .csv
		String id; //Criando uma variÃ¡vel para armazenar o id temporÃ¡rio a ser pesquisado
		String[] splitString; //Armazena em um vetor o resultado do split da linha lida
		
		lerMusicas(listaMusicas); //Realiza a leitura das mÃºsicas
		
		id = MyIO.readLine(); //LÃª a primeira linha
		while (!id.equals("FIM")) {
			pesquisado = pesquisa.buscarId(listaMusicas, id); //Busca a mÃºsica na lista de mÃºsicas pelo ID informado
			lista.inserirFim(pesquisado); //Empilha item pesquisado
			id = MyIO.readLine(); //LÃª a prÃ³xima linha atÃ© encontrar a palavra FIM
		}
		id = MyIO.readLine(); //LÃª a linha referente a quantidade de linhas a serem lidas posteriormente
		int numberOfLinesRemaining = Integer.parseInt(id); //Converte o valor lido para inteiro
		for (int i=0; i < numberOfLinesRemaining; i++) {
			id = MyIO.readLine();
			if ((id.charAt(0) == 'I') && (id.charAt(1) == 'I')) {
				splitString = id.split(" ");
				pesquisado = pesquisa.buscarId(listaMusicas, splitString[1]);
				lista.inserirInicio(pesquisado);
			} else if ((id.charAt(0) == 'I') && (id.charAt(1) == '*')) {
				splitString = id.split(" ");
				pesquisado = pesquisa.buscarId(listaMusicas, splitString[2]);
				lista.inserir(pesquisado, Integer.parseInt(splitString[1]));
			} else if ((id.charAt(0) == 'I') && (id.charAt(1) == 'F')) {
				splitString = id.split(" ");
				pesquisado = pesquisa.buscarId(listaMusicas, splitString[1]);
				lista.inserirFim(pesquisado);
			} else if ((id.charAt(0) == 'R') && (id.charAt(1) == 'I')) {
				System.out.println("(R) " + lista.removerInicio().getName());
			} else if ((id.charAt(0) == 'R') && (id.charAt(1) == '*')) {
				splitString = id.split(" ");
				System.out.println("(R) " + lista.remover(Integer.parseInt(splitString[1])).getName());
			} else if ((id.charAt(0) == 'R') && (id.charAt(1) == 'F')) {
				System.out.println("(R) " + lista.removerFim().getName());
			}
		}
		lista.mostrar();
	}
}

class Lista {

	private Musica musicas[];
	private int primeiro;
	private int ultimo;
	private int tamanho;

	public Lista(int tamanho) {
		musicas = new Musica[tamanho];
		primeiro = 0;
		ultimo = 0;
		this.tamanho = tamanho;
	}

	public Lista() {
		musicas = new Musica[Integer.MAX_VALUE];
		primeiro = 0;
		ultimo = 0;
		this.tamanho = Integer.MAX_VALUE;
	}
	
	public boolean listaCheia() {
		boolean resultado = false;
		if (ultimo == tamanho) {
			resultado = true;
		}
		return resultado;
	}
	
	public boolean listaVazia() {
		boolean resultado = false;
		if (primeiro == ultimo) {
			resultado = true;
		}	
		return resultado;
	}
	
	public void inserirInicio(Musica musica) {
		if (!listaCheia()) {
			for (int i = ultimo; i > 0; i--) {
				musicas[i] = musicas[i - 1];
			}
			musicas[0] = musica;
			ultimo++;
		}
	} 

	public void inserir(Musica musica, int posicao) {
		if (!listaCheia()) {
			if ((posicao >= 0) && (posicao <= ultimo)) {
				for (int i = ultimo; i > posicao; i--) {
					musicas[i] = musicas[i - 1];
				}				
				musicas[posicao] = musica;
				ultimo++;
			}
		}
	}

	public void inserirFim(Musica musica) {
		if (!listaCheia()) {
			musicas[ultimo] = musica;	
			ultimo++;
		}
	}

	public Musica removerInicio() {
		Musica removido = musicas[0];
		if (!listaVazia()) {
			ultimo--;
			for (int i = 0; i < ultimo; i++) {
				musicas[i] = musicas[i + 1];
			}
		}
		return removido;
	}
	
	public Musica remover(int posicao) {
		Musica removido = musicas[posicao];
		if (!listaVazia()) {
			if ((posicao >= 0) && (posicao < ultimo)) {
				removido = musicas[posicao];
				ultimo--;
				for (int i = posicao; i < ultimo; i++)
					musicas[i] = musicas[i + 1];
			}
		}
		return removido;
	}

	public Musica removerFim() {
		Musica removido = null;
		if (!listaVazia()) {
			ultimo--;
			removido = musicas[ultimo];
		}
		return removido;
	}
	
	public void mostrar() {
		int tempPos = 0;
		if (!listaVazia()) {
			for (int i = primeiro; i < ultimo; i++) {
				System.out.printf("[%d]", tempPos);
				musicas[i].imprimir();
				System.out.printf("\n");
				tempPos++;
			}
		}
	}
}