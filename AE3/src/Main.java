import model.Alumno;
import model.Asignatura;
import model.Ausencia;
import xml.AlumnoXML;
import xml.AsignaturaXML;
import xml.AusenciaXML;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        Scanner teclado = new Scanner(System.in);

        AlumnoXML ax = new AlumnoXML();
        AsignaturaXML asx = new AsignaturaXML();
        AusenciaXML aux = new AusenciaXML();

        int opcion;

        do {
            System.out.println("---- Menú Principal ----");
            System.out.println("1. Añadir alumno");
            System.out.println("2. Añadir asignatura");
            System.out.println("3. Registrar ausencia");
            System.out.println("4. Mostrar alumnos");
            System.out.println("5. Mostrar asignaturas");
            System.out.println("6. Mostrar ausencias");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");

            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {

                case 1:
                    System.out.print("Nombre del alumno: ");
                    String nom = teclado.nextLine();
                    System.out.print("Curso en el que cursa: ");
                    String curso = teclado.nextLine();
                    System.out.print("DNI del alumno: ");
                    String dni = teclado.nextLine();
                    System.out.print("Fecha de nacimiento (YYYY-MM-DD): ");
                    String fn = teclado.nextLine();
                    System.out.print("Correo de los padres: ");
                    String correo = teclado.nextLine();
                    System.out.print("Teléfono de los padres: ");
                    String tel = teclado.nextLine();
                    System.out.print("Nombre del padre: ");
                    String padre = teclado.nextLine();
                    System.out.print("Nombre de la madre: ");
                    String madre = teclado.nextLine();

                    Alumno alumno = new Alumno(nom, curso, dni, fn, correo, tel, padre, madre);
                    ax.añadirAlumno(alumno);
                    System.out.println("Alumno añadido.");
                    break;

                case 2:
                    System.out.print("Nombre de la asignatura: ");
                    String asigNom = teclado.nextLine();
                    System.out.print("Nombre del curso: ");
                    String asigCur = teclado.nextLine();
                    System.out.print("Numero de horas: ");
                    String horas = teclado.nextLine();
                    System.out.print("Nombre del profesor: ");
                    String prof = teclado.nextLine();

                    Asignatura asignatura = new Asignatura(asigNom, asigCur, horas, prof);
                    asx.añadirAsignatura(asignatura);
                    System.out.println("Asignatura añadida.");
                    break;

                case 3:
                    System.out.print("Nombre de el alumno: ");
                    String alu = teclado.nextLine();
                    System.out.print("Que asignatura a faltado: ");
                    String asigA = teclado.nextLine();
                    System.out.print("De que curso es el alumno: ");
                    String curA = teclado.nextLine();
                    System.out.print("Fecha (YYYY-MM-DD HH:MM): ");
                    String fecha = teclado.nextLine();
                    System.out.print("¿Falta justificada? (true/false): ");
                    boolean jus = teclado.nextBoolean();
                    teclado.nextLine();
                    System.out.print("Tipo de falta: ");
                    String tipo = teclado.nextLine();

                    Alumno alumObj = new Alumno(alu, curA, "", "", "", "", "", "");
                    Ausencia ausencia = new Ausencia(fecha, asigA, alu, jus, tipo, curA);
                    aux.añadirAusencia(ausencia, alumObj);
                    System.out.println("Ausencia registrada.");
                    break;

                case 4:
                    ax.listarAlumnos();
                    break;

                case 5:
                    asx.listarAsignaturas();
                    break;

                case 6:
                    aux.listarAusencias();
                    break;

                case 0:
                    System.out.println("Saliendo del sistema");
                    break;

                default:
                    System.out.println("Opción no válida");
            }

        } while (opcion != 0);
    }
}