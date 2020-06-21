//import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlCData;
//import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
//import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
//
//import java.util.List;
//
//
//public class Testcase {
//    @JacksonXmlProperty(isAttribute = true)
//    private String classname;
//    @JacksonXmlProperty(isAttribute = true)
//    private String name;
//    @JacksonXmlProperty(isAttribute = true)
//    private String time;
//    @JacksonXmlProperty(isAttribute = true)
//    private boolean skipped;
//
//    @JacksonXmlProperty(localName = "failure")
//    @JacksonXmlElementWrapper( useWrapping = false)
//    @JacksonXmlCData
//    private List<Failure> failures;
//
//    @JacksonXmlProperty(localName = "error")
//    @JacksonXmlElementWrapper( useWrapping = false)
//    @JacksonXmlCData
//    private List<СlasForError> errorsList;
//
//    public Testcase() {
//    }
//
//    public Testcase(String classname, String name, String time, List<Failure> failures, List<СlasForError> errorsList) {
//        this.classname = classname;
//        this.name = name;
//        this.time = time;
//        this.failures = failures;
//        this.errorsList = errorsList;
//    }
//
//    public String getClassname() {
//        return classname;
//    }
//
//    public void setClassname(String classname) {
//        this.classname = classname;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getTime() {
//        return time;
//    }
//
//    public void setTime(String time) {
//        this.time = time;
//    }
//
//    public List<Failure> getFailures() {
//        return failures;
//    }
//
//    public void setFailures(List<Failure> failures) {
//        this.failures = failures;
//    }
//
//    public List<СlasForError> getErrorsList() {
//        return errorsList;
//    }
//
//    public void setErrorsList(List<СlasForError> errorsList) {
//        this.errorsList = errorsList;
//    }
//}
