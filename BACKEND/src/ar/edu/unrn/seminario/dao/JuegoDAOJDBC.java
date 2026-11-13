package ar.edu.unrn.seminario.dao;

import ar.edu.unrn.seminario.exception.JuegoDAOException;
import ar.edu.unrn.seminario.modelo.Juego;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JuegoDAOJDBC implements JuegoDAO {
    @Override
    public void create(Juego juego) {
        if(juego == null) {
            throw new IllegalArgumentException("El juego a insertar no puede ser nulo.", null);
        }
		try (Connection conn = ConnectionManager.getConnection();
			PreparedStatement statement = conn
					.prepareStatement("INSERT INTO juegos(id, titulo, genero, desarrollador, consola, anio, urlPortada) "
							+ "VALUES (?, ?, ?, ?, ?, ?, ?)");) {

			

			statement.setInt(1, juego.getId());
			statement.setString(2, juego.getTitulo());
			statement.setString(3, juego.getGenero());
			statement.setString(4, juego.getDesarrollador());
			statement.setString(5, juego.getConsola());
			statement.setInt(6, juego.getAño());
			statement.setString(7, juego.getUrlPortada());
			int cantidad = statement.executeUpdate();
			if (cantidad > 0) {
				// System.out.println("Modificando " + cantidad + " registros");
			} else {
				throw new JuegoDAOException("No se pudo insertar el juego.", null);
			}

		} catch (JuegoDAOException e) {
			throw e;
		} catch (SQLException e) {
			throw new JuegoDAOException("Error al procesar la inserción del juego.", e.getSQLState(), e);
		}
    	
    	
    }

    @Override
    public void update(Juego juego) {

    if(juego == null) {
            throw new IllegalArgumentException("El juego a actualizar no puede ser nulo.", null);
        }

    try(Connection conn = ConnectionManager.getConnection();
        PreparedStatement statement = conn.prepareStatement("UPDATE juegos SET titulo = ?, genero = ?, desarrollador = ?, consola = ?, anio = ?, urlPortada = ? WHERE id = ?");){    
            statement.setString(1, juego.getTitulo());
            statement.setString(2, juego.getGenero());
            statement.setString(3, juego.getDesarrollador());
            statement.setString(4, juego.getConsola());
            statement.setInt(5, juego.getAño());
            statement.setString(6, juego.getUrlPortada());
            statement.setInt(7, juego.getId());

            int cantidad = statement.executeUpdate();
            if (cantidad > 0) {
                // System.out.println("Modificando " + cantidad + " registros");
            } else {
                throw new JuegoDAOException("No se pudo actualizar el juego con ID: " + juego.getId(), null);
            }

        } catch (JuegoDAOException e) {
            throw e;
        } catch (SQLException e) {
            throw new JuegoDAOException("Error al procesar la actualización del juego.", e.getSQLState(), e);
        }
    }


    @Override
    public void remove(Integer id) {
        if(id == null) {
            throw new IllegalArgumentException("El ID del juego a eliminar no puede ser nulo.", null);
        }

        try(Connection conn = ConnectionManager.getConnection();
            PreparedStatement statement = conn.prepareStatement(
                    "DELETE FROM juegos WHERE id = ?");){
            
            

            statement.setInt(1, id);
            int cantidad = statement.executeUpdate();
            if (cantidad > 0) {
                // System.out.println("Eliminando " + cantidad + " registros");
            } else {
                throw new JuegoDAOException("No se pudo eliminar el juego con ID: " + id, null);
            }

        } catch (JuegoDAOException e) {
            throw e;
        } catch (SQLException e) {
            throw new JuegoDAOException("Error al procesar la eliminación del juego.", e.getSQLState(), e);
        }
    }

    @Override
    public void remove(Juego juego) {
        if(juego==null){
            throw new IllegalArgumentException("El juego a eliminar no puede ser nulo.", null);
        }
        remove(juego.getId());
    }

    @Override
    public Juego find(Integer id) {
        if(id == null) {
            throw new IllegalArgumentException("El ID del juego a buscar no puede ser nulo.", null);
        }

        Juego juego = null;
		try (Connection conn = ConnectionManager.getConnection();
			PreparedStatement statement = conn.prepareStatement(
					"SELECT * FROM juegos WHERE id = ?");){
			

			statement.setInt(1, id);

            try(ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    juego = new Juego(rs.getInt("id"), rs.getString("titulo"), rs.getString("genero"), rs.getString("desarrollador"), rs.getString("consola"), rs.getInt("anio"), rs.getString("urlPortada"));
                }
            }
		} catch (SQLException e) {
			throw new JuegoDAOException("Error al procesar la búsqueda del juego.", e.getSQLState(), e);
		}


        return juego;                
    }

    @Override
    public List<Juego> findAll() {
        List<Juego> juegos = new ArrayList<Juego>();
		try (Connection conn = ConnectionManager.getConnection();
			PreparedStatement statement = conn.prepareStatement( "SELECT j.*  " + "FROM juegos j");) 
        {
			try(ResultSet rs = statement.executeQuery()) {
				while (rs.next()) {

				Juego juego = new Juego(rs.getInt("id"), rs.getString("titulo"), rs.getString("genero"), rs.getString("desarrollador"), rs.getString("consola"), rs.getInt("anio"), rs.getString("urlPortada"));

				juegos.add(juego);
			}
		} catch (SQLException e) {
			throw new JuegoDAOException("Error al listar los juegos.", e.getSQLState(), e);
		} catch (IllegalArgumentException e) {
			throw new JuegoDAOException("Los datos recibidos al listar los juegos no son válidos.", e);
		}
		return juegos;
	}
}


