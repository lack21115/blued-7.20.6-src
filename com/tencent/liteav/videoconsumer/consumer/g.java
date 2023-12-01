package com.tencent.liteav.videoconsumer.consumer;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videoconsumer/consumer/g.class */
final /* synthetic */ class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final a f23011a;
    private final boolean b;

    private g(a aVar, boolean z) {
        this.f23011a = aVar;
        this.b = z;
    }

    public static Runnable a(a aVar, boolean z) {
        return new g(aVar, z);
    }

    @Override // java.lang.Runnable
    public final void run() {
        a.a(this.f23011a, this.b);
    }
}
