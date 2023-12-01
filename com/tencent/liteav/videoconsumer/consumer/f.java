package com.tencent.liteav.videoconsumer.consumer;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videoconsumer/consumer/f.class */
final /* synthetic */ class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final a f23010a;
    private final boolean b;

    private f(a aVar, boolean z) {
        this.f23010a = aVar;
        this.b = z;
    }

    public static Runnable a(a aVar, boolean z) {
        return new f(aVar, z);
    }

    @Override // java.lang.Runnable
    public final void run() {
        a.b(this.f23010a, this.b);
    }
}
