package java.nio.charset;

/* loaded from: source-2895416-dex2jar.jar:java/nio/charset/CodingErrorAction.class */
public class CodingErrorAction {
    public static final CodingErrorAction IGNORE = new CodingErrorAction("IGNORE");
    public static final CodingErrorAction REPLACE = new CodingErrorAction("REPLACE");
    public static final CodingErrorAction REPORT = new CodingErrorAction("REPORT");
    private String action;

    private CodingErrorAction(String str) {
        this.action = str;
    }

    public String toString() {
        return "Action: " + this.action;
    }
}
