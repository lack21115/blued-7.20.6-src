package com.tencent.ugc;

import com.tencent.ugc.TXVideoEditConstants;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/ad.class */
final /* synthetic */ class ad implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoEditer f40219a;
    private final TXVideoEditConstants.TXThumbnail b;

    private ad(TXVideoEditer tXVideoEditer, TXVideoEditConstants.TXThumbnail tXThumbnail) {
        this.f40219a = tXVideoEditer;
        this.b = tXThumbnail;
    }

    public static Runnable a(TXVideoEditer tXVideoEditer, TXVideoEditConstants.TXThumbnail tXThumbnail) {
        return new ad(tXVideoEditer, tXThumbnail);
    }

    @Override // java.lang.Runnable
    public final void run() {
        TXVideoEditer.lambda$setThumbnail$35(this.f40219a, this.b);
    }
}
