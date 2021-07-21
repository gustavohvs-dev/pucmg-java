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
		} catch (FileNotFoundException excecao) {
			System.out.println("Arquivo n�o encontrado");
		}
	}

	public void fecharArquivo() {

		try {
			entrada.close();
		} catch (IOException excecao) {
			System.out.println("Erro no fechamento do arquivo de leitura: " + excecao);
		}
	}

	@SuppressWarnings("finally")
	public String ler() {

		String textoEntrada = null;

		try {
			textoEntrada = entrada.readLine();
		} catch (EOFException excecao) { // Exce��o de final de arquivo.
			textoEntrada = null;
		} catch (IOException excecao) {
			System.out.println("Erro de leitura: " + excecao);
			textoEntrada = null;
		} finally {
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

	public Musica buscarNome(Musica[] listaMusicas, String nome) {

		for (int i = 0; i < listaMusicas.length; i++)
			if (listaMusicas[i].getName().equals(nome))
				return listaMusicas[i];

		return null;
	}
}

class Musica {

	private String id;
	private String name; // nome
	private String key; // chave
	private String[] artists; // lista de artistas
	private Date release_date; // data de lan�amento
	private double acousticness; // ac�stica
	private double danceability; // dan�a
	private double energy; // energia
	private int duration_ms; // dura��o, em milissegundos
	private double instrumentalness; // instrumentalidade
	private double valence; // val�ncia
	private int popularity; // popularidade
	private double time; // tempo
	private double liveness; // vivacidade
	private double loudness; // volume
	private double speechiness; // discurso
	private int year; // ano

	private int i; // �ndice da string que apresenta todos os dados relacionados a uma m�sica

	public Musica(String id, String name, String key, String[] artists, Date release_date, double acousticness,
			double danceability, double energy, int duration_ms, double instrumentalness, double valence,
			int popularity, double time, double liveness, double loudness, double speechiness, int year) {

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

		getToken(dados); // saltar campo da string original que n�o ser� utilizado

		this.id = getToken(dados);
		this.instrumentalness = Double.parseDouble(getToken(dados));
		this.key = getToken(dados);
		this.liveness = Double.parseDouble(getToken(dados));
		this.loudness = Double.parseDouble(getToken(dados));

		getToken(dados); // saltar campo da string original que n�o ser� utilizado

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

		i += 2; // percorrendo a string at� encontrar o in�cio do texto.

		while (!terminou) {
			if ((dados.charAt(i) == ']') && (dados.charAt(i + 1) == '\"') && (dados.charAt(i + 2) == ','))
				terminou = true;
			else {
				campo += dados.charAt(i);
				i++;
			}
		}

		i += 3;

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

	private String[] getArtistas(String dados) {

		String campo = "";
		String[] artistas;
		String nomeArtista = "";
		int inicio = 0;
		int fim;

		while (dados.charAt(i) != '[') // percorrendo a string at� encontrar o in�cio da lista de artistas.
			i++;

		i++;

		while (dados.charAt(i) != ']') { // percorrendo a string at� encontrar o final da lista de artistas.
			campo += dados.charAt(i);
			i++;
		}

		while (dados.charAt(i) != ',') // percorrendo a string at� encontrar o separador para o pr�ximo campo.
			i++;

		i++;

		artistas = campo.split("\',"); // separador entre artistas: ',

		for (int j = 0; j < artistas.length; j++) {

			nomeArtista = "";
			inicio = 0;
			while ((artistas[j].charAt(inicio) == '\'') || (artistas[j].charAt(inicio) == ' ')) // percorrendo at�
																								// encontrar o in�cio do
																								// nome do artista.
				inicio++;

			for (fim = artistas[j].length() - 1; (artistas[j].charAt(fim) == '\''); fim--)
				;

			while (inicio <= fim) {
				nomeArtista += artistas[j].charAt(inicio);
				inicio++;
			}

			artistas[j] = nomeArtista;
		}

		return artistas;
	}

	private String getToken(String dados) {

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

		release_date = (Date) this.release_date.clone();

		copia = new Musica(this.id, this.name, this.key, artists, release_date, this.acousticness, this.danceability,
				this.energy, this.duration_ms, this.instrumentalness, this.valence, this.popularity, this.time,
				this.liveness, this.loudness, this.speechiness, this.year);

		return copia;
	}

	public void ler() {

		int qtdeArtistas;
		String dataString;

		System.out.print("Informe o id da musica: ");
		this.id = MyIO.readString();

		System.out.print("Informe o nome da m�sica: ");
		this.name = MyIO.readLine();

		System.out.print("Informe a chave da m�sica: ");
		this.key = MyIO.readString();

		System.out.print("Informe a quantidade de artistas associados a essa m�sica: ");
		qtdeArtistas = MyIO.readInt();

		this.artists = new String[qtdeArtistas];
		for (int i = 0; i < qtdeArtistas; i++) {
			System.out.println("Informe o nome do " + (i + 1) + ".o artista associado a essa m�sica: ");
			this.artists[i] = MyIO.readLine();
		}

		System.out.print("Informe a data de lan�amento da m�sica, no formato yyyy-MM-dd: ");
		dataString = MyIO.readString();
		this.release_date = getData(dataString);

		System.out.print("Informe a ac�stica da m�sica: ");
		this.acousticness = MyIO.readDouble();

		System.out.print("Informe a dan�a da m�sica: ");
		this.danceability = MyIO.readDouble();

		System.out.print("Informe a energia da m�sica: ");
		this.energy = MyIO.readDouble();

		System.out.print("Informe a dura��o da m�sica, em milissegundos: ");
		this.duration_ms = MyIO.readInt();

		System.out.print("Informe a instrumentabilidade da m�sica: ");
		this.instrumentalness = MyIO.readDouble();

		System.out.print("Informe a val�ncia da m�sica: ");
		this.valence = MyIO.readDouble();

		System.out.print("Informe a popularidade da m�sica: ");
		this.popularity = MyIO.readInt();

		System.out.print("Informe o tempo da m�sica: ");
		this.time = MyIO.readDouble();

		System.out.print("Informe a vivacidade da m�sica: ");
		this.liveness = MyIO.readDouble();

		System.out.print("Informe o volume da m�sica: ");
		this.loudness = MyIO.readDouble();

		System.out.print("Informe o discurso da m�sica: ");
		this.speechiness = MyIO.readDouble();

		System.out.print("Informe o ano da m�sica: ");
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
		System.out.print(" ## " + this.acousticness + " ## " + this.danceability + " ## " + this.instrumentalness
				+ " ## " + this.liveness + " ## " + this.loudness + " ## " + this.speechiness + " ## " + this.energy
				+ " ## " + this.duration_ms);
	}
}

class Celula {
	
    private Musica item;
	private Celula proximo;
	
	Celula(Musica item) {
		this.item = item;
		this.proximo = null;
	}
	
	Celula() {
		this.item = new Musica();
		this.proximo = null;
	}
	
	public Musica getItem() {
		return item;
	}
	
	public void setItem(Musica item) {
		this.item = item;
	}
	
	public Celula getProximo() {
		return proximo;
	}
	
	public void setProximo(Celula proximo) {
		this.proximo = proximo;
	}

}

class ListaEncadeada {

	private Celula primeiro;
	private Celula ultimo;
	private int tamanho;
	
	ListaEncadeada() {
	
		Celula sentinela;
		
		sentinela = new Celula();
		primeiro = sentinela;
		ultimo = sentinela;
		tamanho = 0;
	}
	
	public boolean listaVazia() {
		
		boolean resp;
		
		if (primeiro == ultimo)
			resp = true;
		else
			resp = false;
		
		return resp;
	}
	
	public void inserir (Musica item, int posicao) throws Exception {
		
		Celula aux;
		Celula nova;
		Celula proxima;
		int i;
		
		if ((posicao >= 0) && (posicao <= tamanho)) {
			for (i = 0, aux = primeiro; i < posicao; i++)
				aux = aux.getProximo();
				
			nova = new Celula(item);
			
			proxima = aux.getProximo();
			aux.setProximo(nova);
			nova.setProximo(proxima);
				
			if (posicao == tamanho)
				ultimo = nova;
				
			tamanho++;
		} else
			throw new Exception ("Não foi possível inserir o item na lista: posição inválida!");
	}
	
	public Musica retirar (int posicao) throws Exception {
		
		Celula aux;
		Celula retirada;
		Celula proxima;
		Musica item = null;
		
		int i;
		
		if (! listaVazia() ) {
			if ((posicao >= 0) && (posicao < tamanho)) {
				for (i = 0, aux = primeiro; i < posicao; i++)
					aux = aux.getProximo();
				
				retirada = aux.getProximo();
				
				proxima = retirada.getProximo();
				
				aux.setProximo(proxima);
				
				if (ultimo == retirada)
					ultimo = aux;
				
				tamanho--;
				
				item = retirada.getItem();
				
			} else
				throw new Exception ("Não foi possível retirar o item da lista: posição inválida!");
		} else
			throw new Exception ("Não foi possível retirar o item da lista: a lista está vazia!");
	
		return item;
	}
	
	public Musica pesquisar(int dado) {
	    
    	Celula aux;
    	
    	aux = primeiro.getProximo();
    	
    	while (aux != null) {
    		if (aux.getItem().getDuration_ms() == dado) {
    			return aux.getItem();
    		}
    		aux = aux.getProximo();
    	}
    	return null;
    }
	
	public void imprimir() throws Exception {
		
		Celula aux;
		
		if (! listaVazia() ) {
			aux = primeiro.getProximo();
			while (aux != null) {
				aux.getItem().imprimir();
				aux = aux.getProximo();
			}
		} else
			throw new Exception ("A lista está vazia!");
	}
}

class TabelaHash {

	private int M;  // tamanho da tabela hash
	private ListaEncadeada[] tabelaHash;
	public int comparacoes;
	
	TabelaHash(int tamanho) {
		
		this.M = tamanho;
		
		tabelaHash = new ListaEncadeada[this.M];
		for (int i = 0; i < this.M; i++)
			tabelaHash[i] = new ListaEncadeada();
	}
	
	// h(chave) = chave mod tamanho da tabela hash
	private int funcaoTransformacao(int chave) {
		return (chave % this.M);
	}
	
	public void inserir(Musica novo) throws Exception {
		
		int posicao;
		
		posicao = funcaoTransformacao(novo.getDuration_ms());
		
		if (tabelaHash[posicao].pesquisar(novo.getDuration_ms()) == null)
			tabelaHash[posicao].inserir(novo, 0);
		//else
			//throw new Exception("Erro ao tentar inserir o elemento de chave " + novo.getDuration_ms() + " na tabela hash: o elemento já foi inserido anteriormente!");
	}
	
	public Musica pesquisar(int chave) {
		
		int posicao;
		
		posicao = funcaoTransformacao(chave);
		comparacoes++;

		if(tabelaHash[posicao].pesquisar(chave) != null){
			System.out.println(posicao + " SIM");
		}else{
			System.out.println("NAO");
		}
		
		return (tabelaHash[posicao].pesquisar(chave));
	}
	
	public void imprimir() {
		
		for (int i = 0; i < this.M; i++)
			if (! tabelaHash[i].listaVazia()) {
				System.out.println("Posição [" + i + "]:");
				try {
					tabelaHash[i].imprimir();
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
			else
				System.out.println("Posição [" + i + "] da tabela hash está vazia!");
	}
}

// Main
public class Exerc06 {

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

		// Trocando o Charset para leitura de acentos
		MyIO.setCharset("UTF-8");
		long tempoInicio = System.currentTimeMillis();  
		// Coletando total de m�sicas para cria��o do vetor "listaMusicas"
		int numTotalMusicas = contarTotalMusicas();
		// Cria��o de um vetor para armazenar todas as m�sicas
		Musica[] listaMusicas = new Musica[numTotalMusicas];
		// Vari�vel que ir� guardar a m�sica pesquisada
		Musica pesquisado;
		// Classe que realiza a pesquisa da m�sica no arquivo CSV atrav�s do ID
		PesquisaSequencial pesquisa = new PesquisaSequencial();
		// Vari�vel que ir� guardar o ID da m�sica a ser pesquisada
		String id;
		// Coletando todas as m�sicas no CSV e armazenando dentro de "listaMusicas"
		lerMusicas(listaMusicas);
		
		TabelaHash meuHash = new TabelaHash(233);
		Musica aux;

		id = MyIO.readLine();
		while (!id.equals("FIM")) {
			pesquisado = pesquisa.buscarId(listaMusicas, id);
			meuHash.inserir(pesquisado);
			id = MyIO.readLine();
		}

		id = MyIO.readLine();
		while (!id.equals("FIM")) {
			pesquisado = pesquisa.buscarNome(listaMusicas, id);
			aux = meuHash.pesquisar(pesquisado.getDuration_ms());
			id = MyIO.readLine();
		}

		/** Gerando arquivo log **/
		String path = "\\";
		try {
			File log = new File(path + "722838_hashSeparado.txt");
			log.createNewFile();
		} catch (IOException e) {
			System.err.println("Não foi possível criar o arquivo!");
		}

		long tempoFinal = System.currentTimeMillis();

		try {
			FileWriter logWriter = new FileWriter(path + "722838_hashSeparado.txt", true);
			logWriter.write(
					"722838\t" + (tempoFinal - tempoInicio) + "\t" + meuHash.comparacoes);
			logWriter.close();
		} catch (IOException e) {
			System.err.print("Erro ao gerar arquivo");
		}

	}

	

}