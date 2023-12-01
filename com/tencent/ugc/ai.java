package com.tencent.ugc;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/ai.class */
public final /* synthetic */ class ai implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoEditer f26533a;
    private final int b;

    private ai(TXVideoEditer tXVideoEditer, int i) {
        this.f26533a = tXVideoEditer;
        this.b = i;
    }

    public static Runnable a(TXVideoEditer tXVideoEditer, int i) {
        return new ai(tXVideoEditer, i);
    }

    @Override // java.lang.Runnable
    public final void run() {
        TXVideoEditer.lambda$setProfile$4(this.f26533a, this.b);
    }
}
