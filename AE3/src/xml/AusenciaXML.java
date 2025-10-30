package xml;

import model.Ausencia;
import model.Alumno;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class AusenciaXML {

    private final String filePath = "ausencias.xml";

    private Document archivo() throws Exception {
        File file = new File(filePath);
        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();

        return builder.parse(file);
    }

    private void guardarDoc(Document doc) throws Exception {
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.transform(new DOMSource(doc), new StreamResult(new File(filePath)));
    }

    public void añadirAusencia(Ausencia a, Alumno alumno) throws Exception {
        Document doc = archivo();
        Element root = doc.getDocumentElement();

        Element au = doc.createElement("ausencia");

        String[][] data = {
                {"timestamp", a.getTimestamp()},
                {"asignatura", a.getAsignatura()},
                {"alumno", a.getAlumno()},
                {"justificada", String.valueOf(a.isJustificada())},
                {"tipo", a.getTipo()},
                {"curso", a.getCurso()}
        };

        for (String[] tag : data) {
            Element e = doc.createElement(tag[0]);
            e.appendChild(doc.createTextNode(tag[1]));
            au.appendChild(e);
        }

        root.appendChild(au);
        guardarDoc(doc);

        enviarCorreoFalta(alumno, a.getAsignatura());
    }

    public void enviarCorreoFalta(Alumno a, String asignatura) {
        System.out.println("Enviando correo a: " + a.getCorreoPadres());
        System.out.println("Asunto: Falta de asistencia");
        System.out.println("Estimados padres:");
        System.out.println("Su hijo/a " + a.getNombre() +
                " ha faltado a la asignatura de " + asignatura +
                ". Por favor revisen el justificante.\n");
    }

    public void listarAusencias() throws Exception {
        Document doc = archivo();
        NodeList lista = doc.getElementsByTagName("ausencia");

        System.out.println("----Ausencias registradas----:");
        for (int i = 0; i < lista.getLength(); i++) {
            Element e = (Element) lista.item(i);
            System.out.println("- " + e.getElementsByTagName("alumno").item(0).getTextContent()
                    + " | " + e.getElementsByTagName("asignatura").item(0).getTextContent());
        }
    }
}
