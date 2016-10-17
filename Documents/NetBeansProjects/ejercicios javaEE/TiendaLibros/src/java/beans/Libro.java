
package beans;


public class Libro {
    private String titulo;
    private String autor;
    private double precio;
    private int tema;
    private int idlibro;
    
    public Libro(){
        
    }

    public Libro(String titulo, String autor, double precio, int tema,int idlibro) {
        this.titulo = titulo;
        this.autor = autor;
        this.precio = precio;
        this.tema = tema;
        this.idlibro=idlibro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setIdlibro(int idlibro) {
        this.idlibro = idlibro;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getTema() {
        return tema;
    }

    public void setTema(int tema) {
        this.tema = tema;
    }

    public int getIdlibro() {
        return idlibro;
    }

}
