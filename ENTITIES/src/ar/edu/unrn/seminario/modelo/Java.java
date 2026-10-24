import java.util.Objects;

public class Juego {
    private int id;
    private String titulo;
    private String genero;
    private String desarrollador;
    private String consola;
    private Integer año;

    // Constructor basado en el diagrama UML
    public Juego(int id, String titulo, String genero, String desarrollador, String consola, Integer año) {
        this.id = id;
        this.titulo = titulo;
        this.genero = genero;
        this.desarrollador = desarrollador;
        this.consola = consola;
        this.año = año;
    }

    // Constructor vacío por defecto
    public Juego() {
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDesarrollador() {
        return desarrollador;
    }

    public void setDesarrollador(String desarrollador) {
        this.desarrollador = desarrollador;
    }

    public String getConsola() {
        return consola;
    }

    public void setConsola(String consola) {
        this.consola = consola;
    }

    public Integer getAño() {
        return año;
    }

    public void setAño(Integer año) {
        this.año = año;
    }

    // Métodos obligatorios indicados en el diagrama UML
    @Override
    public String toString() {
        return "Juego{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", genero='" + genero + '\'' +
                ", desarrollador='" + desarrollador + '\'' +
                ", consola='" + consola + '\'' +
                ", año=" + año +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Juego juego = (Juego) o;
        return id == juego.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
