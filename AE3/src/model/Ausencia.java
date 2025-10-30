package model;

public class Ausencia {
    private String timestamp;
    private String asignatura;
    private String alumno;
    private boolean justificada;
    private String tipo;
    private String curso;

    public Ausencia() {}

    public Ausencia(String timestamp, String asignatura, String alumno,
                    boolean justificada, String tipo, String curso) {
        this.timestamp = timestamp;
        this.asignatura = asignatura;
        this.alumno = alumno;
        this.justificada = justificada;
        this.tipo = tipo;
        this.curso = curso;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }

    public String getAlumno() {
        return alumno;
    }

    public void setAlumno(String alumno) {
        this.alumno = alumno;
    }

    public boolean isJustificada() {
        return justificada;
    }

    public void setJustificada(boolean justificada) {
        this.justificada = justificada;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }
}
