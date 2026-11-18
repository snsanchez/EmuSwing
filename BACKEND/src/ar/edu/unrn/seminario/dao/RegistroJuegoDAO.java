package ar.edu.unrn.seminario.dao;

import java.util.List;
import ar.edu.unrn.seminario.modelo.RegistroJuego;

public interface RegistroJuegoDAO {
    void create(RegistroJuego registro);
    void update(RegistroJuego registro);
    void remove(String username, Integer idJuego);
    RegistroJuego find(String username, Integer idJuego);
    List<RegistroJuego> findByUsername(String username);
    List<RegistroJuego> findAll();
}