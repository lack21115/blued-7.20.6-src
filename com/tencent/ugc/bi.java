package com.tencent.ugc;

import com.tencent.ugc.TXVideoEditer;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/bi.class */
public final /* synthetic */ class bi implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final int f26565a;
    private final TXVideoEditer.TXVideoGenerateListener b;

    private bi(int i, TXVideoEditer.TXVideoGenerateListener tXVideoGenerateListener) {
        this.f26565a = i;
        this.b = tXVideoGenerateListener;
    }

    public static Runnable a(int i, TXVideoEditer.TXVideoGenerateListener tXVideoGenerateListener) {
        return new bi(i, tXVideoGenerateListener);
    }

    @Override // java.lang.Runnable
    public final void run() {
        TXVideoEditer.lambda$notifyGenerateComplete$61(this.f26565a, this.b);
    }
}
