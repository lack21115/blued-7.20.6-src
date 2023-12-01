package java.io;

/* loaded from: source-2895416-dex2jar.jar:java/io/InvalidClassException.class */
public class InvalidClassException extends ObjectStreamException {
    private static final long serialVersionUID = -4333316296251054416L;
    public String classname;

    public InvalidClassException(String str) {
        super(str);
    }

    public InvalidClassException(String str, String str2) {
        super(str2);
        this.classname = str;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        String message = super.getMessage();
        String str = message;
        if (this.classname != null) {
            str = this.classname + "; " + message;
        }
        return str;
    }
}
