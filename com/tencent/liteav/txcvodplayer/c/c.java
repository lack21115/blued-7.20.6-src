package com.tencent.liteav.txcvodplayer.c;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/txcvodplayer/c/c.class */
public final /* synthetic */ class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final a f36547a;
    private final int b;

    /* renamed from: c  reason: collision with root package name */
    private final String f36548c;
    private final String d;
    private final String e;

    private c(a aVar, int i, String str, String str2, String str3) {
        this.f36547a = aVar;
        this.b = i;
        this.f36548c = str;
        this.d = str2;
        this.e = str3;
    }

    public static Runnable a(a aVar, int i, String str, String str2, String str3) {
        return new c(aVar, i, str, str2, str3);
    }

    @Override // java.lang.Runnable
    public final void run() {
        a.a(this.f36547a, this.b, this.f36548c, this.d, this.e);
    }
}
