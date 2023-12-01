package ar.com.hjg.pngj;

/* loaded from: source-8756600-dex2jar.jar:ar/com/hjg/pngj/PngjException.class */
public class PngjException extends RuntimeException {
    private static final long serialVersionUID = 1;

    public PngjException(String str) {
        super(str);
    }

    public PngjException(String str, Throwable th) {
        super(str, th);
    }

    public PngjException(Throwable th) {
        super(th);
    }
}
