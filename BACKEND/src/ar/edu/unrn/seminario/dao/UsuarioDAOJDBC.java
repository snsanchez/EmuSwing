package ar.edu.unrn.seminario.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import ar.edu.unrn.seminario.modelo.Rol;
import java.util.ArrayList;
import java.util.List;

import ar.edu.unrn.seminario.exception.UsuarioDAOException;

import ar.edu.unrn.seminario.modelo.Usuario;

public class UsuarioDAOJDBC implements UsuarioDAO {

    @Override
    public void create(Usuario usuario) {

        // Compruebo que reciba un usuario.
        if (usuario == null) {
            throw new IllegalArgumentException(
                    "El usuario a insertar no puede ser nulo.");
        }

        // Compruebo que tenga un username.
        if (usuario.getUsuario() == null
                || usuario.getUsuario().trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "El nombre de usuario no puede estar vacío.");
        }

        // Compruebo que tenga un código de rol.
        if (usuario.getRol() == null || usuario.getRol().getCodigo() == null) {
            throw new IllegalArgumentException(
                    "El usuario debe tener un código de rol.");
        }

        String sql = "INSERT INTO usuarios " + "(usuario, contrasena, nombre, email, codigo_rol, activo, estado_suscripcion) "  + "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement statement = prepararSentencia(sql)) {

            // Asigno los datos en el orden de los parámetros.
            statement.setString(1, usuario.getUsuario());
            statement.setString(2, usuario.getContrasena());
            statement.setString(3, usuario.getNombre());
            statement.setString(4, usuario.getEmail());
            statement.setInt(5, usuario.getRol().getCodigo());
            statement.setBoolean(6, usuario.isActivo());
            statement.setBoolean(7, usuario.isEstadoSuscripcion());

            // Ejecuto la inserción.
            int cantidad = statement.executeUpdate();

            if (cantidad != 1) {
                throw new UsuarioDAOException(
                        "No se pudo insertar el usuario.", null);
            }

        } catch (SQLException e) {
            // Informo el problema y conservo el error original.
            throw new UsuarioDAOException(
                    "Error al insertar el usuario en la base de datos.", e);
        }
    }

    @Override
    public void update(Usuario usuario) {

        // Compruebo que reciba un usuario.
        if (usuario == null) {
            throw new IllegalArgumentException(
                    "El usuario a actualizar no puede ser nulo.");
        }

        // Compruebo que tenga un username.
        if (usuario.getUsuario() == null
                || usuario.getUsuario().trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "El nombre de usuario no puede estar vacío.");
        }

        // Compruebo que tenga un código de rol.
        if (usuario.getRol() == null || usuario.getRol().getCodigo() == null) {
            throw new IllegalArgumentException(
                    "El usuario debe tener un código de rol.");
        }

        String sql = "UPDATE usuarios SET contrasena = ?, nombre = ?, " + "email = ?, codigo_rol = ?, activo = ?, estado_suscripcion = ? " + "WHERE usuario = ?";

        try (PreparedStatement statement = prepararSentencia(sql)) {

            // Asigno los datos que voy a actualizar.
            statement.setString(1, usuario.getContrasena());
            statement.setString(2, usuario.getNombre());
            statement.setString(3, usuario.getEmail());
            statement.setInt(4, usuario.getRol().getCodigo());
            statement.setBoolean(5, usuario.isActivo());
            statement.setBoolean(6, usuario.isEstadoSuscripcion());

            // Indico qué usuario voy a actualizar.
            statement.setString(7, usuario.getUsuario());

            // Ejecuto la actualización.
            statement.executeUpdate();

        } catch (SQLException e) {
            // Informo el problema y conservo el error original.
            throw new UsuarioDAOException(
                    "Error al actualizar el usuario en la base de datos.", e);
        }
    }

    @Override
    public void remove(String username) {

        // Compruebo que reciba un nombre de usuario.
        if (username == null || username.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "El nombre de usuario no puede estar vacío.");
        }

        String sql = "DELETE FROM usuarios WHERE usuario = ?";

        try (PreparedStatement statement = prepararSentencia(sql)) {

            // Indico qué usuario voy a eliminar.
            statement.setString(1, username);

            // Ejecuto la eliminación.
            int cantidad = statement.executeUpdate();

            // Compruebo que se haya eliminado un usuario.
            if (cantidad == 0) {
                throw new UsuarioDAOException(
                        "No se encontró el usuario a eliminar: " + username, null);
            }

        } catch (SQLException e) {
            // Informo el problema y conservo el error original.
            throw new UsuarioDAOException(
                    "Error al eliminar el usuario de la base de datos.", e);
        }
    }

    @Override
    public void remove(Usuario usuario) {

        // Compruebo que reciba un usuario.
        if (usuario == null) {
            throw new IllegalArgumentException(
                    "El usuario a eliminar no puede ser nulo.");
        }

        // Obtengo el username y utilizo el método de eliminación.
        remove(usuario.getUsuario());
    }

    @Override
    public Usuario find(String username) {

        // Compruebo que reciba un nombre de usuario.
        if (username == null || username.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "El nombre de usuario no puede estar vacío.");
        }

        Usuario usuario = null;

        String sql = "SELECT * FROM usuarios WHERE usuario = ?";

        try (PreparedStatement statement = prepararSentencia(sql)) {

            // Indico qué usuario voy a buscar.
            statement.setString(1, username);

            // Ejecuto la consulta y obtengo el resultado.
            try (ResultSet rs = statement.executeQuery()) {

                if (rs.next()) {

                    // Recupero únicamente el código del rol.
                    Rol rol = new Rol();
                    rol.setCodigo(rs.getInt("codigo_rol"));

                    // Creo el usuario con los datos encontrados.
                    usuario = new Usuario(
                            rs.getString("usuario"),
                            rs.getString("contrasena"),
                            rs.getString("nombre"),
                            rs.getString("email"),
                            rol
                    );

                    // Recupero el estado del usuario.
                    if (rs.getBoolean("activo")) {
                        usuario.activar();
                    } else {
                        usuario.desactivar();
                    }

                    // Recupero el estado de la suscripción.
                    usuario.setEstadoSuscripcion(
                            rs.getBoolean("estado_suscripcion"));
                }
            }

        } catch (SQLException e) {
            // Informo el problema y conservo el error original.
            throw new UsuarioDAOException(
                    "Error al buscar el usuario en la base de datos.", e);
        }

        return usuario;
    }

    @Override
    public List<Usuario> findAll() {

        // Creo la lista donde voy a guardar los usuarios encontrados.
        List<Usuario> usuarios = new ArrayList<>();

        String sql = "SELECT * FROM usuarios";

        try (PreparedStatement statement = prepararSentencia(sql);
                 ResultSet rs = statement.executeQuery()) {

            // Recorro los registros obtenidos.
            while (rs.next()) {

                // Recupero únicamente el código del rol.
                Rol rol = new Rol();
                rol.setCodigo(rs.getInt("codigo_rol"));

                // Creo el usuario con los datos de la fila actual.
                Usuario usuario = new Usuario(
                        rs.getString("usuario"),
                        rs.getString("contrasena"),
                        rs.getString("nombre"),
                        rs.getString("email"),
                        rol
                );

                // Recupero el estado del usuario.
                if (rs.getBoolean("activo")) {
                    usuario.activar();
                } else {
                    usuario.desactivar();
                }

                // Recupero el estado de la suscripción.
                usuario.setEstadoSuscripcion(
                        rs.getBoolean("estado_suscripcion"));

                // Agrego el usuario a la lista.
                usuarios.add(usuario);
            }

        } catch (SQLException e) {
            // Informo el problema y conservo el error original.
            throw new UsuarioDAOException(
                    "Error al listar los usuarios de la base de datos.", e);
        }

        // Devuelvo la lista con los usuarios encontrados.
        return usuarios;
    }

    private PreparedStatement prepararSentencia(String sql) throws SQLException {

        // Obtengo la conexión que administra el proyecto.
        Connection conn = ConnectionManager.getConnection();

        // Vuelvo a conectar si la conexión anterior está cerrada.
        if (conn != null && conn.isClosed()) {
            ConnectionManager.reconnect();
            conn = ConnectionManager.getConnection();
        }

        // Compruebo que haya una conexión abierta.
        if (conn == null || conn.isClosed()) {
            throw new SQLException(
                    "No se pudo obtener una conexión abierta a la base de datos.");
        }

        // Preparo la sentencia que voy a ejecutar.
        return conn.prepareStatement(sql);
    }
}