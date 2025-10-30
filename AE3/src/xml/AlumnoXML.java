package xml;

import model.Alumno;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class AlumnoXML {

    private final String filePath = "alumnos.xml";

    private Document archivo() throws Exception {
        File file = new File(filePath);
        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();

        return builder.parse(file);
    }

    private void guardarDoc(Document doc) throws TransformerException {
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.transform(new DOMSource(doc), new StreamResult(new File(filePath)));
    }

    public void añadirAlumno (Alumno alumno) throws Exception {
        Document doc = archivo();
        Element root = doc.getDocumentElement();

        Element alumn = doc.createElement("alumno");

        String[] etiquetas = {"nombre","curso","dni","fechaNacimiento","correoPadres",
                "telefonoPadres","nombrePadre","nombreMadre"};
        String[] values = {alumno.getNombre(), alumno.getCurso(), alumno.getDni(), alumno.getFechaNacimiento(),
                alumno.getCorreoPadres(), alumno.getTelefonoPadres(),
                alumno.getNombrePadre(), alumno.getNombreMadre()};

        for (int i = 0; i < etiquetas.length; i++) {
            Element e = doc.createElement(etiquetas[i]);
            e.appendChild(doc.createTextNode(values[i]));
            alumn.appendChild(e);
        }

        root.appendChild(alumn);
        guardarDoc(doc);
    }

    public void listarAlumnos() throws Exception {
        Document doc = archivo();
        NodeList lista = doc.getElementsByTagName("alumno");

        System.out.println("----Lista de alumnos----");
        for (int i = 0; i < lista.getLength(); i++) {
            Element e = (Element) lista.item(i);
            System.out.println("- " + e.getElementsByTagName("nombre").item(0).getTextContent());
        }
    }
}
