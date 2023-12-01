package com.tencent.liteav.videoproducer.encoder;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/encoder/az.class */
public final /* synthetic */ class az implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final ai f37002a;

    private az(ai aiVar) {
        this.f37002a = aiVar;
    }

    public static Runnable a(ai aiVar) {
        return new az(aiVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        ai.f(this.f37002a);
    }
}
