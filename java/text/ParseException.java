package java.text;

/* loaded from: source-2895416-dex2jar.jar:java/text/ParseException.class */
public class ParseException extends Exception {
    private static final long serialVersionUID = 2703218443322787634L;
    private int errorOffset;

    public ParseException(String str, int i) {
        super(str + " (at offset " + i + ")");
        this.errorOffset = i;
    }

    public int getErrorOffset() {
        return this.errorOffset;
    }
}
