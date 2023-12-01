package java.net;

import java.io.IOException;

/* loaded from: source-2895416-dex2jar.jar:java/net/HttpRetryException.class */
public class HttpRetryException extends IOException {
    private static final long serialVersionUID = -9186022286469111381L;
    private String location;
    private int responseCode;

    public HttpRetryException(String str, int i) {
        super(str);
        this.location = null;
        this.responseCode = i;
    }

    public HttpRetryException(String str, int i, String str2) {
        super(str);
        this.location = null;
        this.responseCode = i;
        this.location = str2;
    }

    public String getLocation() {
        return this.location;
    }

    public String getReason() {
        return getMessage();
    }

    public int responseCode() {
        return this.responseCode;
    }
}
