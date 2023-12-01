package com.tencent.ugc;

import com.tencent.ugc.TXVideoEditer;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/bh.class */
public final /* synthetic */ class bh implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoEditer.TXVideoGenerateListener f26564a;
    private final float b;

    private bh(TXVideoEditer.TXVideoGenerateListener tXVideoGenerateListener, float f) {
        this.f26564a = tXVideoGenerateListener;
        this.b = f;
    }

    public static Runnable a(TXVideoEditer.TXVideoGenerateListener tXVideoGenerateListener, float f) {
        return new bh(tXVideoGenerateListener, f);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f26564a.onGenerateProgress(this.b);
    }
}
