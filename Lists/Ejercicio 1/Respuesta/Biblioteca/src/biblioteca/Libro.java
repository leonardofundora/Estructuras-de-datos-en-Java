package biblioteca;

public class Libro {
    
    private String titulo;
    
    private int anno;
    
    private String autor;

    public Libro(String titulo, int anno, String autor) {
        this.titulo = titulo;
        this.anno = anno;
        this.autor = autor;
    }

    public int getAnno() {
        return anno;
    }
    
    @Override
    public String toString () {
        return "Titulo: " + this.titulo + " anno de publicacion: " + this.anno + " autor: " + this.autor;
    }
    
}
