package ar.edu.unrn.seminario.dao;
import ar.edu.unrn.seminario.modelo.Juego;
import java.util.List;

public interface JuegoDAO {
    void create(Juego juego);

	void update(Juego juego);

	void remove(Integer id);

	void remove(Juego juego);

	Juego find(Integer id);

	List<Juego> findAll();
}
