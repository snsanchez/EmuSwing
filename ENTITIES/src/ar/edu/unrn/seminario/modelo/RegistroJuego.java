package ar.edu.unrn.seminario.modelo;

import java.util.Objects;

public class RegistroJuego {
    private String username;
    private Integer idJuego;
    private Integer horas;

    public RegistroJuego() {}

    public RegistroJuego(Integer idJuego, Integer horas) {
        this.idJuego = idJuego;
        this.horas = horas;
    }

    public RegistroJuego(String username, Integer idJuego, Integer horas) {
        this.username = username;
        this.idJuego = idJuego;
        this.horas = horas;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getIdJuego() {
        return idJuego;
    }

    public void setIdJuego(Integer idJuego) {
        this.idJuego = idJuego;
    }

    public Integer getHoras() {
        return horas;
    }

    public void setHoras(Integer horas) {
        this.horas = horas;
    }

    @Override
    public String toString() {
        return "RegistroJuego{" +
                "username='" + username + '\'' +
                ", idJuego=" + idJuego +
                ", horas=" + horas +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, idJuego);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        RegistroJuego that = (RegistroJuego) obj;
        return Objects.equals(username, that.username) && Objects.equals(idJuego, that.idJuego);
    }
}