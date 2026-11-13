package ar.edu.unrn.seminario.mappers;

import ar.edu.unrn.seminario.dto.JuegoDTO;
import ar.edu.unrn.seminario.modelo.Juego;


public class JuegoMapper {

    // Transforma una Entidad de Dominio a un DTO (para enviar hacia la interfaz/vista)
    public static JuegoDTO transform(Juego juego) {
        if (juego == null) {
            return null;
        }
        return new JuegoDTO(
                    juego.getId(),
                    juego.getTitulo(),
                    juego.getGenero(),
                    juego.getDesarrollador(),
                    juego.getConsola(),
                    juego.getAño(),
                    juego.getUrlPortada()
                );
    }

    // Transforma un DTO a una Entidad de Dominio (cuando ingresan datos nuevos)
    public static Juego transform(JuegoDTO dto) {
        if (dto == null) {
            return null;
        }
        return new Juego(
                    dto.getId(),
                    dto.getTitulo(),
                    dto.getGenero(),
                    dto.getDesarrollador(),
                    dto.getConsola(),
                    dto.getAño(),
                    dto.getUrlPortada()
                );
    }
}