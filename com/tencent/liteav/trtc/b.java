package com.tencent.liteav.trtc;

import android.graphics.Bitmap;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/trtc/b.class */
final /* synthetic */ class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TrtcCloudJni f36472a;
    private final Bitmap b;

    private b(TrtcCloudJni trtcCloudJni, Bitmap bitmap) {
        this.f36472a = trtcCloudJni;
        this.b = bitmap;
    }

    public static Runnable a(TrtcCloudJni trtcCloudJni, Bitmap bitmap) {
        return new b(trtcCloudJni, bitmap);
    }

    @Override // java.lang.Runnable
    public final void run() {
        TrtcCloudJni.lambda$onSnapshotComplete$1(this.f36472a, this.b);
    }
}
