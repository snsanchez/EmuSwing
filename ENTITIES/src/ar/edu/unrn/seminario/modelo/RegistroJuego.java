package ar.edu.unrn.seminario.modelo;

public class RegistroJuego {
    private Integer idJuego;
    private Integer horas;

    public RegistroJuego(){}

    public RegistroJuego(Integer idJuego, Integer horas) {
        this.idJuego = idJuego;
        this.horas = horas;
    }

    public void setHoras(Integer horas) {
        this.horas = horas;
    }
    
    public String toString() {
        return "RegistroJuego{" +
                "idJuego=" + idJuego +
                ", horas=" + horas +
                '}';
    }

    public int hashCode() {
        return idJuego.hashCode();
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        RegistroJuego registroJuego = (RegistroJuego) obj;
        return idJuego.equals(registroJuego.idJuego);
    }

    
}
