import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        String leerLineas;
        ArrayList<String> listaNombres = new ArrayList<>();
        ArrayList<String> listaPreguntas = new ArrayList<>();
        ArrayList<String> listaNotas = new ArrayList<>();
        String[] valores = {"0","33","66","100"};

        File nombre = new File("C:\\Users\\PC GAMING\\IdeaProjects\\AE2\\textos\\nombres.txt");
        FileReader fr = new FileReader(nombre);
        BufferedReader br = new BufferedReader(fr);

        File rubrica = new File("C:\\Users\\PC GAMING\\IdeaProjects\\AE2\\textos\\rubrica.txt");
        FileReader frrubrica = new FileReader(rubrica);
        BufferedReader brrubrica = new BufferedReader(frrubrica);

        ArrayList<String> lineasCompletas = new ArrayList<>();
        while ((leerLineas = br.readLine()) != null) {
            String[] partes = leerLineas.split(",");
            listaNombres.add(partes[0].trim());
            lineasCompletas.add(leerLineas.trim());
        }
        br.close();

        while ((leerLineas = brrubrica.readLine()) != null) {
            if (!leerLineas.trim().isEmpty()) {
                String[] partes = leerLineas.split(";");
                listaPreguntas.add(partes[0].trim());
                for (int i = 1; i < partes.length; i++) {
                    listaNotas.add(partes[i].trim());
                }
            }
        }
        brrubrica.close();

        int notasPorPregunta = listaNotas.size() / listaPreguntas.size();
        int opciones = valores.length;

        Scanner scanner = new Scanner(System.in);

        for (int k = 0; k < listaNombres.size(); k++) {
            String alumno = listaNombres.get(k);
            String lineaModificada = lineasCompletas.get(k);

            System.out.println("Evaluando al alumno: " + alumno);

            for (int i = 0; i < listaPreguntas.size(); i++) {
                System.out.println("Pregunta " + (i + 1) + ": " + listaPreguntas.get(i));

                for (int j = 0; j < opciones; j++) {
                    int indice = (i * notasPorPregunta) + j;
                    String descripcion = (j < notasPorPregunta) ? listaNotas.get(indice) : "Descripción no disponible";

                    System.out.println("[" + (j+1) + "] " + valores[j] + " - " + descripcion);
                }

                int seleccion;
                do {
                    System.out.print("Elige la opción (1 a " + opciones + "): ");
                    while (!scanner.hasNextInt()) {
                        scanner.next();
                        System.out.print("Entrada inválida: ");
                    }
                    seleccion = scanner.nextInt();
                } while (seleccion < 1 || seleccion > opciones);

                lineaModificada += "," + valores[seleccion - 1];
            }

            lineasCompletas.set(k, lineaModificada);
        }

        scanner.close();

        BufferedWriter bw = new BufferedWriter(new FileWriter(nombre));
        for (String l : lineasCompletas) {
            bw.write(l);
            bw.newLine();
        }
        bw.close();

        System.out.println("Archivo actualizado");
    }
}

