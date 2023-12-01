package com.tencent.liteav.videoproducer.capture;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/capture/at.class */
public final /* synthetic */ class at implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final ar f23193a;

    private at(ar arVar) {
        this.f23193a = arVar;
    }

    public static Runnable a(ar arVar) {
        return new at(arVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        ar.a(this.f23193a);
    }
}
