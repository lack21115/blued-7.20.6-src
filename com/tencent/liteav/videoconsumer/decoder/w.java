package com.tencent.liteav.videoconsumer.decoder;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videoconsumer/decoder/w.class */
final /* synthetic */ class w implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final r f23118a;

    private w(r rVar) {
        this.f23118a = rVar;
    }

    public static Runnable a(r rVar) {
        return new w(rVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        r.c(this.f23118a);
    }
}
