import java.util.ArrayList;

public class Playlista {
    private String nazwa;
    private ArrayList<String> listaUtworow;

    public Playlista() {
        this.listaUtworow = new ArrayList<>();
    }

    public Playlista(String nazwa) {
        this.nazwa = nazwa;
        this.listaUtworow = new ArrayList<>();
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public ArrayList<String> getListaUtworow() {
        return listaUtworow;
    }

    public void addListaUtworow(String utwor) {
        if (utwor != null && !utwor.isBlank() && !listaUtworow.contains(utwor)) {
            this.listaUtworow.add(utwor);
        }
    }

    public void removeUtwor(String utwor) {
        listaUtworow.remove(utwor);
    }

    public void utworzPlayliste(String nazwa) {
        this.nazwa = nazwa;
        this.listaUtworow.clear(); // reset listy przy tworzeniu nowej playlisty o tej samej nazwie
    }

    public int liczbaUtworow() {
        return this.listaUtworow.size();
    }
}
