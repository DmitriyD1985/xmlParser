package choosingOnRottElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.List;


@JacksonXmlRootElement(localName = "testsuite, testsu")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Testsuite {
    @JacksonXmlProperty(isAttribute = true, localName = "name")
    private String testSuiteName;
    @JacksonXmlProperty(isAttribute = true, localName = "tests")
    private int testSuiteTotalTests;
    @JacksonXmlProperty(isAttribute = true, localName = "failures")
    private int testSuiteFailuresTests;
    @JacksonXmlProperty(isAttribute = true, localName = "errors")
    private int testSuiteErrorsTests;

    @JacksonXmlProperty(localName = "testcase")
    @JacksonXmlElementWrapper( useWrapping = false)
    private List<Testcase> testCases;

    public Testsuite() {
    }

    public Testsuite(String testSuiteName, int testSuiteTotalTests, int testSuiteFailuresTests, int testSuiteErrorsTests, List<Testcase> testCases) {
        this.testSuiteName = testSuiteName;
        this.testSuiteTotalTests = testSuiteTotalTests;
        this.testSuiteFailuresTests = testSuiteFailuresTests;
        this.testSuiteErrorsTests = testSuiteErrorsTests;
        this.testCases = testCases;
    }

    public String getTestSuiteName() {
        return testSuiteName;
    }

    public void setTestSuiteName(String testSuiteName) {
        this.testSuiteName = testSuiteName;
    }

    public int getTestSuiteTotalTests() {
        return testSuiteTotalTests;
    }

    public void setTestSuiteTotalTests(int testSuiteTotalTests) {
        this.testSuiteTotalTests = testSuiteTotalTests;
    }

    public int getTestSuiteFailuresTests() {
        return testSuiteFailuresTests;
    }

    public void setTestSuiteFailuresTests(int testSuiteFailuresTests) {
        this.testSuiteFailuresTests = testSuiteFailuresTests;
    }

    public int getTestSuiteErrorsTests() {
        return testSuiteErrorsTests;
    }

    public void setTestSuiteErrorsTests(int testSuiteErrorsTests) {
        this.testSuiteErrorsTests = testSuiteErrorsTests;
    }

    public List<Testcase> getTestCases() {
        return testCases;
    }

    public void setTestCases(List<Testcase> testCases) {
        this.testCases = testCases;
    }

    @Override
    public String toString() {
        return "Testsuite{" +
                "testSuiteName='" + testSuiteName + '\'' +
                ", testSuiteTotalTests=" + testSuiteTotalTests +
                ", testSuiteFailuresTests=" + testSuiteFailuresTests +
                ", testSuiteErrorsTests=" + testSuiteErrorsTests +
                ", testCases=" + testCases +
                '}';
    }
}