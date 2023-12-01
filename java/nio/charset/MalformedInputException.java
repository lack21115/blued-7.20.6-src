package java.nio.charset;

/* loaded from: source-2895416-dex2jar.jar:java/nio/charset/MalformedInputException.class */
public class MalformedInputException extends CharacterCodingException {
    private static final long serialVersionUID = -3438823399834806194L;
    private int inputLength;

    public MalformedInputException(int i) {
        this.inputLength = i;
    }

    public int getInputLength() {
        return this.inputLength;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return "Length: " + this.inputLength;
    }
}
