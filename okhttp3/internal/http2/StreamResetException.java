package okhttp3.internal.http2;

import java.io.IOException;

/* loaded from: source-3503164-dex2jar.jar:okhttp3/internal/http2/StreamResetException.class */
public final class StreamResetException extends IOException {
    public final ErrorCode a;

    public StreamResetException(ErrorCode errorCode) {
        super("stream was reset: " + errorCode);
        this.a = errorCode;
    }
}
