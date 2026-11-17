package ar.edu.unrn.seminario.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import ar.edu.unrn.seminario.modelo.Rol;

public class RolDaoJDBC implements RolDao {
    @Override
	public void create(Rol rol) {
		if (rol == null) {
			throw new IllegalArgumentException("El rol a insertar no puede ser nulo.");
		}
		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement statement = conn.prepareStatement("INSERT INTO roles(nombre, activo) VALUES (?, ?)", java.sql.Statement.RETURN_GENERATED_KEYS);) {
			statement.setString(1, rol.getNombre());
			statement.setBoolean(2, rol.isActivo());
			int cantidad = statement.executeUpdate();

			if (cantidad == 0) {
				throw new RuntimeException("No se pudo insertar el rol.");
			}
			try (ResultSet rs = statement.getGeneratedKeys()) {
				if (rs.next()) {
					rol.setCodigo(rs.getInt(1));
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException("Error al procesar la inserción del rol.", e);
		}
	}

	@Override
		public void update(Rol rol) {
			if (rol == null) {
				throw new IllegalArgumentException("El rol a actualizar no puede ser nulo.");
			}
			try (Connection conn = ConnectionManager.getConnection();
					PreparedStatement statement = conn.prepareStatement("UPDATE roles SET nombre = ?, activo = ? WHERE codigo = ?");) {
				statement.setString(1, rol.getNombre());
				statement.setBoolean(2, rol.isActivo());
				statement.setInt(3, rol.getCodigo());
				int cantidad = statement.executeUpdate();
				if (cantidad == 0) {
					throw new RuntimeException("No se pudo actualizar el rol con código: " + rol.getCodigo());
				}

			} catch (SQLException e) {
				throw new RuntimeException("Error al procesar la actualización del rol.", e);
			}
		}

	@Override
		public void remove(Long id) {
			if (id == null) {
				throw new IllegalArgumentException("El código del rol a eliminar no puede ser nulo.");
			}
			try (Connection conn = ConnectionManager.getConnection();
					PreparedStatement statement = conn.prepareStatement("DELETE FROM roles WHERE codigo = ?");) {

				statement.setLong(1, id);

				int cantidad = statement.executeUpdate();
				if (cantidad == 0) {
					throw new RuntimeException("No se pudo eliminar el rol con código: " + id);
				}

			} catch (SQLException e) {
				throw new RuntimeException("Error al procesar la eliminación del rol.", e);
			}
		}

	@Override
		public void remove(Rol rol) {
			if (rol == null) {
				throw new IllegalArgumentException("El rol a eliminar no puede ser nulo.");
			}
			if (rol.getCodigo() == null) {
				throw new IllegalArgumentException("El código del rol a eliminar no puede ser nulo.");
			}
			remove(rol.getCodigo().longValue());
		}

	@Override
		public Rol find(Integer codigo) {
			if (codigo == null) {
				throw new IllegalArgumentException("El código del rol a buscar no puede ser nulo.");
			}
			Rol rol = null;
			try (Connection conn = ConnectionManager.getConnection();
					PreparedStatement statement = conn.prepareStatement("SELECT * FROM roles WHERE codigo = ?");) {
				statement.setInt(1, codigo);
				try (ResultSet rs = statement.executeQuery()) {
					if (rs.next()) {
						rol = new Rol(rs.getInt("codigo"), rs.getString("nombre"));
						rol.setActivo(rs.getBoolean("activo"));
					}
				}
			} catch (SQLException e) {
				throw new RuntimeException("Error al procesar la búsqueda del rol.", e);
			}
			return rol;
		}

	@Override
		public List<Rol> findAll() {
			List<Rol> roles = new ArrayList<>();
			try (Connection conn = ConnectionManager.getConnection();
					PreparedStatement statement = conn.prepareStatement("SELECT r.* FROM roles r");) {
				try (ResultSet rs = statement.executeQuery()) {
					while (rs.next()) {
						Rol rol = new Rol(rs.getInt("codigo"), rs.getString("nombre"));
						rol.setActivo(rs.getBoolean("activo"));
						roles.add(rol);
					}
				}
			} catch (SQLException e) {
				throw new RuntimeException("Error al listar los roles.", e);
			}
			return roles;
		}
}
