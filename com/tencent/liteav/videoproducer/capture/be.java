package com.tencent.liteav.videoproducer.capture;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/capture/be.class */
public final /* synthetic */ class be implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final bd f36917a;

    private be(bd bdVar) {
        this.f36917a = bdVar;
    }

    public static Runnable a(bd bdVar) {
        return new be(bdVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f36917a.a(false);
    }
}
