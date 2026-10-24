public class JuegoMapper {

    // Transforma una Entidad de Dominio a un DTO (para enviar hacia la interfaz/vista)
    public static JuegoDto transform(Juego juego) {
        if (juego == null) {
            return null;
        }
        return new JuegoDto(
                    juego.getId(),
                    juego.getTitulo(),
                    juego.getGenero(),
                    juego.getDesarrollador(),
                    juego.getConsola(),
                    juego.getAño()
                );
    }

    // Transforma un DTO a una Entidad de Dominio (cuando ingresan datos nuevos)
    public static Juego transform(JuegoDto juegoDto) {
        if (juegoDto == null) {
            return null;
        }
        return new Juego(
                    dto.getId(),
                    dto.getTitulo(),
                    dto.getGenero(),
                    dto.getDesarrollador(),
                    dto.getConsola(),
                    dto.getAño()
                );
    }
}
