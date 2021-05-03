
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

class Musica {

    private String id, name, key;
    private String[] artists = new String[40];
    private int numArtists, duration_ms, popularity, year;
    private Date release_date;
    private double acousticness, danceability, energy, dinstrumentalness, instrumentalness, valence, time, liveness, loudness, speechiness;

    public Musica() {
        this.id = "";
        this.name = "";
        this.key = "";
        this.acousticness = 0.0;
        this.danceability = 0.0;
        this.energy = 0.0;
        this.duration_ms = 0;
        this.instrumentalness = 0.0;
        this.valence = 0.0;
        this.popularity = 0;
        this.time = 0.0;
        this.liveness = 0.0;
        this.loudness = 0.0;
        this.speechiness = 0.0;
        this.year = 0;
        this.release_date = null;
    }

    public Musica(String id, String name, String key, Date release_date, double acousticness, double danceability, double energy, int duration_ms, double instrumentalness, double valence, int popularity, double time, double liveness, double loudness, double speechiness, int year) {
        this.id = id;
        this.name = name;
        this.key = key;
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
        this.release_date = release_date;
    }
    // GETs e SETs   

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getKey() {
        return this.key;
    }

    public Date getReleaseDate() {
        return this.release_date;
    }

    public double getAcousticness() {
        return this.acousticness;
    }

    public double getDanceability() {
        return this.danceability;
    }

    public double getEnergy() {
        return this.energy;
    }

    public int getDuration_ms() {
        return this.duration_ms;
    }

    public double getInstrumentalness() {
        return this.instrumentalness;
    }

    public double getValence() {
        return this.valence;
    }

    public int getPopularity() {
        return this.popularity;
    }

    public double getTime() {
        return this.time;
    }

    public double getLiveness() {
        return this.liveness;
    }

    public double getLoudness() {
        return this.loudness;
    }

    public double getSpeechiness() {
        return this.speechiness;
    }

    public int getYear() {
        return this.year;
    }

    private class CampoCsv {

        String campo = "";
        int indiceFinal;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setReleaseDate(Date release_date) {
        this.release_date = release_date;
    }

    public void setAcousticness(double acousticness) {
        this.acousticness = acousticness;
    }

    public void setDanceability(double danceability) {
        this.danceability = danceability;
    }

    public void setEnergy(double energy) {
        this.energy = energy;
    }

    public void setDuration_ms(int duration_ms) {
        this.duration_ms = duration_ms;
    }

    public void setInstrumentalness(double instrumentalness) {
        this.instrumentalness = instrumentalness;
    }

    public void setValence(double valence) {
        this.valence = valence;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public void setLiveness(double liveness) {
        this.liveness = liveness;
    }

    public void setLoudness(double loudness) {
        this.loudness = loudness;
    }

    public void setSpeechiness(double speechiness) {
        this.speechiness = speechiness;
    }

    public void setYear(int year) {
        this.year = year;
    }

    private CampoCsv lerCampoCsvComAspas(String linha, int indiceInicial) {
        CampoCsv campocsv = new CampoCsv();
        indiceInicial++;
        while (indiceInicial < linha.length()) {
            if (linha.charAt(indiceInicial) == '"') {
                if (linha.charAt(indiceInicial + 1) == '"') {
                    campocsv.campo += '"';
                    indiceInicial += 2;
                } else {
                    indiceInicial++;
                    break;
                }
            } else {
                campocsv.campo += linha.charAt(indiceInicial++);
            }
        }
        campocsv.indiceFinal = indiceInicial;
        return campocsv;
    }

    private CampoCsv lerCampoCsv(String linha, int indiceInicial) {
        if (linha.charAt(indiceInicial) == '"') {
            return lerCampoCsvComAspas(linha, indiceInicial);
        }

        CampoCsv campocsv = new CampoCsv();
        while (indiceInicial < linha.length() && linha.charAt(indiceInicial) != ',') {
            campocsv.campo += linha.charAt(indiceInicial++);
        }

        campocsv.indiceFinal = indiceInicial;
        return campocsv;
    }

    private double handlePercentage(double valor) {
        return Math.ceil(valor) == valor ? valor / 100 : valor;
    }

    private CampoCsv lerArtista(String artistas, int indiceInicial) {
        CampoCsv campocsv = new CampoCsv();
        char delimiter = artistas.charAt(indiceInicial++);

        while (artistas.charAt(indiceInicial) != delimiter) {
            if (artistas.charAt(indiceInicial) == '\\') {
                indiceInicial++;
            }
            campocsv.campo += artistas.charAt(indiceInicial++);
        }

        campocsv.indiceFinal = indiceInicial + 1;
        return campocsv;
    }

    private void lerArtistas(String artistas) {
        int i = 0;
        CampoCsv campoArtista = new CampoCsv();
        campoArtista.indiceFinal = 1;
        while (true) {
            campoArtista = lerArtista(artistas, campoArtista.indiceFinal);
            this.artists[i++] = campoArtista.campo;
            if (artistas.charAt(campoArtista.indiceFinal) == ']') {
                break;
            }
            campoArtista.indiceFinal += 2;
        }
        numArtists = i;
    }

    private void lerReleaseDate(String data) {
        if (data.length() == 4) {
            data += "-01-01";
        }
        try {
            java.util.Date date = new SimpleDateFormat("yyyy-MM-dd").parse(data);
            release_date = new Date(date.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    // Leitura 
    public Musica ler(String linha) {
        CampoCsv campocsv = lerCampoCsv(linha, 0);
        setValence(handlePercentage(Double.parseDouble(campocsv.campo)));

        campocsv = lerCampoCsv(linha, campocsv.indiceFinal + 1);
        setYear(Integer.parseInt(campocsv.campo));

        campocsv = lerCampoCsv(linha, campocsv.indiceFinal + 1);
        setAcousticness(handlePercentage(Double.parseDouble(campocsv.campo)));

        campocsv = lerCampoCsv(linha, campocsv.indiceFinal + 1);
        lerArtistas(campocsv.campo);

        campocsv = lerCampoCsv(linha, campocsv.indiceFinal + 1);
        setDanceability(handlePercentage(Double.parseDouble(campocsv.campo)));

        campocsv = lerCampoCsv(linha, campocsv.indiceFinal + 1);
        setDuration_ms(Integer.parseInt(campocsv.campo));

        campocsv = lerCampoCsv(linha, campocsv.indiceFinal + 1);
        setEnergy(handlePercentage(Double.parseDouble(campocsv.campo)));

        campocsv = lerCampoCsv(linha, campocsv.indiceFinal + 1); // Skip 'explicit' column

        campocsv = lerCampoCsv(linha, campocsv.indiceFinal + 1);
        setId(campocsv.campo);

        campocsv = lerCampoCsv(linha, campocsv.indiceFinal + 1);
        setInstrumentalness(handlePercentage(Double.parseDouble(campocsv.campo)));

        campocsv = lerCampoCsv(linha, campocsv.indiceFinal + 1);
        setKey(campocsv.campo);

        campocsv = lerCampoCsv(linha, campocsv.indiceFinal + 1);
        setLiveness(handlePercentage(Double.parseDouble(campocsv.campo)));

        campocsv = lerCampoCsv(linha, campocsv.indiceFinal + 1);
        setLoudness(Double.parseDouble(campocsv.campo));

        campocsv = lerCampoCsv(linha, campocsv.indiceFinal + 1); // Skip 'mode' column

        campocsv = lerCampoCsv(linha, campocsv.indiceFinal + 1);
        setName(campocsv.campo);

        campocsv = lerCampoCsv(linha, campocsv.indiceFinal + 1);
        setPopularity(Integer.parseInt(campocsv.campo));

        campocsv = lerCampoCsv(linha, campocsv.indiceFinal + 1);
        lerReleaseDate(campocsv.campo);

        campocsv = lerCampoCsv(linha, campocsv.indiceFinal + 1);
        setSpeechiness(handlePercentage(Double.parseDouble(campocsv.campo)));

        campocsv = lerCampoCsv(linha, campocsv.indiceFinal + 1);
        setTime(Double.parseDouble(campocsv.campo));

        return this;
    }

    // CLONE   
    public void clonar(Musica musica) {
        this.id = musica.getId();
        this.name = musica.getName();
        this.key = musica.key;
        this.artists = Arrays.copyOf(musica.artists, musica.artists.length);
        this.numArtists = musica.numArtists;
        this.release_date = musica.getReleaseDate();
        this.acousticness = musica.getAcousticness();
        this.danceability = musica.getDanceability();
        this.energy = musica.getEnergy();
        this.duration_ms = musica.getDuration_ms();
        this.instrumentalness = musica.getInstrumentalness();
        this.valence = musica.getValence();
        this.popularity = musica.getPopularity();
        this.time = musica.getTime();
        this.liveness = musica.getLiveness();
        this.loudness = musica.getLoudness();
        this.speechiness = musica.getSpeechiness();
        this.year = musica.getYear();
    }

    private String toStringArtists() {
        String artistsStr = "[";
        if (numArtists > 0) {
            artistsStr += artists[0];
            for (int i = 1; i < numArtists; i++) {
                artistsStr += ", " + artists[i];
            }
        }
        return artistsStr + "]";
    }

    public String toString() {
        return String.format(
                "%s ## %s ## %s ## %s ## %s ## %s ## %s ## %s ## %s ## %s ## %s ## %d",
                id,
                toStringArtists(),
                name,
                new SimpleDateFormat("dd/MM/yyyy").format(release_date),
                "" + acousticness,
                "" + danceability,
                "" + instrumentalness,
                "" + liveness,
                "" + loudness,
                "" + speechiness,
                "" + energy,
                duration_ms
        );
    }

    public void imprimir() {
        MyIO.println(toString());
    }
}

public class Exerc04 {

    public static String[] ids = new String[170630];
    public static Musica[] musicas;
    public static int numMusicas;
    public static int comparacoes;
    public static int movimentacoes;
    public static long startTime;
    public static long endTime;

    public static void lerIds() {
        numMusicas = 0;
        String linha = MyIO.readLine();
        while (!linha.startsWith("FIM")) {
            ids[numMusicas++] = linha;
            linha = MyIO.readLine();
        }
    }

    public static boolean musicaNaEntrada(String linha) {
        for (int i = 0; i < numMusicas; i++) {
            if (linha.contains(ids[i])) {
                return true;
            }
        }
        return false;
    }

    public static void lerMusicas() {
        musicas = new Musica[numMusicas];
        int i = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader("/tmp/data.csv"))) {
            String linha = reader.readLine();
            linha = reader.readLine();
            while (i < numMusicas) {
                if (musicaNaEntrada(linha)) {
                    musicas[i++] = new Musica().ler(linha);
                }
                linha = reader.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Musica obterMusicaPorId(String id) {
        for (Musica musica : musicas) {
            if (musica.getId().equals(id)) {
                return musica;
            }
        }
        return null;
    }

    public static void criarLog() {
        String matricula = "712881";
        String nomeArquivo = String.format("%s_heapsort.txt", matricula);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
            writer.write(
                    String.format(
                            "%s\t%d\t%d\t%d", matricula, endTime - startTime, comparacoes, movimentacoes
                    )
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MyIO.setCharset("UTF-8");
        lerIds();
        lerMusicas();
        startTime = System.currentTimeMillis();
        heapsort(Exerc04.musicas);
        endTime = System.currentTimeMillis();
        for (Musica musica : musicas) {
            musica.imprimir();
        }
        criarLog();
    }

    public static void heapsort( Musica [ ] musica )
    {
        for( int i = musica.length / 2; i >= 0; i-- )
            percDown( musica, i, musica.length );
        for( int i = musica.length - 1; i > 0; i-- )
        {
            swapReferences( musica, 0, i );
            percDown( musica, 0, i );
        }
    }

    private static int leftChild( int i )
    {
        return 2 * i + 1;
    }

    private static void percDown( Musica [ ] musica, int i, int n )
    {
        int child;
        Musica tmp;

        for( tmp = musica[ i ]; leftChild( i ) < n; i = child )
        {
            child = leftChild( i );
            if( child != n - 1 && musica[child].getReleaseDate().compareTo( musica[child+1].getReleaseDate() ) < 0 ){
                child++;
            }else if((child != n - 1 && musica[child].getReleaseDate().compareTo( musica[child+1].getReleaseDate() ) == 0)&&(musica[child].getName().compareTo(musica[child+1].getName()) < 0)){
                child++;
            }
            if( tmp.getReleaseDate().compareTo(musica[child].getReleaseDate()) < 0 ){
                musica[i] = musica[child];
            }else if((tmp.getReleaseDate().compareTo(musica[child].getReleaseDate()) < 0) && (musica[child].getName().compareTo(musica[child+1].getName()) < 0)){
                musica[i] = musica[child];
            }else{
                break;
            }    
        }
        musica[i] = tmp;
    }

    public static final void swapReferences( Musica [ ] musica, int index1, int index2 )
    {
       Musica tmp = musica[ index1 ];
       musica[ index1 ] = musica[ index2 ];
       musica[ index2 ] = tmp;
    }

}
