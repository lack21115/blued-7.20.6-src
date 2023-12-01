package com.tencent.ugc;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/au.class */
public final /* synthetic */ class au implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoEditer f40238a;
    private final int b;

    /* renamed from: c  reason: collision with root package name */
    private final String f40239c;

    private au(TXVideoEditer tXVideoEditer, int i, String str) {
        this.f40238a = tXVideoEditer;
        this.b = i;
        this.f40239c = str;
    }

    public static Runnable a(TXVideoEditer tXVideoEditer, int i, String str) {
        return new au(tXVideoEditer, i, str);
    }

    @Override // java.lang.Runnable
    public final void run() {
        TXVideoEditer.lambda$generateVideo$49(this.f40238a, this.b, this.f40239c);
    }
}
