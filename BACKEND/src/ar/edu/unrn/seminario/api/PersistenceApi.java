package ar.edu.unrn.seminario.api;
import java.util.List;

import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import ar.edu.unrn.seminario.dao.JuegoDAO;
import ar.edu.unrn.seminario.dto.JuegoDTO;
import ar.edu.unrn.seminario.dto.RolDTO;
import ar.edu.unrn.seminario.dto.UsuarioDTO;
import ar.edu.unrn.seminario.exception.CatalogoVacioException;
import ar.edu.unrn.seminario.exception.RolNoEncontradoException;
import ar.edu.unrn.seminario.exception.UsuarioExistenteException;
import ar.edu.unrn.seminario.mappers.JuegoMapper;
import ar.edu.unrn.seminario.modelo.Juego;

public class PersistenceApi implements IApi{
    private JuegoDAO juegoDAO;
    // agregar los demas DAOs
    
    private Set<Integer> juegosFavoritosIds = new HashSet<>();
    

    public PersistenceApi(JuegoDAO juegoDAO) {
        this.juegoDAO = juegoDAO;
    }

    public void registrarJuego(Juego juego) {
        juegoDAO.create(juego);
    }

    public JuegoDTO getJuegoPorId(Integer idJuego) {
        return JuegoMapper.transform(juegoDAO.find(idJuego));
    }

    public void actualizarJuego(Juego juego) {
        juegoDAO.update(juego);
    }
    
    public void eliminarJuegoPorId(Integer idJuego) {
        juegoDAO.remove(idJuego);
    }

    public void eliminarJuego(Juego juego) {
        juegoDAO.remove(juego);
    }

   @Override
	public List<JuegoDTO> obtenerJuegos() throws CatalogoVacioException {
		return juegoDAO.findAll()
        .stream()
        .map(JuegoMapper::transform)
        .collect(Collectors.toList());
	}


	@Override
	public void registrarUsuario(String username, String password, String email, String nombre, Integer rol)
			throws UsuarioExistenteException, RolNoEncontradoException {
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RolDTO> obtenerRolesActivos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void guardarRol(Integer codigo, String descripcion, boolean estado) {
		// TODO Auto-generated method stub
		
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
	public List<UsuarioDTO> obtenerUsuarios() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void activarUsuario(String username) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void desactivarUsuario(String username) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Integer getIdJuegoPorTitulo(String titulo) {
		return juegoDAO.findAll().stream()
				.filter(juego -> juego.getTitulo().equals(titulo))
				.findFirst()
				.map(Juego::getId)
				.orElse(null);
	}

	@Override
	public String getUrlJuegoById(Integer idJuego) {
		JuegoDTO juego = getJuegoPorId(idJuego);
		return juego == null ? null : juego.getUrlEmulador();
	}

	@Override
	public String getUrlJuegoByTitulo(String titulo) {
		Integer idJuego = getIdJuegoPorTitulo(titulo);
		return idJuego == null ? null : getUrlJuegoById(idJuego);
	}

	@Override
	public String getGanador() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer obtenerHorasJugadas(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean otorgarSuscripcionAutomatico(String username) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean obtenerEstadoSuscripcion(String username) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void agregarAFavoritos(Integer idJuego) {
		if (idJuego != null) {
			this.juegosFavoritosIds.add(idJuego);
		}
		
	}

	@Override
	public void quitarDeFavoritos(Integer idJuego) {
		if (idJuego != null) {
			this.juegosFavoritosIds.remove(idJuego);
		}
	}

	@Override
	public List<JuegoDTO> obtenerJuegosFavoritos() throws CatalogoVacioException {
		List<Juego> juegosDb = juegoDAO.findAll();
		List<JuegoDTO> dtos = new ArrayList<>();
		
		for (Juego j : juegosDb) {
			if (this.juegosFavoritosIds.contains(j.getId())) {
				dtos.add(JuegoMapper.transform(j));
			}
		}

		if (dtos.isEmpty()) {
			throw new CatalogoVacioException("No tenés juegos marcados como favoritos aún.");
		}
		
		return dtos;
	}

	@Override
	public List<JuegoDTO> obtenerJuegosBiblioteca() throws CatalogoVacioException {
		// Por ahora, si la biblioteca muestra todos los de la base de datos o filtra por algo:
		List<Juego> juegosDb = juegoDAO.findAll();
		
		if (juegosDb == null || juegosDb.isEmpty()) {
			throw new CatalogoVacioException("Tu biblioteca está vacía.");
		}
		
		List<JuegoDTO> dtos = new ArrayList<>();
		for (Juego j : juegosDb) {
			dtos.add(JuegoMapper.transform(j));
		}
		return dtos;
	}

	



    





}
