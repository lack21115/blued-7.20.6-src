package com.tencent.liteav.videoproducer.capture;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/capture/bi.class */
final /* synthetic */ class bi implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final bd f36922a;

    private bi(bd bdVar) {
        this.f36922a = bdVar;
    }

    public static Runnable a(bd bdVar) {
        return new bi(bdVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        bd.c(this.f36922a);
    }
}
