package ar.edu.unrn.seminario.api;

import java.util.List;
import java.util.Set;
import ar.edu.unrn.seminario.dto.RolDTO;
import ar.edu.unrn.seminario.dto.UsuarioDTO;
import ar.edu.unrn.seminario.dto.JuegoDTO;
import ar.edu.unrn.seminario.exception.CatalogoVacioException;
import ar.edu.unrn.seminario.exception.JuegoNoEncontradoException;

public interface IApi {

	void registrarUsuario(String username, String password, String email, String nombre, Integer rol);

	UsuarioDTO obtenerUsuario(String username);

	void eliminarUsuario(String username);

	List<RolDTO> obtenerRoles();

	List<RolDTO> obtenerRolesActivos();

	void guardarRol(Integer codigo, String descripcion, boolean estado);

	void activarRol(Integer codigo);

	void desactivarRol(Integer codigo);

	List<UsuarioDTO> obtenerUsuarios();

	void activarUsuario(String username);

	void desactivarUsuario(String username);
	
	List<JuegoDTO> obtenerJuegos() throws CatalogoVacioException;

	void agregarFavorito(JuegoDTO juego);

	void quitarFavorito(JuegoDTO juego);

	Set<JuegoDTO> obtenerFavoritos();

	JuegoDTO getFavorito(String nombreJuego) throws JuegoNoEncontradoException;

	int contarFavoritos();

	String getInfoJuego(JuegoDTO juego);
}