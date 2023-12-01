package dalvik.system.profiler;

import java.io.IOException;

/* loaded from: source-2895416-dex2jar.jar:dalvik/system/profiler/MalformedHprofException.class */
public final class MalformedHprofException extends IOException {
    private static final long serialVersionUID = 8558990237047894213L;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MalformedHprofException(String str) {
        super(str);
    }

    MalformedHprofException(String str, Throwable th) {
        super(str, th);
    }

    MalformedHprofException(Throwable th) {
        super(th);
    }
}
