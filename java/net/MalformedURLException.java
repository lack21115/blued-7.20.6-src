package java.net;

import java.io.IOException;

/* loaded from: source-2895416-dex2jar.jar:java/net/MalformedURLException.class */
public class MalformedURLException extends IOException {
    private static final long serialVersionUID = -182787522200415866L;

    public MalformedURLException() {
    }

    public MalformedURLException(String str) {
        super(str);
    }

    public MalformedURLException(String str, Throwable th) {
        super(str, th);
    }
}
