public class JuegoMapper {

    // Transforma una Entidad de Dominio a un DTO (para enviar hacia la interfaz/vista)
    public JuegoDto transform(Juego juego) {
        if (juego == null) {
            return null;
        }
        return new JuegoDto(
            juego.getId(),
        );
    }

    // Transforma un DTO a una Entidad de Dominio (cuando ingresan datos nuevos)
    public Juego transform(JuegoDto juegoDto) {
        if (juegoDto == null) {
            return null;
        }
        return new Juego(
            juegoDto.getId(),
        );
    }
}
