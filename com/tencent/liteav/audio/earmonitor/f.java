package com.tencent.liteav.audio.earmonitor;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/audio/earmonitor/f.class */
final /* synthetic */ class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final a f22552a;
    private final int b;

    private f(a aVar, int i) {
        this.f22552a = aVar;
        this.b = i;
    }

    public static Runnable a(a aVar, int i) {
        return new f(aVar, i);
    }

    @Override // java.lang.Runnable
    public final void run() {
        a.b(this.f22552a, this.b);
    }
}
