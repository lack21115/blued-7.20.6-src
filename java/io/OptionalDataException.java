package java.io;

/* loaded from: source-2895416-dex2jar.jar:java/io/OptionalDataException.class */
public class OptionalDataException extends ObjectStreamException {
    private static final long serialVersionUID = -8011121865681257820L;
    public boolean eof;
    public int length;

    /* JADX INFO: Access modifiers changed from: package-private */
    public OptionalDataException() {
    }

    OptionalDataException(String str) {
        super(str);
    }
}
