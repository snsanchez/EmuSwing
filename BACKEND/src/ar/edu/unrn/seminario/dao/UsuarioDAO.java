package ar.edu.unrn.seminario.dao;

import ar.edu.unrn.seminario.modelo.Usuario;
import java.util.List;

public interface UsuarioDAO {

    void create(Usuario usuario);

    void update(Usuario usuario);

    void remove(String username);

    void remove(Usuario usuario);

    Usuario find(String username);

    List<Usuario> findAll();
}