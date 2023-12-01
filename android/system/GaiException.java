package android.system;

import java.net.UnknownHostException;
import libcore.io.Libcore;

/* loaded from: source-2895416-dex2jar.jar:android/system/GaiException.class */
public final class GaiException extends RuntimeException {
    public final int error;
    private final String functionName;

    public GaiException(String str, int i) {
        this.functionName = str;
        this.error = i;
    }

    public GaiException(String str, int i, Throwable th) {
        super(th);
        this.functionName = str;
        this.error = i;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        String gaiName = OsConstants.gaiName(this.error);
        String str = gaiName;
        if (gaiName == null) {
            str = "GAI_ error " + this.error;
        }
        return this.functionName + " failed: " + str + " (" + Libcore.os.gai_strerror(this.error) + ")";
    }

    public UnknownHostException rethrowAsUnknownHostException() throws UnknownHostException {
        throw rethrowAsUnknownHostException(getMessage());
    }

    public UnknownHostException rethrowAsUnknownHostException(String str) throws UnknownHostException {
        UnknownHostException unknownHostException = new UnknownHostException(str);
        unknownHostException.initCause(this);
        throw unknownHostException;
    }
}
