import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner teclado = new Scanner(System.in);

        System.out.print("Profesor que esta ausente: ");
        String profesorAusente = teclado.nextLine();

        System.out.print("Día : ");
        String dia = teclado.nextLine().toLowerCase();

        System.out.print("Hora (número de 1 a 6): ");
        String hora = teclado.nextLine();

        List<String> profesoresLibres = buscarProfesoresLibres(profesorAusente, dia, hora);

        System.out.println("Profesores disponibles: " + profesoresLibres);

        if (!profesoresLibres.isEmpty()) {
            String sustituto = profesoresLibres.get(0);
            asignarSustituto(sustituto, dia, hora);
            System.out.println("Asignado a: " + sustituto);
        } else {
            System.out.println("No hay profesores disponibles para esa hora.");
        }
    }

    private static List<String> buscarProfesoresLibres(String profesorAusente, String dia, String hora) throws IOException {
        List<String> libres = new ArrayList<>();

        File carpeta = new File("data/horarios");
        File[] archivos = carpeta.listFiles();

        for (File archivo : archivos) {
            String nombreArchivo = archivo.getName();

            if (!nombreArchivo.endsWith(".csv") ||
                    nombreArchivo.equals(profesorAusente + ".csv") ||
                    nombreArchivo.equals("sustituciones.csv")) {
                continue;
            }
            try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
                String linea;
                while ((linea = br.readLine()) != null) {

                    String[] partes = linea.split(";");
                    if (partes.length < 3) continue;

                    String diaArchivo = partes[0].toLowerCase();
                    String horaArchivo = partes[1];
                    String estado = partes[2].toUpperCase();

                    if (diaArchivo.equals(dia) && horaArchivo.equals(hora) && estado.equals("LIBRE")) {
                        libres.add(nombreArchivo.replace(".csv", ""));
                    }
                }
            }
        }
        return libres;
    }
    private static void asignarSustituto(String profesor, String dia, String hora) throws IOException {
        File archivoSustituciones = new File("data/horarios/sustituciones.csv");
        if (!archivoSustituciones.exists()) {
            archivoSustituciones.createNewFile();
        }
        try (FileWriter fw = new FileWriter(archivoSustituciones, true)) {
            fw.write(profesor + ";" + dia + ";" + hora + " ");
        }
    }
}
