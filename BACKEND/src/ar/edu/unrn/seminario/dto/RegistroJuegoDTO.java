package ar.edu.unrn.seminario.dto;

public class RegistroJuegoDTO {
    private Integer idJuego;
    private Double horas;

    public RegistroJuegoDTO(Integer idJuego, Double horas) {
        this.idJuego = idJuego;
        this.horas = horas;
    }

    // como es DTO solo tiene getters y setters
    public Integer getIdJuego() {
        return idJuego; 
    } 
    public Double getHoras() {
        return horas;
    }

	public void setIdJuego(Integer idJuego) {
		this.idJuego = idJuego;
	}

    public void setHoras(Double horas) {
		this.horas = horas;
	}
    
    
}