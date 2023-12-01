package com.tencent.liteav.txcvodplayer.c;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/txcvodplayer/c/b.class */
public final /* synthetic */ class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final a f36545a;
    private final int b;

    /* renamed from: c  reason: collision with root package name */
    private final String f36546c;
    private final String d;
    private final String e;
    private final String f;

    private b(a aVar, int i, String str, String str2, String str3, String str4) {
        this.f36545a = aVar;
        this.b = i;
        this.f36546c = str;
        this.d = str2;
        this.e = str3;
        this.f = str4;
    }

    public static Runnable a(a aVar, int i, String str, String str2, String str3, String str4) {
        return new b(aVar, i, str, str2, str3, str4);
    }

    @Override // java.lang.Runnable
    public final void run() {
        a.a(this.f36545a, this.b, this.f36546c, this.d, this.e, this.f);
    }
}
