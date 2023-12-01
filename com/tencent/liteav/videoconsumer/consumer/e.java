package com.tencent.liteav.videoconsumer.consumer;

import com.tencent.liteav.videobase.utils.Rotation;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videoconsumer/consumer/e.class */
final /* synthetic */ class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final a f23009a;
    private final Rotation b;

    private e(a aVar, Rotation rotation) {
        this.f23009a = aVar;
        this.b = rotation;
    }

    public static Runnable a(a aVar, Rotation rotation) {
        return new e(aVar, rotation);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f23009a.n = this.b;
    }
}
