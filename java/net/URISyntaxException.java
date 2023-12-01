package java.net;

/* loaded from: source-2895416-dex2jar.jar:java/net/URISyntaxException.class */
public class URISyntaxException extends Exception {
    private static final long serialVersionUID = 2137979680897488891L;
    private int index;
    private String input;

    public URISyntaxException(String str, String str2) {
        super(str2);
        if (str == null) {
            throw new NullPointerException("input == null");
        }
        if (str2 == null) {
            throw new NullPointerException("reason == null");
        }
        this.input = str;
        this.index = -1;
    }

    public URISyntaxException(String str, String str2, int i) {
        super(str2);
        if (str == null) {
            throw new NullPointerException("input == null");
        }
        if (str2 == null) {
            throw new NullPointerException("reason == null");
        }
        if (i < -1) {
            throw new IllegalArgumentException("Bad index: " + i);
        }
        this.input = str;
        this.index = i;
    }

    public int getIndex() {
        return this.index;
    }

    public String getInput() {
        return this.input;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        String message = super.getMessage();
        return this.index != -1 ? message + " at index " + this.index + ": " + this.input : message + ": " + this.input;
    }

    public String getReason() {
        return super.getMessage();
    }
}
