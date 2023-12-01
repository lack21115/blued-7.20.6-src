package com.tencent.liteav.videobase.d;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videobase/d/b.class */
final /* synthetic */ class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final a f36622a;

    private b(a aVar) {
        this.f36622a = aVar;
    }

    public static Runnable a(a aVar) {
        return new b(aVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        a.a(this.f36622a);
    }
}
