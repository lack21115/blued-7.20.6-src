package androidx.core.net;

/* loaded from: source-8756600-dex2jar.jar:androidx/core/net/ParseException.class */
public class ParseException extends RuntimeException {
    public final String response;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ParseException(String str) {
        super(str);
        this.response = str;
    }
}
