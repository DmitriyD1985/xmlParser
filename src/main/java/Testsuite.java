import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;


@JacksonXmlRootElement(localName = "testsuite")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Testsuite {
    @JacksonXmlProperty(isAttribute = true)
    private int errors;
    @JacksonXmlProperty(isAttribute = true)
    private int failures;
    @JacksonXmlProperty(isAttribute = true)
    private String name;
    @JacksonXmlProperty(isAttribute = true)
    private int skips;
    @JacksonXmlProperty(isAttribute = true)
    private int tests;
    @JacksonXmlProperty(isAttribute = true)
    private String time;

    public Testsuite() {

    }

    public Testsuite(int errors, int failures, String name, int skips, int tests, String time) {
        this.errors = errors;
        this.failures = failures;
        this.name = name;
        this.skips = skips;
        this.tests = tests;
        this.time = time;
    }

    public int getErrors() {
        return errors;
    }

    public void setErrors(int errors) {
        this.errors = errors;
    }

    public int getFailures() {
        return failures;
    }

    public void setFailures(int failures) {
        this.failures = failures;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSkips() {
        return skips;
    }

    public void setSkips(int skips) {
        this.skips = skips;
    }

    public int getTests() {
        return tests;
    }

    public void setTests(int tests) {
        this.tests = tests;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Testsuite{" +
                "errors=" + errors +
                ", failures=" + failures +
                ", name='" + name + '\'' +
                ", skips=" + skips +
                ", tests=" + tests +
                ", time='" + time + '\'' +
                '}';
    }
}
