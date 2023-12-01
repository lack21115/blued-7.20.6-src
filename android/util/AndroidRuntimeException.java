package android.util;

/* loaded from: source-9557208-dex2jar.jar:android/util/AndroidRuntimeException.class */
public class AndroidRuntimeException extends RuntimeException {
    public AndroidRuntimeException() {
    }

    public AndroidRuntimeException(Exception exc) {
        super(exc);
    }

    public AndroidRuntimeException(String str) {
        super(str);
    }

    public AndroidRuntimeException(String str, Throwable th) {
        super(str, th);
    }
}
