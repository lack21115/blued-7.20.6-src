package android.system;

import java.io.IOException;
import java.net.SocketException;
import libcore.io.Libcore;

/* loaded from: source-2895416-dex2jar.jar:android/system/ErrnoException.class */
public final class ErrnoException extends Exception {
    public final int errno;
    private final String functionName;

    public ErrnoException(String str, int i) {
        this.functionName = str;
        this.errno = i;
    }

    public ErrnoException(String str, int i, Throwable th) {
        super(th);
        this.functionName = str;
        this.errno = i;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        String errnoName = OsConstants.errnoName(this.errno);
        String str = errnoName;
        if (errnoName == null) {
            str = "errno " + this.errno;
        }
        return this.functionName + " failed: " + str + " (" + Libcore.os.strerror(this.errno) + ")";
    }

    public IOException rethrowAsIOException() throws IOException {
        IOException iOException = new IOException(getMessage());
        iOException.initCause(this);
        throw iOException;
    }

    public SocketException rethrowAsSocketException() throws SocketException {
        throw new SocketException(getMessage(), this);
    }
}
