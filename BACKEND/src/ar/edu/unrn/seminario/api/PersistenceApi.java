package ar.edu.unrn.seminario.api;
import java.util.List;
import java.util.stream.Collectors;

import ar.edu.unrn.seminario.dao.JuegoDAO;
import ar.edu.unrn.seminario.dto.JuegoDTO;
import ar.edu.unrn.seminario.dto.RolDTO;
import ar.edu.unrn.seminario.dto.UsuarioDTO;
import ar.edu.unrn.seminario.exception.CatalogoVacioException;
import ar.edu.unrn.seminario.exception.RolNoEncontradoException;
import ar.edu.unrn.seminario.exception.UsuarioExistenteException;
import ar.edu.unrn.seminario.mappers.JuegoMapper;
import ar.edu.unrn.seminario.modelo.Juego;
import java.util.HashMap;
import java.util.Map;
import ar.edu.unrn.seminario.dao.RegistroJuegoDAO;
import ar.edu.unrn.seminario.dao.RegistroJuegoDAOJDBC;
import ar.edu.unrn.seminario.modelo.RegistroJuego;


public class PersistenceApi implements IApi{
	private JuegoDAO juegoDAO;
	private RegistroJuegoDAO registroJuegoDAO;

	public PersistenceApi(JuegoDAO juegoDAO) {
	    this.juegoDAO = juegoDAO;
	    this.registroJuegoDAO = new RegistroJuegoDAOJDBC();
	}

	public PersistenceApi(JuegoDAO juegoDAO, RegistroJuegoDAO registroJuegoDAO) {
	    this.juegoDAO = juegoDAO;
	    this.registroJuegoDAO = registroJuegoDAO;
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
	public void registrarHorasJugadas(String username, Integer idJuego, Integer horas) {
	    if (username == null || idJuego == null || horas == null || horas <= 0) {
	        return;
	    }
	    RegistroJuego registro = new RegistroJuego(username, idJuego, horas);
	    registroJuegoDAO.update(registro);
	}

	@Override
	public Integer obtenerHorasJugadas(String username) {
	    int totalHoras = 0;
	    for (RegistroJuego r : registroJuegoDAO.findByUsername(username)) {
	        if (r.getHoras() != null) {
	            totalHoras += r.getHoras();
	        }
	    }
	    return totalHoras;
	}

	@Override
	public String getGanador() {
	    Map<String, Integer> acumuladoPorUsuario = new HashMap<>();
	    for (RegistroJuego r : registroJuegoDAO.findAll()) {
	        acumuladoPorUsuario.merge(r.getUsername(), r.getHoras(), Integer::sum);
	    }
	    String ganador = null;
	    int maxHoras = -1;
	    for (Map.Entry<String, Integer> entry : acumuladoPorUsuario.entrySet()) {
	        if (entry.getValue() > maxHoras) {
	            maxHoras = entry.getValue();
	            ganador = entry.getKey();
	        }
	    }
	    return ganador;
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void quitarDeFavoritos(Integer idJuego) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<JuegoDTO> obtenerJuegosFavoritos() throws CatalogoVacioException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<JuegoDTO> obtenerJuegosBiblioteca() throws CatalogoVacioException {
		// TODO Auto-generated method stub
		return null;
	}

	



    





}
