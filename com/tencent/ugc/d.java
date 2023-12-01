package com.tencent.ugc;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/d.class */
final /* synthetic */ class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoEditer f26621a;
    private final String b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f26622c;

    private d(TXVideoEditer tXVideoEditer, String str, boolean z) {
        this.f26621a = tXVideoEditer;
        this.b = str;
        this.f26622c = z;
    }

    public static Runnable a(TXVideoEditer tXVideoEditer, String str, boolean z) {
        return new d(tXVideoEditer, str, z);
    }

    @Override // java.lang.Runnable
    public final void run() {
        TXVideoEditer.lambda$setBGM$11(this.f26621a, this.b, this.f26622c);
    }
}
