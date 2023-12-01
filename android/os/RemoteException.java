package android.os;

import android.util.AndroidException;

/* loaded from: source-9557208-dex2jar.jar:android/os/RemoteException.class */
public class RemoteException extends AndroidException {
    public RemoteException() {
    }

    public RemoteException(String str) {
        super(str);
    }

    public RuntimeException rethrowAsRuntimeException() {
        throw new RuntimeException(this);
    }
}
