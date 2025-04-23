import java.util.ArrayList;

public class BibliotekaMuzyczna {
    private String nazwa, autor;
    private ArrayList<String> utwory = new ArrayList<>();
    private ArrayList<Playlista> playlisty = new ArrayList<>();

    public BibliotekaMuzyczna(String nazwa, String autor) {
        this.autor = autor;
        this.nazwa = nazwa;
    }

    public void dodajUtwor(String utwor) {
        if (utwor != null && !utwory.contains(utwor) && !utwor.isBlank()) {
            this.utwory.add(utwor);
        }
    }

    public void wyswietlUtwory() {
        for (int i = 0; i < utwory.size(); i++) {
            System.out.println("Utwór " + i + ": " + utwory.get(i));
        }
    }

    public void utworzPlayliste(String nazwa) {
        Playlista nowa = new Playlista();
        nowa.utworzPlayliste(nazwa);
        playlisty.add(nowa);
    }

    public void dodajUtworDoPlaylisty(String utwor, String nazwaPlaylisty) {
        for (Playlista p : playlisty) {
            if (p.getNazwa().equals(nazwaPlaylisty)) {
                if (utwory.contains(utwor) && !p.getListaUtworow().contains(utwor)) {
                    p.addListaUtworow(utwor);
                }
                return;
            }
        }
        System.out.println("Playlista o nazwie \"" + nazwaPlaylisty + "\" nie została znaleziona.");
    }

    public void wyswietlWszystkiePlaylisty() {
        for (int i = 0; i < playlisty.size(); i++) {
            System.out.println("Playlista " + i + ": " + playlisty.get(i).getNazwa());
        }
    }

    public void wyswietlPlayliste(String nazwa) {
        for (Playlista p : playlisty) {
            if (p.getNazwa().equals(nazwa)) {
                System.out.println("Playlista: " + p.getNazwa());
                for (String utwor : p.getListaUtworow()) {
                    System.out.println("- " + utwor);
                }
                return;
            }
        }
        System.out.println("Brak playlisty o nazwie: " + nazwa);
    }

    public void wyszukajUtwory(String fraza) {
        for (int i = 0; i < utwory.size(); i++) {
            if (utwory.get(i).contains(fraza)) {
                System.out.println("Utwór " + i + ": " + utwory.get(i));
            }
        }
    }

    public void usunUtwor(String nazwa) {
        for (int i = 0; i < utwory.size(); i++) {
            if (utwory.get(i).equals(nazwa)) {
                utwory.remove(i);
                break;
            }
        }

        // Usuwanie z playlist
        for (Playlista p : playlisty) {
            p.getListaUtworow().remove(nazwa);
        }
    }

    public String getLiczbaUtworow() {
        return String.valueOf(utwory.size());
    }

    public String getLiczbaPlaylist() {
        return String.valueOf(playlisty.size());
    }
}
