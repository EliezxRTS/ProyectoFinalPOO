package org.example.Modelo;

public class Nadador {
    private int id;
    private String nombre;
    private int edad;
    private String nacionalidad;
    private String especialidad;
    private String fotoURL;

    public Nadador() {
    }

    public Nadador(int id, String nombre, int edad, String nacionalidad, String especialidad, String fotoURL) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.nacionalidad = nacionalidad;
        this.especialidad = especialidad;
        this.fotoURL = fotoURL;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getFotoURL() {
        return fotoURL;
    }

    public void setFotoURL(String fotoURL) {
        this.fotoURL = fotoURL;
    }

    @Override
    public String toString() {
        return "Nadador{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", nacionalidad='" + nacionalidad + '\'' +
                ", especialidad='" + especialidad + '\'' +
                ", fotoURL='" + fotoURL + '\'' +
                '}';
    }
}