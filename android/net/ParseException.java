package android.net;

/* loaded from: source-9557208-dex2jar.jar:android/net/ParseException.class */
public class ParseException extends RuntimeException {
    public String response;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ParseException(String str) {
        this.response = str;
    }
}
