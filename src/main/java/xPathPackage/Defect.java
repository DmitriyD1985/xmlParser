package xPathPackage;

public class Defect {
    String message;
    TestCaseDefect defect;

    public Defect() {
    }

    public Defect(String message, TestCaseDefect defect) {
        this.message = message;
        this.defect = defect;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public TestCaseDefect getDefect() {
        return defect;
    }

    public void setDefect(TestCaseDefect defect) {
        this.defect = defect;
    }

    @Override
    public String toString() {
        return "Defect{" +
                "message='" + message + '\'' +
                ", defect=" + defect +
                '}';
    }
}
