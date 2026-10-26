public class JuegoMapper {

    // Transforma una Entidad de Dominio a un DTO (para enviar hacia la interfaz/vista)
    public static JuegoDto transform(RegistroJuego juego) {
        if (juego == null) {
            return null;
        }
        return new RegistroJuegoDTO(
                    juego.getId(),
                    juego.getTitulo(),
                    juego.getGenero(),
                    juego.getDesarrollador(),
                    juego.getConsola(),
                    juego.getAño()
                );
    }

    // Transforma un DTO a una Entidad de Dominio (cuando ingresan datos nuevos)
    public static Juego transform(RegistroJuegoDTO juegoDto) {
        if (juegoDto == null) {
            return null;
        }
        return new RegistroJuego(
                    dto.getId(),
                    dto.getTitulo(),
                    dto.getGenero(),
                    dto.getDesarrollador(),
                    dto.getConsola(),
                    dto.getAño()
                );
    }
}
