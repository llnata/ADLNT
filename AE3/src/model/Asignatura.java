package model;

public class Asignatura {
    private String nombre;
    private String curso;
    private String horas;
    private String profesor;

    public Asignatura() {}

    public Asignatura(String nombre, String curso, String horas, String profesor) {
        this.nombre = nombre;
        this.curso = curso;
        this.horas = horas;
        this.profesor = profesor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getHoras() {
        return horas;
    }

    public void setHoras(String horas) {
        this.horas = horas;
    }

    public String getProfesor() {
        return profesor;
    }

    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }
}

