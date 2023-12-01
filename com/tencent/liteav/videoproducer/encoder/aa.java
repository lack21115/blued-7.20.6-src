package com.tencent.liteav.videoproducer.encoder;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/encoder/aa.class */
public final /* synthetic */ class aa implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final x f36969a;

    private aa(x xVar) {
        this.f36969a = xVar;
    }

    public static Runnable a(x xVar) {
        return new aa(xVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f36969a.c();
    }
}
