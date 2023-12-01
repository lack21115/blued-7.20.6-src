package pl.droidsonroids.gif;

import java.io.IOException;

/* loaded from: source-3503164-dex2jar.jar:pl/droidsonroids/gif/GifIOException.class */
public class GifIOException extends IOException {
    private static final long serialVersionUID = 13038402904505L;
    public final GifError a;
    private final String b;

    private GifIOException(int i, String str) {
        this.a = GifError.a(i);
        this.b = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static GifIOException a(int i) {
        if (i == GifError.NO_ERROR.w) {
            return null;
        }
        return new GifIOException(i, null);
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        if (this.b == null) {
            return this.a.a();
        }
        return this.a.a() + ": " + this.b;
    }
}
