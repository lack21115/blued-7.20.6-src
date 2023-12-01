package com.tencent.liteav.videobase.b;

import java.io.IOException;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videobase/b/g.class */
public final class g extends IOException {
    private static final long serialVersionUID = 2723743254380545567L;
    public final int mErrorCode;
    private final String mErrorMessage;

    public g(int i) {
        this(i, "");
    }

    public g(int i, String str) {
        super(str);
        this.mErrorCode = i;
        this.mErrorMessage = str;
    }

    public g(int i, String str, Throwable th) {
        super(str, th);
        this.mErrorCode = i;
        this.mErrorMessage = str;
    }

    @Override // java.lang.Throwable
    public final String getMessage() {
        if (this.mErrorMessage != null) {
            return "EGL error code: " + this.mErrorCode + ", " + this.mErrorMessage;
        }
        return "EGL error code: " + this.mErrorCode + ", " + super.getMessage();
    }
}
