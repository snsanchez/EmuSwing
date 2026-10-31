package ar.edu.unrn.seminario.api;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import ar.edu.unrn.seminario.dto.RolDTO;
import ar.edu.unrn.seminario.dto.UsuarioDTO;
import ar.edu.unrn.seminario.modelo.Usuario;
import ar.edu.unrn.seminario.dto.JuegoDTO;
import ar.edu.unrn.seminario.exception.CatalogoVacioException;
import ar.edu.unrn.seminario.exception.JuegoNoEncontradoException;

public class MemoryApi implements IApi {

	private ArrayList<Usuario> usuarios = new ArrayList<>();
	private ArrayList<JuegoDTO> juegos = new ArrayList<>();
	private static Set<JuegoDTO> favoritos = new HashSet<>();

	public MemoryApi() {
		inicializarUsuarios();
		inicializarJuegos();
	}

	private void inicializarJuegos() {
		JuegoDTO j1 = new JuegoDTO(1, "Super Street Fighter II", "Lucha", "Capcom", "SNES", 1993);
		JuegoDTO j2 = new JuegoDTO(2, "DOOM", "FPS", "id Software", "MS-DOS", 1993);
		JuegoDTO j3 = new JuegoDTO(3, "Wolfenstein 3D", "FPS", "id Software", "MS-DOS", 1992);

		this.juegos.add(j1);
		this.juegos.add(j2);
		this.juegos.add(j3);

		favoritos.add(j1);
		favoritos.add(j2);
		favoritos.add(j3);
	}

	private void inicializarUsuarios() {
		registrarUsuario("admin", "1234", "admin@unrn.edu.ar", "Admin", 1);
		registrarUsuario("ldifabio", "4", "ldifabio@unrn.edu.ar", "Lucas", 2);
		registrarUsuario("bjgorosito", "1234", "bjgorosito@unrn.edu.ar", "Bruno", 3);
	}

	@Override
	public void registrarUsuario(String username, String password, String email, String nombre, Integer rol) {
		Usuario usuario = new Usuario(username, password, nombre, email, null);
		this.usuarios.add(usuario);
	}

	@Override
	public List<UsuarioDTO> obtenerUsuarios() {
		List<UsuarioDTO> dtos = new ArrayList<>();
		for (Usuario u : this.usuarios) {
			dtos.add(new UsuarioDTO(u.getUsuario(), u.getContrasena(), u.getNombre(), u.getEmail(),
					"ADMIN", u.isActivo(), u.obtenerEstado()));
		}
		return dtos;
	}

	@Override
	public UsuarioDTO obtenerUsuario(String username) {
		Usuario u = this.buscarUsuario(username);
		if (u != null) {
			return new UsuarioDTO(u.getUsuario(), u.getContrasena(), u.getNombre(), u.getEmail(),
					"ADMIN", u.isActivo(), u.obtenerEstado());
		}
		return null;
	}

	@Override
	public void eliminarUsuario(String username) {
		Usuario u = this.buscarUsuario(username);
		if (u != null) {
			this.usuarios.remove(u);
		}
	}

	@Override
	public List<RolDTO> obtenerRoles() {
		return new ArrayList<>();
	}

	@Override
	public List<RolDTO> obtenerRolesActivos() {
		return new ArrayList<>();
	}

	@Override
	public void guardarRol(Integer codigo, String descripcion, boolean estado) {
		// No op
	}

	@Override
	public RolDTO obtenerRolPorCodigo(Integer codigo) {
		return null;
	}

	@Override
	public void activarRol(Integer codigo) {
		// No op
	}

	@Override
	public void desactivarRol(Integer codigo) {
		// No op
	}

	@Override
	public void activarUsuario(String usuario) {
		Usuario user = this.buscarUsuario(usuario);
		if (user != null) {
			user.activar();
		}
	}

	@Override
	public void desactivarUsuario(String usuario) {
		Usuario user = this.buscarUsuario(usuario);
		if (user != null) {
			user.desactivar();
		}
	}

	private Usuario buscarUsuario(String usuario) {
		for (Usuario user : usuarios) {
			if (user.getUsuario().equals(usuario))
				return user;
		}
		return null;
	}

	@Override
	public List<JuegoDTO> obtenerJuegos() throws CatalogoVacioException {
		if (this.juegos.isEmpty()){
			throw new CatalogoVacioException("No hay juegos registrados en el catálogo en este momento.");
		}
		return new ArrayList<>(this.juegos);
	}

	@Override
	public void agregarFavorito(JuegoDTO j) {
	    favoritos.add(j);
	}

	@Override
	public void quitarFavorito(JuegoDTO j) {
	    favoritos.remove(j);
	}

	@Override
	public Set<JuegoDTO> obtenerFavoritos() {
	    return favoritos;
	}

	@Override
	public JuegoDTO getFavorito(String nombre_juego) throws JuegoNoEncontradoException {
	    for (JuegoDTO j : favoritos) {
	        if (j.getTitulo().equalsIgnoreCase(nombre_juego)) {
	            return j;
	        }
	    }
	    throw new JuegoNoEncontradoException("El juego '" + nombre_juego + "' no fue encontrado en la biblioteca.");
	}

	@Override
	public int contarFavoritos() {
	    return favoritos.size();
	}

	@Override
	public String getInfoJuego(JuegoDTO j) {
		if (j == null) return "Información no disponible.";
	    return "• Título: " + j.getTitulo() + "\n" +
	           "• Género: " + j.getGenero() + "\n" +
	           "• Desarrollador: " + j.getDesarrollador() + "\n" +
	           "• Consola: " + j.getConsola() + "\n" +
	           "• Año de salida: " + j.getAño();
	}
}