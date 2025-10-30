package xml;

import model.Asignatura;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class AsignaturaXML {

    private final String filePath = "asignaturas.xml";

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

    public void añadirAsignatura(Asignatura a) throws Exception {
        Document doc = archivo();
        Element root = doc.getDocumentElement();

        Element asig = doc.createElement("asignatura");

        String[][] data = {
                {"nombre", a.getNombre()},
                {"curso", a.getCurso()},
                {"horas", a.getHoras()},
                {"profesor", a.getProfesor()}
        };

        for (String[] tag : data) {
            Element e = doc.createElement(tag[0]);
            e.appendChild(doc.createTextNode(tag[1]));
            asig.appendChild(e);
        }

        root.appendChild(asig);
        guardarDoc(doc);
    }

    public void listarAsignaturas() throws Exception {
        Document doc = archivo();
        NodeList lista = doc.getElementsByTagName("asignatura");

        System.out.println("----Asignaturas----:");
        for (int i = 0; i < lista.getLength(); i++) {
            Element e = (Element) lista.item(i);
            System.out.println("- " + e.getElementsByTagName("nombre").item(0).getTextContent());
        }
    }
}
