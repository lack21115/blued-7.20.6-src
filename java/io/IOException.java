package java.io;

/* loaded from: source-2895416-dex2jar.jar:java/io/IOException.class */
public class IOException extends Exception {
    private static final long serialVersionUID = 7818375828146090155L;

    public IOException() {
    }

    public IOException(String str) {
        super(str);
    }

    public IOException(String str, Throwable th) {
        super(str, th);
    }

    public IOException(Throwable th) {
        super(th == null ? null : th.toString(), th);
    }
}
