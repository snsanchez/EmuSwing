public class JuegoDto {
    private int id;
    private String titulo;
    private String genero;
    private String desarrollador;
    private String consola;
    private Integer año;

    // Constructor vacío
    public JuegoDto() {
    }

    // Constructor con todos los atributos
    public JuegoDto(int id, String titulo, String genero, String desarrollador, String consola, Integer año) {
        this.id = id;
        this.titulo = titulo;
        this.genero = genero;
        this.desarrollador = desarrollador;
        this.consola = consola;
        this.año = año;
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

    @Override
    public String toString() {
        return "JuegoDto{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", genero='" + genero + '\'' +
                ", desarrollador='" + desarrollador + '\'' +
                ", consola='" + consola + '\'' +
                ", año=" + año +
                '}';
    }

    @Override
        public int hashCode() {
            return Integer.hashCode(id);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            JuegoDto juegoDto = (JuegoDto) obj;
            return id == juegoDto.id;
        }
