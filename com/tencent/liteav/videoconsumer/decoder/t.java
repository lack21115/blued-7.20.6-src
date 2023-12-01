package com.tencent.liteav.videoconsumer.decoder;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videoconsumer/decoder/t.class */
final /* synthetic */ class t implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final r f36805a;
    private final Object b;

    /* renamed from: c  reason: collision with root package name */
    private final az f36806c;

    private t(r rVar, Object obj, az azVar) {
        this.f36805a = rVar;
        this.b = obj;
        this.f36806c = azVar;
    }

    public static Runnable a(r rVar, Object obj, az azVar) {
        return new t(rVar, obj, azVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        r.a(this.f36805a, this.b, this.f36806c);
    }
}
