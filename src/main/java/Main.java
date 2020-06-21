import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Main {
    public static void main(String[] args)  {
        InputStream xmlFile = Main.class.getClassLoader().getResourceAsStream("fileForRead2.xml");
        XMLInputFactory xmlInputFactory = XMLInputFactory.newFactory();
        try {
            XMLStreamReader xmlStreamReader = xmlInputFactory.createXMLStreamReader(xmlFile);
        XmlMapper xmlMapper = new XmlMapper();
        List<Testsuite> testsuites = xmlMapper.readValue(xmlStreamReader, new TypeReference<List<Testsuite>>() {});
//        Testsuite testsuite;
//            testsuite = xmlMapper.readValue(xmlStreamReader, Testsuite.class);
            testsuites.stream().map(Testsuite::toString).forEachOrdered(System.out::println);

        } catch (XMLStreamException | IOException e) {
            e.printStackTrace();
        }
    }
}