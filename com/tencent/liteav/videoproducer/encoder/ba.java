package com.tencent.liteav.videoproducer.encoder;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/encoder/ba.class */
public final /* synthetic */ class ba implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final ai f23313a;

    private ba(ai aiVar) {
        this.f23313a = aiVar;
    }

    public static Runnable a(ai aiVar) {
        return new ba(aiVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f23313a.h();
    }
}
