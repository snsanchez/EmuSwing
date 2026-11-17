package ar.edu.unrn.seminario.main;

import javax.swing.SwingUtilities;

import ar.edu.unrn.seminario.api.IApi;
import ar.edu.unrn.seminario.api.PersistenceApi;
import ar.edu.unrn.seminario.dao.JuegoDAOJDBC;
import ar.edu.unrn.seminario.dao.UsuarioDAOJDBC;
import ar.edu.unrn.seminario.gui.RegistrarUsuario;

public class PruebaPersistenceUsuarios {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            IApi api = new PersistenceApi(
                    new JuegoDAOJDBC(),
                    new UsuarioDAOJDBC()
            );

            RegistrarUsuario ventana = new RegistrarUsuario(api);
            ventana.mostrar();
        });
    }
}