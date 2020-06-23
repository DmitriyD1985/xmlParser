package org.myDotNetParser;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class DotNetParser {
    String parseStringFromDotNet() {
        String returningString = "None";
        InputStream xmlFile = DotNetParser.class.getClassLoader().getResourceAsStream("fileForRead.xml");
        XMLInputFactory xmlInputFactory = XMLInputFactory.newFactory();
        XMLStreamReader xmlStreamReader = null;
        try {
            xmlStreamReader = xmlInputFactory.createXMLStreamReader(xmlFile);
            XmlMapper xmlMapper = new XmlMapper();
            List<Testsuite> testsuites = xmlMapper.readValue(xmlStreamReader, new TypeReference<List<Testsuite>>() {
            });
            ObjectMapper mapper = new ObjectMapper();
            returningString = mapper.writeValueAsString(testsuites);
        } catch (XMLStreamException | IOException e) {
            e.printStackTrace();
        }
        return returningString;
    }

//    String parseStringFromDotNet() {
//        String result = null;
//        InputStream xmlFile = DotNetParser.class.getClassLoader().getResourceAsStream("fileForRead.xml");
//        ObjectMapper jsonMapper = new ObjectMapper();
//        JacksonXmlModule jacksonXmlModule = new JacksonXmlModule();
//        XmlMapper xmlMapper = new XmlMapper(jacksonXmlModule);
//        xmlMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
//        try {
//            result = jsonMapper.writeValueAsString(xmlMapper.readValue(xmlFile, Testsuite.class));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return result;
//    }
}