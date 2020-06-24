package choosingOnRottElement;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        System.out.println(new Main().des1("fileForRead2.xml"));

    }

    public String des1(String fileName) {
        String returnJson = null;
        try {
            InputStream xmlFile = Main.class.getClassLoader().getResourceAsStream(fileName);
            XmlMapper xmlMapper = new XmlMapper();
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = null;
            Document document = null;
            String rootTag = null;
            factory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
            db = factory.newDocumentBuilder();
            document = db.parse(xmlFile);
            rootTag = document.getDocumentElement().getTagName();
            ObjectMapper mapper = new ObjectMapper();
            StringBuilder stringBuilder = new StringBuilder();
            InputStream xmlFile2 = Main.class.getClassLoader().getResourceAsStream(fileName);
            if (rootTag.equals("testsuites")) {
                List<Testsuite> testsuites = xmlMapper.readValue(xmlFile2, new TypeReference<List<Testsuite>>() {
                });
                for (Testsuite testsuite : testsuites) {
                    try {
                        stringBuilder.append(mapper.writeValueAsString(testsuite));
                    } catch (JsonProcessingException e) {
                        e.printStackTrace();
                    }
                }
                returnJson =  stringBuilder.toString();
            }
            if (rootTag.equals("testsuite")) {
                Testsuite testsuites = xmlMapper.readValue(xmlFile2, Testsuite.class);
                returnJson = mapper.writeValueAsString(testsuites);
            }

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return returnJson;
    }
}

