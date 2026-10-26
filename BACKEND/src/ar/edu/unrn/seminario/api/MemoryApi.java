package ar.edu.unrn.seminario.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.xml.catalog.CatalogException;

import ar.edu.unrn.seminario.dto.RolDTO;
import ar.edu.unrn.seminario.dto.UsuarioDTO;
import ar.edu.unrn.seminario.modelo.Juego;
import ar.edu.unrn.seminario.modelo.Rol;
import ar.edu.unrn.seminario.modelo.Usuario;
import ar.edu.unrn.seminario.dto.JuegoDTO;
import ar.edu.unrn.seminario.exception.CatalogoVacioException;

public class MemoryApi implements IApi {

	// estos son objetos de dominio, cuando se expongan hay que pasarlos a DTO
	private ArrayList<Rol> roles = new ArrayList();
	private ArrayList<Usuario> usuarios = new ArrayList<>();

	private Set<Juego> juegos = new HashSet<>();
	private Map<Integer, String> juegosLinks = new HashMap<>();

	public MemoryApi() {

		// datos iniciales
		this.roles.add(new Rol(1, "ADMIN"));
		this.roles.add(new Rol(2, "ESTUDIANTE"));
		this.roles.add(new Rol(3, "INVITADO"));
		inicializarJuegos();
		inicializarUsuarios();
	}

	private void inicializarJuegos() {
		this.juegos.add(new Juego(1, "Super Street Fighter II", "Lucha", "Capcom", "SNES", 1993));
		this.juegos.add(new Juego(2, "DOOM", "FPS", "id Software", "MS-DOS", 1993));
		this.juegos.add(new Juego(3, "Castlevania IV USA", "Plataformas", "Konami", "NES", 1993));

		// agrego un link a cada juego
		this.juegosLinks.put(1, "https://archive.org/embed/Super_Street_Fighter_II_USA.md");
		this.juegosLinks.put(2, "https://archive.org/embed/msdos_DOOM_1993");
		this.juegosLinks.put(3, "https://archive.org/embed/super-castlevania-iv-usa_202301");
	}

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
	    return this.usuarios
					.stream()
					.filter(u -> u.getUsuario().equals(username))
					.map(u->new UsuarioDTO(
					    u.getUsuario(), u.getContrasena(),
						u.getNombre(), u.getEmail(),
						u.getRol().getNombre(),
						u.isActivo(), u.obtenerEstado()))
					.findFirst()
					.orElse(null);
	}

	@Override
	public void eliminarUsuario(String username) {
	    Iterator<Usuario> iterator = this.usuarios.iterator();
    	boolean encontrado = false;
    	while (iterator.hasNext() && !encontrado) {
            Usuario u = iterator.next();
            	if (u.getUsuario().equals(username)) {
                	iterator.remove();
                    encontrado = true;
                }
       	    }
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
	//Se busca el rol mediante el codigo recibido.
		    for (Rol rol : roles) {

		        if (rol.getCodigo().equals(codigo)) {

		        	//Invocacion al metodo "desactivar" de la clase rol, la cual se encarga del proceso.
		            rol.desactivar();

		            //Una vez encontrado y modificado se deja de recorrer el ArrayList.
		            break;
		        }
		    }
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

	private Rol buscarRol(Integer codigo) {
		for (Rol rol : roles) {
			if (rol.getCodigo().equals(codigo))
				return rol;
		}
		return null;
	}

	public Integer getIdJuegoPorTitulo(String nombre) {
		return this.juegos
				.stream()
				.filter(j -> j.getTitulo().equals(nombre))
				.findFirst()
				.map(Juego::getId)
				.orElse(null);
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

}
