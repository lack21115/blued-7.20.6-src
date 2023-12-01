package com.tencent.liteav.videoconsumer.consumer;

import android.graphics.Bitmap;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.videobase.base.TakeSnapshotListener;

@JNINamespace("liteav::video")
/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videoconsumer/consumer/NativeSnapshotListener.class */
public class NativeSnapshotListener implements TakeSnapshotListener {
    private long mNativeVideoSnapListener;

    private NativeSnapshotListener(long j) {
        this.mNativeVideoSnapListener = 0L;
        this.mNativeVideoSnapListener = j;
    }

    private native void nativeDestroy(long j);

    private native void nativeOnComplete(long j, Bitmap bitmap);

    protected void finalize() throws Throwable {
        long j = this.mNativeVideoSnapListener;
        if (j != 0) {
            nativeDestroy(j);
            this.mNativeVideoSnapListener = 0L;
        }
        super.finalize();
    }

    @Override // com.tencent.liteav.videobase.base.TakeSnapshotListener
    public void onComplete(Bitmap bitmap) {
        long j = this.mNativeVideoSnapListener;
        if (j != 0) {
            nativeOnComplete(j, bitmap);
            this.mNativeVideoSnapListener = 0L;
        }
    }
}
