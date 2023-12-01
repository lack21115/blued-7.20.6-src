package com.tencent.liteav.videoconsumer.decoder;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videoconsumer/decoder/x.class */
final /* synthetic */ class x implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final r f36810a;

    private x(r rVar) {
        this.f36810a = rVar;
    }

    public static Runnable a(r rVar) {
        return new x(rVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        r.d(this.f36810a);
    }
}
