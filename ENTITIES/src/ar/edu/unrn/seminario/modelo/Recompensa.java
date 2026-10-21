package ar.edu.unrn.seminario.modelo;

public class Recompensa{
    private String nombre;
    private String descripcion;
    private int valor;
    private int codigo;


    public Recompensa(int valor, String nombre, String, descripcion, int codigo){
        this.valor = valor;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this(codigo);
    }

    public Recompensa (int codigo){
        this.codigo = codigo;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getNombre(){
        return this.nombre;
    }

    public String getDescripcion(){
        return this.descripcion
    }

    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }

    public void setValor(int valor){
        this.valor = valor;
    }

    public int getValor(){
        return this.valor;
    }

    public String toString(){
        return "nombre de la recompensa: " + this.nombre + " valor: " + this.valor;
    }

    public int HashCode(){
        return this.codigo;
    }

    public boolean equals(Recompensa recompensa){
        return this.HashCode = recompensa.HashCode;
    }

}
