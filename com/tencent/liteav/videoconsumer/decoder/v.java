package com.tencent.liteav.videoconsumer.decoder;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videoconsumer/decoder/v.class */
final /* synthetic */ class v implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final r f36808a;

    private v(r rVar) {
        this.f36808a = rVar;
    }

    public static Runnable a(r rVar) {
        return new v(rVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f36808a.a();
    }
}
