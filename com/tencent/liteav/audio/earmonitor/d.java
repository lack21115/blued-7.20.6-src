package com.tencent.liteav.audio.earmonitor;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/audio/earmonitor/d.class */
final /* synthetic */ class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final a f22550a;

    private d(a aVar) {
        this.f22550a = aVar;
    }

    public static Runnable a(a aVar) {
        return new d(aVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        a.b(this.f22550a);
    }
}
