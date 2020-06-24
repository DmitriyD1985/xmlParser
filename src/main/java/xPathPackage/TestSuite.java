package xPathPackage;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TestSuite {
    @JacksonXmlProperty(isAttribute = true, localName = "tests")
    private int testsCount;

    @JacksonXmlProperty(isAttribute = true, localName = "failures")
    private int failuresCount;

    @JacksonXmlProperty(isAttribute = true, localName = "errors")
    private int errorsCount;

    @JacksonXmlProperty(isAttribute = true, localName = "skips")
    private int skippedCount;

    @JacksonXmlProperty(localName = "testcase")
    @JacksonXmlElementWrapper( useWrapping = false)
    private List<TestCase> testCaseList;

    public TestSuite() {
    }

    public TestSuite(int testsCount, int failuresCount, int errorsCount, int skippedCount, List<TestCase> testCaseList) {
        this.testsCount = testsCount;
        this.failuresCount = failuresCount;
        this.errorsCount = errorsCount;
        this.skippedCount = skippedCount;
        this.testCaseList = testCaseList;
    }

    public int getTestsCount() {
        return testsCount;
    }

    public void setTestsCount(int testsCount) {
        this.testsCount = testsCount;
    }

    public int getFailuresCount() {
        return failuresCount;
    }

    public void setFailuresCount(int failuresCount) {
        this.failuresCount = failuresCount;
    }

    public int getErrorsCount() {
        return errorsCount;
    }

    public void setErrorsCount(int errorsCount) {
        this.errorsCount = errorsCount;
    }

    public int getSkippedCount() {
        return skippedCount;
    }

    public void setSkippedCount(int skippedCount) {
        this.skippedCount = skippedCount;
    }

    public List<TestCase> getTestCaseList() {
        return testCaseList;
    }

    public void setTestCaseList(List<TestCase> testCaseList) {
        this.testCaseList = testCaseList;
    }
}
