package com.tencent.liteav.videoproducer.capture;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/capture/av.class */
public final /* synthetic */ class av implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final au f36887a;

    private av(au auVar) {
        this.f36887a = auVar;
    }

    public static Runnable a(au auVar) {
        return new av(auVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f36887a.d();
    }
}
