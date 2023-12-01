package android.os;

import android.util.AndroidRuntimeException;

/* loaded from: source-9557208-dex2jar.jar:android/os/BadParcelableException.class */
public class BadParcelableException extends AndroidRuntimeException {
    public BadParcelableException(Exception exc) {
        super(exc);
    }

    public BadParcelableException(String str) {
        super(str);
    }
}
