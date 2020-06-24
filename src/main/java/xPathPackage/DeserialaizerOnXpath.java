package xPathPackage;


import choosingOnRottElement.Testcase;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class DeserialaizerOnXpath {

    public List<TestSuite> parserXMLTestReport(String fileName) {
        List<TestSuite> testsuiteList = new ArrayList<>();
        InputStream xmlFile2 = DeserialaizerOnXpath.class.getClassLoader().getResourceAsStream(fileName);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = null;
        Document document = null;
        NodeList matchedElementsList = null;

        try {
            factory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
            db = factory.newDocumentBuilder();
            document = db.parse(xmlFile2);
            matchedElementsList = document.getElementsByTagName("testsuite");

            for (int i = 0; i < matchedElementsList.getLength(); i++) {
                Node foundedElement = matchedElementsList.item(i);
                NamedNodeMap mapOfAtributes = foundedElement.getAttributes();
                TestSuite testsuite = setupTestCase(mapOfAtributes);
                testsuiteList.add(testsuite);

                if (foundedElement.hasChildNodes())
                    testsuite.setTestCaseList(getTestacseList(foundedElement.getChildNodes()));

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

        return testsuiteList;
    }

    private static List<TestCase> getTestacseList(NodeList list) {
        List<TestCase> testcases = new ArrayList<>();
        TestCase testcase = new TestCase();
        for (int i = 0; i < list.getLength(); i++) {
            Node node = list.item(i);
                NamedNodeMap attributes = node.getAttributes();
                if (node.getNodeName().equals("testcase") || node.getNodeName().equals("test-case")) {
                    try {
                        testcase.setClassname(attributes.getNamedItem("classname").getNodeValue());
                        testcase.setName(attributes.getNamedItem("name").getNodeValue());
                    } catch (NullPointerException e) {
                    }
                }
            if (node.hasChildNodes()) {
                Defect defect = getDefect(node.getChildNodes());
                testcase.setTestCaseDefectTypeOrMessage(defect.getMessage());
                testcase.setTestCaseDefect(defect.getDefect());
            }
            testcases.add(testcase);
        }
        return testcases;
    }

    public String writeListToJsonArray(String fileName) {
        List<TestSuite> testsuites = parserXMLTestReport(fileName);
        ObjectMapper mapper = new ObjectMapper();
        StringBuilder stringBuilder = new StringBuilder();
        for (TestSuite testsuite : testsuites) {
            try {
                stringBuilder.append(mapper.writeValueAsString(testsuite));
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
        return stringBuilder.toString();
    }

    private static Defect getDefect(NodeList list) {
        Node node = list.item(1);
        Defect defect = new Defect();
        defect.setMessage(node.getTextContent().replace("\n", "").trim());
        switch (node.getNodeName()) {
            case ("error"):
                defect.setDefect(TestCaseDefect.ERROR);
                break;
            case ("skipped"):
                defect.setDefect(TestCaseDefect.SKIPPED);
                break;
            case ("failure"):
                defect.setDefect(TestCaseDefect.FAILED);
                break;
            default:
                break;
        }
        return defect;
    }

    private static TestSuite setupTestCase( NamedNodeMap mapOfAtributes){
        TestSuite testsuite = new TestSuite();
        try {
            testsuite.setTestsCount(Integer.parseInt(mapOfAtributes.getNamedItem("tests").getNodeValue()));
            testsuite.setFailuresCount(Integer.parseInt(mapOfAtributes.getNamedItem("failures").getNodeValue()));
            testsuite.setErrorsCount(Integer.parseInt(mapOfAtributes.getNamedItem("errors").getNodeValue()));
            testsuite.setSkippedCount(Integer.parseInt(mapOfAtributes.getNamedItem("skips").getNodeValue()));
        }
        catch (NullPointerException e){}

        return testsuite;
    }

}

