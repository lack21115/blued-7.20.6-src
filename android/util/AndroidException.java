package android.util;

/* loaded from: source-9557208-dex2jar.jar:android/util/AndroidException.class */
public class AndroidException extends Exception {
    public AndroidException() {
    }

    public AndroidException(Exception exc) {
        super(exc);
    }

    public AndroidException(String str) {
        super(str);
    }

    public AndroidException(String str, Throwable th) {
        super(str, th);
    }
}
