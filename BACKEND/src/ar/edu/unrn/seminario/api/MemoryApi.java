package ar.edu.unrn.seminario.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

<<<<<<< HEAD

import ar.edu.unrn.seminario.dto.RegistroJuegoDTO;
=======
import javax.xml.catalog.CatalogException;

>>>>>>> origin/testing
import ar.edu.unrn.seminario.dto.RolDTO;
import ar.edu.unrn.seminario.dto.UsuarioDTO;
import ar.edu.unrn.seminario.modelo.Rol;
import ar.edu.unrn.seminario.modelo.Usuario;
import ar.edu.unrn.seminario.dto.JuegoDTO;
import ar.edu.unrn.seminario.exception.CatalogoVacioException;

public class MemoryApi implements IApi {

	private ArrayList<Rol> roles = new ArrayList();
	private ArrayList<Usuario> usuarios = new ArrayList<>();

	private static Set<RegistroJuegoDTO> favoritos = new HashSeet<RegistroJuegoDTO>();

	public MemoryApi() {

		// datos iniciales
		this.roles.add(new Rol(1, "ADMIN"));
		this.roles.add(new Rol(2, "ESTUDIANTE"));
		this.roles.add(new Rol(3, "INVITADO"));
		inicializarUsuarios();
	}

<<<<<<< HEAD
=======
	private void inicializarJuegos() {
		this.juegos.add(new Juego(1, "Super Street Fighter II", "Lucha", "Capcom", "SNES", 1993));
		this.juegos.add(new Juego(2, "DOOM", "FPS", "id Software", "MS-DOS", 1993));
		this.juegos.add(new Juego(3, "Wolfenstein 3D", "FPS", "id Software", "MS-DOS", 1992));
		
		// agrego un link a cada juego
		this.juegosLinks.put(1, "https://archive.org/embed/Super_Street_Fighter_II_USA.md");
		this.juegosLinks.put(2, "https://archive.org/embed/msdos_DOOM_1993");
		this.juegosLinks.put(3, "https://archive.org/embed/Wolfenstein3d");
	}

>>>>>>> origin/testing
	private void inicializarUsuarios() {
		registrarUsuario("admin", "1234", "admin@unrn.edu.ar", "Admin", 1);
		registrarUsuario("ldifabio", "4", "ldifabio@unrn.edu.ar", "Lucas", 2);
		registrarUsuario("bjgorosito", "1234", "bjgorosito@unrn.edu.ar", "Bruno", 3);

	}

	@Override
	public void registrarUsuario(String username, String password, String email, String nombre, Integer rol) {

		Rol role = this.buscarRol(rol);
		Usuario usuario = new Usuario(username, password, nombre, email, role);
		this.usuarios.add(usuario);

	}

	@Override
	public List<UsuarioDTO> obtenerUsuarios() {
		List<UsuarioDTO> dtos = new ArrayList<>();
		for (Usuario u : this.usuarios) {
			dtos.add(new UsuarioDTO(u.getUsuario(), u.getContrasena(), u.getNombre(), u.getEmail(),
					u.getRol().getNombre(), u.isActivo(), u.obtenerEstado()));
		}
		return dtos;
	}

	@Override
	public UsuarioDTO obtenerUsuario(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminarUsuario(String username) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<RolDTO> obtenerRoles() {
		List<RolDTO> dtos = new ArrayList<>();
		for (Rol r : this.roles) {
			dtos.add(new RolDTO(r.getCodigo(), r.getNombre()));
		}
		return dtos;
	}

	@Override
	public List<RolDTO> obtenerRolesActivos() {
		List<RolDTO> dtos = new ArrayList<>();
		for (Rol r : this.roles) {
			if (r.isActivo())
				dtos.add(new RolDTO(r.getCodigo(), r.getNombre()));
		}
		return dtos;
	}

	@Override
	public void guardarRol(Integer codigo, String descripcion, boolean estado) {
		// TODO Auto-generated method stub
		Rol rol = new Rol(codigo, descripcion);
		this.roles.add(rol);
	}

	@Override
	public RolDTO obtenerRolPorCodigo(Integer codigo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void activarRol(Integer codigo) {
		// TODO Auto-generated method stub

	}

	@Override
	public void desactivarRol(Integer codigo) {
		// TODO Auto-generated method stub

	}

	@Override
	public void activarUsuario(String usuario) {
		Usuario user = this.buscarUsuario(usuario);
		user.activar();
	}

	@Override
	public void desactivarUsuario(String usuario) {
        this.buscarUsuario(usuario).desactivar();
	}


	@Override
	private Rol buscarRol(Integer codigo) {
		for (Rol rol : roles) {
			if (rol.getCodigo().equals(codigo))
				return rol;
		}
		return null;
	}


	@Override
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
		
		List<JuegoDTO> dtos = new ArrayList<>();
		for (Juego j : this.juegos) {
			dtos.add(new JuegoDTO(
				j.getId(),
				j.getTitulo(), 
				j.getGenero(), 
				j.getDesarrollador(), 
				j.getConsola(), 
				j.getAño()
			));
		}
		return dtos;
	}


	@Override
	void agregarFavorito(RegistroJuegoDTO j){
	    favoritos.add(j);
	}


	@Override
	void quitarFavorito(RegistroJuegoDTO j){
	    favoritos.remove(j);
	}


	@Override
	Map<RegistroJuegoDTO> obtenerFavoritos(){
	    return favoritos;
	}


	@Override
	RegistroJuegoDTO getFavorito(String nombre_juego){
	    return favoritos.get(nombre_juego);
	}


	@Override
	int contarFavoritos(){
	    return favoritos.length;
	}
}
