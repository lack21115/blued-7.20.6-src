package com.tencent.ugc;

import com.tencent.ugc.TXVideoJoiner;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/bz.class */
final /* synthetic */ class bz implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoJoiner f26590a;
    private final TXVideoJoiner.TXVideoPreviewListener b;

    private bz(TXVideoJoiner tXVideoJoiner, TXVideoJoiner.TXVideoPreviewListener tXVideoPreviewListener) {
        this.f26590a = tXVideoJoiner;
        this.b = tXVideoPreviewListener;
    }

    public static Runnable a(TXVideoJoiner tXVideoJoiner, TXVideoJoiner.TXVideoPreviewListener tXVideoPreviewListener) {
        return new bz(tXVideoJoiner, tXVideoPreviewListener);
    }

    @Override // java.lang.Runnable
    public final void run() {
        TXVideoJoiner.lambda$setTXVideoPreviewListener$2(this.f26590a, this.b);
    }
}
