package com.tencent.ugc;

import com.tencent.ugc.TXVideoEditer;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/bg.class */
public final /* synthetic */ class bg implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final int f40254a;
    private final TXVideoEditer.TXVideoProcessListener b;

    private bg(int i, TXVideoEditer.TXVideoProcessListener tXVideoProcessListener) {
        this.f40254a = i;
        this.b = tXVideoProcessListener;
    }

    public static Runnable a(int i, TXVideoEditer.TXVideoProcessListener tXVideoProcessListener) {
        return new bg(i, tXVideoProcessListener);
    }

    @Override // java.lang.Runnable
    public final void run() {
        TXVideoEditer.lambda$notifyProcessComplete$59(this.f40254a, this.b);
    }
}
