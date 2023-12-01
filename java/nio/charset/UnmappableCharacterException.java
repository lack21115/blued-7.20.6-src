package java.nio.charset;

/* loaded from: source-2895416-dex2jar.jar:java/nio/charset/UnmappableCharacterException.class */
public class UnmappableCharacterException extends CharacterCodingException {
    private static final long serialVersionUID = -7026962371537706123L;
    private int inputLength;

    public UnmappableCharacterException(int i) {
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
