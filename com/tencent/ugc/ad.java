package com.tencent.ugc;

import com.tencent.ugc.TXVideoEditConstants;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/ad.class */
final /* synthetic */ class ad implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoEditer f26528a;
    private final TXVideoEditConstants.TXThumbnail b;

    private ad(TXVideoEditer tXVideoEditer, TXVideoEditConstants.TXThumbnail tXThumbnail) {
        this.f26528a = tXVideoEditer;
        this.b = tXThumbnail;
    }

    public static Runnable a(TXVideoEditer tXVideoEditer, TXVideoEditConstants.TXThumbnail tXThumbnail) {
        return new ad(tXVideoEditer, tXThumbnail);
    }

    @Override // java.lang.Runnable
    public final void run() {
        TXVideoEditer.lambda$setThumbnail$35(this.f26528a, this.b);
    }
}
