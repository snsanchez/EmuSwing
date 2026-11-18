package ar.edu.unrn.seminario.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ar.edu.unrn.seminario.exception.RegistroJuegoDAOException;
import ar.edu.unrn.seminario.modelo.RegistroJuego;

public class RegistroJuegoDAOJDBC implements RegistroJuegoDAO {

    public void create(RegistroJuego registro) {
        if (registro == null) {
            throw new IllegalArgumentException("El registro de juego a insertar no debe ser nulo.", null);
        }
        String sql = "INSERT INTO registros_juego (username, id_juego, horas) VALUES (?, ?, ?)";

        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {

            statement.setString(1, registro.getUsername());
            statement.setInt(2, registro.getIdJuego());
            statement.setDouble(3, registro.getHoras());

            int cantidad = statement.executeUpdate();
            if (cantidad == 0) {
                throw new RegistroJuegoDAOException("No se pudo insertar el registro de juego.", null);
            }
        } catch (RegistroJuegoDAOException e) {
            throw e;
        } catch (SQLException e) {
            throw new RegistroJuegoDAOException("Error al procesar la inserción del registro de juego.", e.getSQLState(), e);
        }
    }

    @Override
    public void update(RegistroJuego registro) {
        if (registro == null) {
            throw new IllegalArgumentException("El registro de juego a actualizar no puede ser nulo.", null);
        }
        String sql = "UPDATE registros_juego SET horas = horas + ? WHERE username = ? AND id_juego = ?";

        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {

            statement.setDouble(1, registro.getHoras());
            statement.setString(2, registro.getUsername());
            statement.setInt(3, registro.getIdJuego());

            int filasAfectadas = statement.executeUpdate();

            if (filasAfectadas == 0) {
                create(registro);
            }
        } catch (RegistroJuegoDAOException e) {
            throw e;
        } catch (SQLException e) {
            throw new RegistroJuegoDAOException("Error al actualizar las horas jugadas.", e.getSQLState(), e);
        }
    }

    @Override
    public void remove(String username, Integer idJuego) {
        String sql = "DELETE FROM registros_juego WHERE username = ? AND id_juego = ?";

        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {

            statement.setString(1, username);
            statement.setInt(2, idJuego);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RegistroJuegoDAOException("Error al eliminar el registro de juego.", e.getSQLState(), e);
        }
    }

    @Override
    public RegistroJuego find(String username, Integer idJuego) {
        String sql = "SELECT username, id_juego, horas FROM registros_juego WHERE username = ? AND id_juego = ?";
        RegistroJuego registro = null;

        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {

            statement.setString(1, username);
            statement.setInt(2, idJuego);

            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    registro = new RegistroJuego(
                            rs.getString("username"),
                            rs.getInt("id_juego"),
                            rs.getDouble("horas"));
                }
            }
        } catch (SQLException e) {
            throw new RegistroJuegoDAOException("Error al buscar el registro de juego.", e.getSQLState(), e);
        }
        return registro;
    }

    @Override
    public List<RegistroJuego> findByUsername(String username) {
        String sql = "SELECT username, id_juego, horas FROM registros_juego WHERE username = ?";
        List<RegistroJuego> registros = new ArrayList<>();

        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {

            statement.setString(1, username);

            try (ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    registros.add(new RegistroJuego(
                            rs.getString("username"),
                            rs.getInt("id_juego"),
                            rs.getDouble("horas")));
                }
            }
        } catch (SQLException e) {
            throw new RegistroJuegoDAOException("Error al listar los registros del usuario.", e.getSQLState(), e);
        }
        return registros;
    }

    @Override
    public List<RegistroJuego> findAll() {
        String sql = "SELECT username, id_juego, horas FROM registros_juego";
        List<RegistroJuego> registros = new ArrayList<>();

        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql);
             ResultSet rs = statement.executeQuery()) {

            while (rs.next()) {
                registros.add(new RegistroJuego(
                        rs.getString("username"),
                        rs.getInt("id_juego"),
                        rs.getDouble("horas")));
            }
        } catch (SQLException e) {
            throw new RegistroJuegoDAOException("Error al obtener todos los registros de juego.", e.getSQLState(), e);
        }
        return registros;
    }
}