package org.myDotNetParser;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JsonIgnoreProperties(ignoreUnknown = true)
@JacksonXmlRootElement(localName = "{test-case, testcase}")
public class TestCase {
    @JacksonXmlProperty(isAttribute = true, localName = "name")
    private String testCaseName;
    @JacksonXmlProperty(isAttribute = true, localName = "classname")
    private String testCaseClass;
    @JacksonXmlProperty(isAttribute = true, localName = "message")
    private String testCaseFailureMessage;
    @JacksonXmlProperty(isAttribute = true, localName = "type")
    private String testCaseFailureType;
    @JacksonXmlProperty(isAttribute = true, localName = "failureOutput")
    private String testCaseFailureOutput = null;
    @JacksonXmlProperty(isAttribute = true, localName = "errorMessage")
    private String testCaseErrorMessage;
    @JacksonXmlProperty(isAttribute = true, localName = "errorType")
    private String testCaseErrorType;
    @JacksonXmlProperty(isAttribute = true, localName = "errorOutput")
    private String testCaseErrorOutput;
    @JacksonXmlProperty(isAttribute = true, localName = "out")
    private String testCaseSystemOut;

    public TestCase() {
    }

    public TestCase(String testCaseName, String testCaseClass, String testCaseFailureMessage, String testCaseFailureType, String testCaseFailureOutput, String testCaseErrorMessage, String testCaseErrorType, String testCaseErrorOutput, String testCaseSystemOut) {
        this.testCaseName = testCaseName;
        this.testCaseClass = testCaseClass;
        this.testCaseFailureMessage = testCaseFailureMessage;
        this.testCaseFailureType = testCaseFailureType;
        this.testCaseFailureOutput = testCaseFailureOutput;
        this.testCaseErrorMessage = testCaseErrorMessage;
        this.testCaseErrorType = testCaseErrorType;
        this.testCaseErrorOutput = testCaseErrorOutput;
        this.testCaseSystemOut = testCaseSystemOut;
    }

    public String getTestCaseName() {
        return testCaseName;
    }

    public void setTestCaseName(String testCaseName) {
        this.testCaseName = testCaseName;
    }

    public String getTestCaseClass() {
        return testCaseClass;
    }

    public void setTestCaseClass(String testCaseClass) {
        this.testCaseClass = testCaseClass;
    }

    public String getTestCaseFailureMessage() {
        return testCaseFailureMessage;
    }

    public void setTestCaseFailureMessage(String testCaseFailureMessage) {
        this.testCaseFailureMessage = testCaseFailureMessage;
    }

    public String getTestCaseFailureType() {
        return testCaseFailureType;
    }

    public void setTestCaseFailureType(String testCaseFailureType) {
        this.testCaseFailureType = testCaseFailureType;
    }

    public String getTestCaseFailureOutput() {
        return testCaseFailureOutput;
    }

    public void setTestCaseFailureOutput(String testCaseFailureOutput) {
        this.testCaseFailureOutput = testCaseFailureOutput;
    }

    public String getTestCaseErrorMessage() {
        return testCaseErrorMessage;
    }

    public void setTestCaseErrorMessage(String testCaseErrorMessage) {
        this.testCaseErrorMessage = testCaseErrorMessage;
    }

    public String getTestCaseErrorType() {
        return testCaseErrorType;
    }

    public void setTestCaseErrorType(String testCaseErrorType) {
        this.testCaseErrorType = testCaseErrorType;
    }

    public String getTestCaseErrorOutput() {
        return testCaseErrorOutput;
    }

    public void setTestCaseErrorOutput(String testCaseErrorOutput) {
        this.testCaseErrorOutput = testCaseErrorOutput;
    }

    public String getTestCaseSystemOut() {
        return testCaseSystemOut;
    }

    public void setTestCaseSystemOut(String testCaseSystemOut) {
        this.testCaseSystemOut = testCaseSystemOut;
    }

}
