import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int opciones;
        String ruta = "";

        do {
            System.out.println("-----Gestión de ficheros-----");
            System.out.println("1. Mostrar información");
            System.out.println("2. Crear carpeta");
            System.out.println("3. Crear fichero");
            System.out.println("4. Eliminar");
            System.out.println("5. Renombrar");
            System.out.println("0. Salir");
            opciones = teclado.nextInt();
            teclado.nextLine();


            switch(opciones) {
                case 1:
                    System.out.print("Ruta del fichero o carpeta: ");
                    ruta = teclado.nextLine();
                    getInformacion(new File(ruta));
                    break;

                case 2:
                    System.out.print("Nombre de la carpeta: ");
                    ruta = teclado.nextLine();
                    crearCarpeta(ruta);
                    break;

                case 3:
                    System.out.print("Nombre del fichero: ");
                    ruta = teclado.nextLine();
                    crearFichero(ruta);
                    break;

                case 4:
                    System.out.print("Ruta del fichero o carpeta a eliminar: ");
                    ruta = teclado.nextLine();
                    eliminar(new File(ruta));
                    break;

                case 5:
                    System.out.print("Ruta del fichero o carpeta: ");
                    ruta = teclado.nextLine();
                    File f = new File(ruta);
                    System.out.print("Nuevo nombre: ");
                    String renombrado = teclado.nextLine();
                    renobrar(f, renombrado);
                    break;
            }
        } while(opciones != 0);

    }
    static void getInformacion(File f) {
        if (!f.exists()) {
            System.out.println("El fichero o carpeta no existe.");
            return;
        }
        System.out.println("Nombre: " + f.getName());
        System.out.println("Ruta: " + f.getAbsolutePath());
        System.out.println("Ultima modificacion: " + new Date(f.lastModified()));
        System.out.println("Oculto: " + f.isHidden());

        if (f.isFile()) {
            System.out.println("Tipo: Archivo");
            System.out.println("Mide: " + f.length() + " bytes");
        } else if (f.isDirectory()) {
            System.out.println("Tipo: Carpeta");
            String[] elements = f.list();
            System.out.println("Nombre de los elementos: " + (elements == null ? 0 : elements.length));
            System.out.println("Espacio libre: " + f.getFreeSpace());
            System.out.println("Espacio disponible: " + f.getUsableSpace());
            System.out.println("Espacio total: " + f.getTotalSpace());
        }
    }

    static void crearCarpeta(String path) {
        File carpeta = new File(path);
        if (carpeta.exists()) {
            System.out.println("Ya existe la carpeta.");
        } else if (carpeta.mkdir()) {
            System.out.println("Carpeta creada correctamente.");
        } else {
            System.out.println("No se ha podido crear la carpeta.");
        }
    }

    static void crearFichero(String path) {
        File fichero = new File(path);
        try {
            if (fichero.exists()) {
                System.out.println("El fichero ya existe.");
            } else if (fichero.createNewFile()) {
                System.out.println("Fichero creado correctamente.");
            } else {
                System.out.println("No se ha podido crear el fichero.");
            }
        } catch (IOException e) {
            System.out.println("Error al crear el fichero: " + e.getMessage());
        }
    }

    static void eliminar(File f) {
        if (!f.exists()) {
            System.out.println("No existe.");
        } else if (f.delete()) {
            System.out.println("Eliminado correctamente.");
        } else {
            System.out.println("No se ha podido eliminar.");
        }
    }

    static void renobrar(File f, String renombrado) {
        if (!f.exists()) {
            System.out.println("No existe.");
            return;
        }
        File nuevo = new File(f.getParent(), renombrado);
        if (f.renameTo(nuevo)) {
            System.out.println("Renombrado correctamente.");
        } else {
            System.out.println("No se ha podido renombrar.");
        }
    }
}
