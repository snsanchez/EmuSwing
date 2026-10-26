package ar.edu.unrn.seminario.modelo;

import java.util.HashSet;
import java.util.Set;
import java.util.Iterator;

public class Biblioteca {
    private String idUsuario;
    // es el id del juego
    private Integer ultimoJugado;
    // usamos set porque no permite duplicados 
    private Set<Juego> juegos = new HashSet<>();

    public Biblioteca(String idUsuario, Integer ultimoJugado) {
        this.idUsuario = idUsuario;
        this.ultimoJugado = ultimoJugado;
    }
    
    public void agregarJuego(Juego juego) {
        this.juegos.add(juego);
    }

    public Juego getJuego(Integer id) {
        for (Juego juego : juegos) {
            if (juego.getId().equals(id)) {
                return juego;
            }
        }
        return null;
    }

    public void quitarJuego(Integer id){
        Iterator<Juego> iterator = this.juegos.iterator();
        while (iterator.hasNext()) {
            Juego juego = iterator.next();
            if (juego.getId().equals(id)) {
                iterator.remove();
            }
        }

    }

    public String toString() {
        return "Biblioteca{" +
                "idUsuario='" + idUsuario + '\'' +
                ", ultimoJugado=" + ultimoJugado +
                ", juegos=" + juegos +
                '}';
    }
    public int hashCode() {
        return idUsuario.hashCode();
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Biblioteca biblioteca = (Biblioteca) obj;
        return idUsuario.equals(biblioteca.idUsuario);
    }
    
}
