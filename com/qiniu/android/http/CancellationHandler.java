package com.qiniu.android.http;

import java.io.IOException;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/android/http/CancellationHandler.class */
public interface CancellationHandler {

    /* loaded from: source-8303388-dex2jar.jar:com/qiniu/android/http/CancellationHandler$CancellationException.class */
    public static class CancellationException extends IOException {
    }

    boolean isCancelled();
}
