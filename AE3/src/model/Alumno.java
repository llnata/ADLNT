package model;

public class Alumno {
    private String nombre;
    private String curso;
    private String dni;
    private String fechaNacimiento;
    private String correoPadres;
    private String telefonoPadres;
    private String nombrePadre;
    private String nombreMadre;

    public Alumno(String nombre, String curso, String dni, String fechaNacimiento,
                  String correoPadres, String telefonoPadres, String nombrePadre, String nombreMadre) {

        this.nombre = nombre;
        this.curso = curso;
        this.dni = dni;
        this.fechaNacimiento = fechaNacimiento;
        this.correoPadres = correoPadres;
        this.telefonoPadres = telefonoPadres;
        this.nombrePadre = nombrePadre;
        this.nombreMadre = nombreMadre;
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

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCorreoPadres() {
        return correoPadres;
    }

    public void setCorreoPadres(String correoPadres) {
        this.correoPadres = correoPadres;
    }

    public String getTelefonoPadres() {
        return telefonoPadres;
    }

    public void setTelefonoPadres(String telefonoPadres) {
        this.telefonoPadres = telefonoPadres;
    }

    public String getNombrePadre() {
        return nombrePadre;
    }

    public void setNombrePadre(String nombrePadre) {
        this.nombrePadre = nombrePadre;
    }

    public String getNombreMadre() {
        return nombreMadre;
    }

    public void setNombreMadre(String nombreMadre) {
        this.nombreMadre = nombreMadre;
    }
}

