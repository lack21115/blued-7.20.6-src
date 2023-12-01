package com.tencent.liteav.txcvodplayer.c;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/txcvodplayer/c/d.class */
public final /* synthetic */ class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final a f36549a;
    private final String b;

    /* renamed from: c  reason: collision with root package name */
    private final long f36550c;

    private d(a aVar, String str, long j) {
        this.f36549a = aVar;
        this.b = str;
        this.f36550c = j;
    }

    public static Runnable a(a aVar, String str, long j) {
        return new d(aVar, str, j);
    }

    @Override // java.lang.Runnable
    public final void run() {
        a.a(this.f36549a, this.b, this.f36550c);
    }
}
