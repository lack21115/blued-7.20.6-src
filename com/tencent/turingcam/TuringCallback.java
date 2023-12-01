package com.tencent.turingcam;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/turingcam/TuringCallback.class */
public interface TuringCallback {
    void onException(Throwable th);

    void onFinish(long j, byte[] bArr);

    void onFinishFrameCheck(long j, byte[] bArr);

    void onPreviewAvailable();

    void onPreviewDestroyed();
}
