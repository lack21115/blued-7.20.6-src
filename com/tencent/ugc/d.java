package com.tencent.ugc;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/d.class */
final /* synthetic */ class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoEditer f40312a;
    private final String b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f40313c;

    private d(TXVideoEditer tXVideoEditer, String str, boolean z) {
        this.f40312a = tXVideoEditer;
        this.b = str;
        this.f40313c = z;
    }

    public static Runnable a(TXVideoEditer tXVideoEditer, String str, boolean z) {
        return new d(tXVideoEditer, str, z);
    }

    @Override // java.lang.Runnable
    public final void run() {
        TXVideoEditer.lambda$setBGM$11(this.f40312a, this.b, this.f40313c);
    }
}
