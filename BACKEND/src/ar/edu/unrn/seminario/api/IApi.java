package ar.edu.unrn.seminario.api;
import ar.edu.unrn.seminario.exception.CatalogoVacioException;

import java.util.List;

import ar.edu.unrn.seminario.dto.RolDTO;
import ar.edu.unrn.seminario.dto.UsuarioDTO;
import ar.edu.unrn.seminario.dto.JuegoDTO;

public interface IApi {

	void registrarUsuario(String username, String password, String email, String nombre, Integer rol);

	UsuarioDTO obtenerUsuario(String username);

	void eliminarUsuario(String username);

	List<RolDTO> obtenerRoles();

	List<RolDTO> obtenerRolesActivos();

	void guardarRol(Integer codigo, String descripcion, boolean estado); // crear el objeto de dominio �Rol�

	RolDTO obtenerRolPorCodigo(Integer codigo); // recuperar el rol almacenado

	void activarRol(Integer codigo); // recuperar el objeto Rol, implementar el comportamiento de estado.

	void desactivarRol(Integer codigo); // recuperar el objeto Rol, imp

	List<UsuarioDTO> obtenerUsuarios(); // recuperar todos los usuarios

	void activarUsuario(String username); // recuperar el objeto Usuario, implementar el comportamiento de estado.

	void desactivarUsuario(String username); // recuperar el objeto Usuario, implementar el comportamiento de estado.
<<<<<<< HEAD

	// el requerimiento cargarJuego 
	
	// el metodo cargarJuego no va en el backend porque maneja frontend

	public Integer getIdJuegoPorTitulo(String titulo); // recuperar el id del juego a partir de su titulo.

	public String getUrlJuegoById(Integer idJuego);
	
	public String getUrlJuegoByTitulo(String titulo);


=======
	
	List<JuegoDTO> obtenerJuegos() throws CatalogoVacioException;
>>>>>>> 65fb74350166abac84893875b7595242514312b3
}
