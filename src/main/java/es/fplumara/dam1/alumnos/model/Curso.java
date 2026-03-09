package es.fplumara.dam1.alumnos.model;

public class Curso {
    private Integer id;
    private Boolean activo;
    private String nombre;

    public Curso(Integer id, Boolean activo, String nombre) {
        this.id = id;
        this.activo = activo;
        this.nombre = nombre;
        if (this.nombre ==null || this.getNombre().isBlank()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
        if(this.activo == null){
            this.activo = true;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
