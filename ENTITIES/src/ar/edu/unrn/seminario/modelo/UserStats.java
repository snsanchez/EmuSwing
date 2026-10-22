package ar.edu.unrn.seminario.modelo;

import java.util.List;
import java.util.Objects;
public class UserStats{
   private String idUsuario;
   private Integer puntos;
   private  list<Recompensa> items;
   public UserStats(String idUsuario, Integer puntos, List<Recompensa> items) {
       this.idUsuario = idUsuario;
       this.puntos = puntos;
       this.items = items;
   }
	public String getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}
	public Integer getPuntos() {
		return puntos;
	}
	public void setPuntos(Integer puntos) {
		this.puntos = puntos;
	}
	public list<Recompensa> getItems() {
		return items;
	}
	public void setItems(list<Recompensa> items) {
		this.items = items;
	}
}
