package xPathPackage;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TestCase {
    @JacksonXmlProperty(isAttribute = true, localName = "name")
    private String name;
    @JacksonXmlProperty(isAttribute = true, localName = "classname")
    private String classname;

    private TestCaseDefect testCaseDefect;

    private String testCaseDefectTypeOrMessage;

    public TestCase() {
    }

    public TestCase(String name, String classname, TestCaseDefect testCaseDefect, String testCaseDefectTypeOrMessage) {
        this.name = name;
        this.classname = classname;
        this.testCaseDefect = testCaseDefect;
        this.testCaseDefectTypeOrMessage = testCaseDefectTypeOrMessage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public TestCaseDefect getTestCaseDefect() {
        return testCaseDefect;
    }

    public void setTestCaseDefect(TestCaseDefect testCaseDefect) {
        this.testCaseDefect = testCaseDefect;
    }

    public String getTestCaseDefectTypeOrMessage() {
        return testCaseDefectTypeOrMessage;
    }

    public void setTestCaseDefectTypeOrMessage(String testCaseDefectTypeOrMessage) {
        this.testCaseDefectTypeOrMessage = testCaseDefectTypeOrMessage;
    }
}
