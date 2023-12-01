package com.tencent.ugc;

import com.tencent.ugc.TXVideoEditer;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/bf.class */
public final /* synthetic */ class bf implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoEditer.TXVideoPreviewListener f40253a;

    private bf(TXVideoEditer.TXVideoPreviewListener tXVideoPreviewListener) {
        this.f40253a = tXVideoPreviewListener;
    }

    public static Runnable a(TXVideoEditer.TXVideoPreviewListener tXVideoPreviewListener) {
        return new bf(tXVideoPreviewListener);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f40253a.onPreviewFinished();
    }
}
