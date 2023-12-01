package com.tencent.liteav.videoproducer.preprocessor;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/preprocessor/i.class */
public final /* synthetic */ class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final h f37072a;
    private final com.tencent.liteav.videobase.a.a b;

    private i(h hVar, com.tencent.liteav.videobase.a.a aVar) {
        this.f37072a = hVar;
        this.b = aVar;
    }

    public static Runnable a(h hVar, com.tencent.liteav.videobase.a.a aVar) {
        return new i(hVar, aVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        h hVar = this.f37072a;
        hVar.o = this.b;
        hVar.b();
    }
}
