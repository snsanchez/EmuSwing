package ar.edu.unrn.seminario.modelo;

public class Juego implements Comparable<Juego> {
    private Integer id;
    private String titulo;
    private String genero;
    private String desarrollador;
    private String consola;
    private Integer año;

    public Juego(Integer id, String titulo, String genero, String desarrollador, String consola, Integer año) {
        this.id = id;
        this.titulo = titulo;
        this.genero = genero;
        this.desarrollador = desarrollador;
        this.consola = consola;
        this.año = año;
    
    }
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
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombreJuegoById(Integer id) {
        return titulo;
    }

    public Integer getId() {
        return id;
    }

    public int hashCode() {
        return id.hashCode();
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Juego juego = (Juego) obj;
        return id.equals(juego.id);
    }

    public int compareTo(Juego otroJuego) {
        return this.id.compareTo(otroJuego.id);
    }


}
