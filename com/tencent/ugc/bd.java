package com.tencent.ugc;

import com.tencent.ugc.TXVideoEditer;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/bd.class */
public final /* synthetic */ class bd implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoEditer.TXVideoPreviewListener f40251a;
    private final int b;

    private bd(TXVideoEditer.TXVideoPreviewListener tXVideoPreviewListener, int i) {
        this.f40251a = tXVideoPreviewListener;
        this.b = i;
    }

    public static Runnable a(TXVideoEditer.TXVideoPreviewListener tXVideoPreviewListener, int i) {
        return new bd(tXVideoPreviewListener, i);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f40251a.onPreviewProgress(this.b);
    }
}
