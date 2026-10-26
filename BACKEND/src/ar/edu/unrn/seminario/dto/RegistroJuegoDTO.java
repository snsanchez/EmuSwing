package ar.edu.unrn.seminario.dto;

public class RegistroJuegoDTO {
    private Integer idJuego;
    private Integer horas;

    public RegistroJuegoDTO(Integer idJuego, Integer horas) {
        this.idJuego = idJuego;
        this.horas = horas;
    }

    // como es DTO solo tiene getters y setters
    public Integer getIdJuego() {
        return idJuego; 
    } 
    public Integer getHoras() {
        return horas;
    }

	public void setIdJuego(Integer idJuego) {
		this.idJuego = idJuego;
	}

	public void setHoras(Integer horas) {
		this.horas = horas;
	}
    
    
}
